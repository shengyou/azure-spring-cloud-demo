package io.kraftsman.services.product.controllers

import com.github.javafaker.Faker
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController {

    @Value("\${application.message:Not configured by a Spring Cloud Server}")
    private lateinit var message: String

    private val faker = Faker.instance()

    @GetMapping("/products/message")
    fun index(): Map<String, String> = mapOf(
        "message" to message,
        "lorem" to faker.lorem().sentence(),
    )
}
