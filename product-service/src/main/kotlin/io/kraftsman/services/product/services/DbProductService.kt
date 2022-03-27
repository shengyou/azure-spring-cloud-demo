package io.kraftsman.services.product.services

import io.kraftsman.services.product.contracts.ProductService
import io.kraftsman.services.product.data.dtos.ProductDto
import io.kraftsman.services.product.data.entities.Product
import io.kraftsman.services.product.data.repositories.ProductRepository
import org.springframework.stereotype.Service
import java.text.DecimalFormat

@Service("DbProductService")
class DbProductService constructor(
    private val productRepository: ProductRepository
): ProductService {
    override fun all(): List<ProductDto> = productRepository.findAll().map {
        ProductDto(
            id = it.id,
            name = it.name,
            price = DecimalFormat("#0.00").format(it.price),
        )
    }

    override fun find(id: Int): ProductDto =
        productRepository.findById(id).map {
            ProductDto(
                id = it.id,
                name = it.name,
                price = DecimalFormat("#0.00").format(it.price),
            )
        }.orElseThrow {
            RuntimeException("Product not found")
        }

    override fun create(productDto: ProductDto): ProductDto =
        Product(
            id = 0,
            name = productDto.name,
            price = productDto.price.toDouble()
        ).run {
            productRepository.save(this)
        }.let {
            ProductDto(
                id = it.id,
                name = it.name,
                price = DecimalFormat("#0.00").format(it.price),
            )
        }

    override fun update(productDto: ProductDto): ProductDto =
        productRepository.findById(productDto.id).map { product ->
            productRepository.save(
                Product(
                    id = product.id,
                    name = productDto.name,
                    price = productDto.price.toDouble()
                )
            ).let {
                ProductDto(
                    id = it.id,
                    name = it.name,
                    price = DecimalFormat("#0.00").format(it.price),
                )
            }
        }.orElseThrow {
            RuntimeException("Product not found")
        }

    override fun delete(id: Int): ProductDto =
        productRepository.findById(id).map {
            productRepository.deleteById(id)
            ProductDto(
                id = it.id,
                name = it.name,
                price = DecimalFormat("#0.00").format(it.price),
            )
        }.orElseThrow {
            RuntimeException("Product not found")
        }
}
