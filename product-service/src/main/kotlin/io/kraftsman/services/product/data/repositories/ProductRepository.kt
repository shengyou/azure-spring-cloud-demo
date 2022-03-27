package io.kraftsman.services.product.data.repositories

import io.kraftsman.services.product.data.entities.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Int>, JpaSpecificationExecutor<Product>
