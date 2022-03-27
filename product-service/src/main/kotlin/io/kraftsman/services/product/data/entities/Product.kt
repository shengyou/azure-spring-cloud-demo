package io.kraftsman.services.product.data.entities

import javax.persistence.*

@Entity
@Table(name = "products")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    val id: Int,

    @Column(name = "name")
    val name: String,

    @Column(name = "price")
    val price: Double,
)
