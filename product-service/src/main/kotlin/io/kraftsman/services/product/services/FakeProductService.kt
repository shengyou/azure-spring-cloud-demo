package io.kraftsman.services.product.services

import com.github.javafaker.Faker
import io.kraftsman.services.product.contracts.ProductService
import io.kraftsman.services.product.data.dtos.ProductDto
import org.springframework.stereotype.Service

@Service("FakeProductService")
class FakeProductService : ProductService {

    private val faker = Faker.instance()

    override fun all(): List<ProductDto> =
        (1..10).map {
            ProductDto(
                id = it,
                name = faker.commerce().productName(),
                price = faker.commerce().price(),
            )
        }

    override fun find(id: Int): ProductDto =
        ProductDto(
            id = id,
            name = faker.commerce().productName(),
            price = faker.commerce().price(),
        )

    override fun create(productDto: ProductDto): ProductDto =
        ProductDto(
            id = (1..100).shuffled().first(),
            name = productDto.name,
            price = productDto.price
        )

    override fun update(productDto: ProductDto): ProductDto = productDto

    override fun delete(id: Int): ProductDto =
        ProductDto(
            id = id,
            name = faker.commerce().productName(),
            price = faker.commerce().price(),
        )
}
