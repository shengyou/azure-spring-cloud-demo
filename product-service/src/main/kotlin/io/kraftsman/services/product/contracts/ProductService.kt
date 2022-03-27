package io.kraftsman.services.product.contracts

import io.kraftsman.services.product.data.dtos.ProductDto

interface ProductService {

    fun all(): List<ProductDto>

    fun find(id: Int): ProductDto

    fun create(productDto: ProductDto): ProductDto

    fun update(productDto: ProductDto): ProductDto

    fun delete(id: Int): ProductDto
}