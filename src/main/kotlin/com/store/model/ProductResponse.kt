package com.store.model

data class ProductResponse(
        val id: Long,
        val name: String,
        val type: ProductType,
        val inventory: Int,
        val cost: Int
)
