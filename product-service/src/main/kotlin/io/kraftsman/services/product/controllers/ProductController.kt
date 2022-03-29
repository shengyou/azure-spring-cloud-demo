package io.kraftsman.services.product.controllers

import io.kraftsman.services.product.contracts.ProductService
import io.kraftsman.services.product.data.dtos.ProductDto
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController constructor(
    @Qualifier("DbProductService") private val productService: ProductService
) {

    @GetMapping
    fun index(): Map<String, List<ProductDto>> {
        val products = productService.all()

        return mapOf("data" to products)
    }

    @PostMapping
    fun store(@RequestBody productDto: ProductDto): ProductDto =
        productService.create(productDto)

    @GetMapping("{id}")
    fun show(@PathVariable id: Int): ProductDto =
        productService.find(id)

    @PatchMapping
    fun update(@RequestBody productDto: ProductDto): ProductDto =
        productService.update(productDto)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): ProductDto =
        productService.delete(id)
}
