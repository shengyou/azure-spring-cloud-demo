package io.kraftsman.services.product.controllers

import com.github.javafaker.Faker
import io.kraftsman.services.product.contracts.ProductService
import io.kraftsman.services.product.data.dtos.ProductDto
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PopulateController constructor(
    @Qualifier("DbProductService") private val productService: ProductService
) {

    private val faker = Faker.instance()

    @GetMapping("/products/populate")
    fun index(): Unit {
        repeat(10) {
            productService.create(
                ProductDto(
                    id = 0,
                    name = faker.commerce().productName(),
                    price = faker.commerce().price(1.0, 1000.0),
                )
            )
        }
    }
}
