# Use a base image with JDK for building the application
FROM openjdk:21-jdk-slim AS build

# Set the working directory
WORKDIR /app

# Copy the Gradle wrapper and build files
COPY gradlew .
COPY gradle ./gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .

# Copy the source code
COPY src ./src

# Build the application
RUN ./gradlew build -x test

# Use a smaller base image for the final image
FROM openjdk:21-jdk-slim

# Copy the jar file from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Specify the command to run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]