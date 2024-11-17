package com.example.demo.data

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/api/profile")
class ProfileController {

    /**
     * Handles GET requests to /api/greeting.
     *
     * @return A Greeting object containing a welcome message.
     */
    @RequestMapping("/greetings")
    @ResponseBody
    fun greetings(@RequestParam name: String): Greeting = Greeting("Greetings $name")

    /**
     * Handles GET requests to /api/quote.
     *
     * This endpoint is intended to fetch a random quote from an external API.
     *
     * @return A Quote object (to be implemented).
     * @todo Fetch from https://api.api-ninjas.com/v1/quotes?category=happiness
     */
    @RequestMapping("/quote")
    @ResponseBody
    fun quote(@RequestParam category: String): Quote = Quote()

    /**
     * Handles GET requests to /api/age.
     *
     * This endpoint estimates the age based on the provided name.
     *
     * @param name The name for which to estimate the age.
     * @return An Age object (to be implemented).
     * @todo Fetch from https://api.agify.io?name=<name>
     */
    @RequestMapping("/age")
    @ResponseBody
    fun age(@RequestParam name: String): Age = Age()

    /**
     * Handles GET requests to /api/joke.
     *
     * This endpoint fetches a random Chuck Norris joke from an external API.
     *
     * @return A Joke object (to be implemented).
     * @todo Fetch from https://api.chucknorris.io/jokes/random
     */
    @RequestMapping("/joke")
    @ResponseBody
    fun joke(): Joke = Joke()

    /**
     * Handles GET requests to /api/profile-picture.
     *
     * This endpoint is intended to fetch a random profile picture.
     *
     * @return A ProfilePicture object.
     * @todo Fetch from an appropriate source.
     */
    @RequestMapping("/profile-picture")
    @ResponseBody
    fun profilePicture(): ProfilePicture = ProfilePicture()
}

data class Greeting(val greeting: String)

data class Quote (
    val quote: String = "It is not the possession of truth, but the success which attends the seeking after it, that enriches the seeker and brings happiness to him.",
    val author: String = "Max Planck",
    val category: String = "happiness"
)

data class Age(val age: Int = 35)

data class Joke(val value: String = "Unlike lions and tigers, Chuck Norris would never eat a dead zebra ass first")

data class ProfilePicture(val message: String = "https:\\/\\/images.dog.ceo\\/breeds\\/kombai\\/Kombai-indian-Dog.jpg")