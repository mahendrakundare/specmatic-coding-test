package com.store.model

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.deser.std.StringDeserializer
import com.store.config.StrictStringDeserializer
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class CreateProductRequest(
        @JsonDeserialize(using = StrictStringDeserializer::class)
        @field:NotBlank(message = "Name must not be empty or null")
        val name: String,

        @field:NotNull(message = "Type must not be null")
        val type: ProductType,

        @field:Min(value = 1, message = "Inventory must be at least 0")
        @field:Max(value = 9999, message = "Inventory must be at least 0")
        @field:NotNull(message = "Inventory must not be null")
        val inventory: Int,

        @field:Min(value = 1, message = "cost must be at least 0")
        @field:Max(value = 9999, message = "cost must be at least 0")
        @field:NotNull(message = "cost must not be null")
        val cost: Int,
)
