# Project README

## Overview

This project is a Spring Boot application that exposes endpoints through the `ProfileController.kt` controller. The goal is to consume external APIs, convert the application to a GraphQL API and deploy it in a Kubernetes cluster. The following steps should be followed:

1. Consume data from external APIs as described in the todos of the `ProfileController.kt` file.
2. Modify the existing app to expose the `ProfileController.kt` data according to the specified GraphQL schema.
3. (Optional) Update the React frontend to interact with the GraphQL API instead of the controller endpoints.
4. Dockerize the application.
5. Deploy the application in a Minikube cluster (or an alternative Kubernetes cluster).

## Prerequisites

- Java 21
- Yarn
- Docker
- Minikube (or alternative Kubernetes distro)

## Steps to Extend the Application

### 1. Consume External APIs
To enhance the ProfileController.kt, you will need to consume data from external APIs as specified in the todos.

#### Instructions:
* Identify the external APIs you need to integrate (e.g., for quotes, jokes, or profile pictures).
* Use a library like RestTemplate or WebClient to make HTTP requests to these APIs.
* Implement the logic in the ProfileController.kt to fetch and return the required data.
* Ensure proper error handling and data validation when consuming external APIs.

### 2. Modify the Existing API

To expose data according to the following GraphQL schema:

```graphql
type Profile {
  age(name: String!): Int
  quote(category: String!): String
  joke: String
  profilePicture: String
}

type Query {
  profile: Profile
}
```

#### Instructions:
* Create query resolver for the Profile type.
* Create field resolvers to handle the age, quote, joke, and profilePicture fields.
* Ensure that the profile query returns an instance of Profile.

### 3. (Optional) Update the React frontend to interact with the GraphQL API
Develop a React application that interacts with the GraphQL API to read and display the data.

#### Instructions:
* Install GraphQL client to manage data fetching.
* Update the landing page to consume data from the GraphQL API.
* Ensure the frontend makes queries to the GraphQL API and handles responses appropriately.

### 4. Dockerize the Application
Create a Dockerfile to containerize both the Spring Boot backend and the React frontend.

#### Instructions:
* Create a Dockerfile to build the application.
* Use a multi-stage build to compile the application and build the image.
* Run the docker image.

### 5. Deploy the Application in a Kubernetes Cluster
Expose the application as a service in a Minikube cluster.

#### Instructions:
* Build the Docker images with minikube's Docker daemon.
  * Set environment variables: `eval $(minikube docker-env)`
  * Build the Docker images.
* Create a Kubernetes deployment and service YAML files for the app.
* Apply the configurations using kubectl.
  * Run `kubectl port-forward service/backend 8080:8080` to expose the backend locally.
  * Run `kubectl port-forward service/frontend 5173:5173` to expose the frontend locally.
* Verify that the API is available.