package io.kraftsman.services.cart.controllers

import com.github.javafaker.Faker
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CartController {

    @Value("\${application.message:Not configured by a Spring Cloud Server}")
    private lateinit var message: String

    @GetMapping("/api/v1/cart")
    fun index(): Map<String, String> {
        return mapOf("message" to message)
    }

    @GetMapping("/api/v1/cart/random")
    fun random(): Map<String, String> {
        val faker = Faker.instance()

        return mapOf("message" to faker.lorem().sentence())
    }
}
