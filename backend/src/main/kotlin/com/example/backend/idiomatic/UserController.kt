package com.example.backend.idiomatic

import org.springframework.web.bind.annotation.*
import java.util.*

typealias UserInfo = Map<String, String>

@RestController()
@RequestMapping("/idiomatic")
class UserController {

    /**
     * - Chaining nullable fields
     */
    @GetMapping(path = ["/user"])
    fun get(): User {
        val user = User("John",
                Address("MainStreet", City("Boston")))

        user.address?.city?.country = Country("US")
        return user;
    }

    /**
     * - Call an extension method
     * - Inline return, if-else is an expression
     * - Use named parameters
     */
    @PostMapping(path = ["/user"])
    fun post(@RequestBody user: User): User {

        return if(user.isComplete()){
            user;
        } else {
            user.apply {
                this.address =
                    Address(
                        street = "MainStreet",
                        city = City(
                            name ="Boston",
                            country = Country("US")))
            }
        }
    }

    /**
     * - Use a typealias
     * - Some tricks with reflection
     */
    @GetMapping(path = ["/info"])
    fun info(): UserInfo {
        val user = get()
        return mapOf(
            "user class name" to user::class.java.name,
            "some field name" to user::someWeirdName.name
        );
    }

    /**
     * - T0D0 helps to fail on not implemented functions
     */
    @GetMapping(path = ["/todo"])
    fun todo(): Nothing {
        TODO("This is not implemented yet and will blow up!")
    }

    /**
     * - Short scale functions
     * - Field access == getter access
     * - Use when whenever you can
     */
    @GetMapping(path = ["/locale"])
    fun locale(): Locale = when (Locale.getDefault().displayCountry.toLowerCase()) {
        "germany", "austria" -> Locale.GERMAN
        "usa", "great britain" -> Locale.ENGLISH
        "france" -> Locale.FRENCH
        else -> Locale.ENGLISH
    }

    /**
     * - Automatically infer type
     * - Use of build in lambdas
     * - No need of equals() on strings
     */
    @GetMapping(path = ["/lambdas"])
    fun lambdas(): List<String> {
        val list = listOf("Helsinki:Finland",
                "Berlin:Germany",
                "Liverpool:UK",
                "Munich:Germany",
                "Copenhagen:Denmark",
                "Dublin:Ireland",
                "Porto:Portugal")

        return list.sorted().map {
            it.split(":")
        }.filter { it[1] == "Germany" }
            .map { it[0] }
    }
}

/**
 * - Declare an extension method
 * - Use build in functions to check emptiness
 */
private fun User.isComplete(): Boolean {
    if(this.address == null || this.address?.street.isNullOrBlank()) {
        return false
    }
    return true
}
