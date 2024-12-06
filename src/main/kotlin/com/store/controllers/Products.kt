package com.store.controllers

import com.store.model.*
import com.store.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import jakarta.validation.Valid

@RestController
@RequestMapping("/products")
class Products(private val productService: ProductService) {


    @PostMapping
    fun createProduct(@Valid @RequestBody request: CreateProductRequest): ResponseEntity<CreateProductResponse> {
        val product = productService.createProduct(
                name = request.name,
                type = request.type,
                inventory = request.inventory
        )
        return ResponseEntity.status(201).body(CreateProductResponse(product.id))
    }

    @GetMapping
    fun getProducts(@RequestParam(required = false) type: ProductType?): List<ProductResponse> {
        var productsByType: List<Product>? = null;

        if (type != null) {
            productsByType = productService.getProductsByType(type)
        } else {
            productsByType = productService.getAllProducts()
        }

        return productsByType.map { product ->
            ProductResponse(
                    id = product.id,
                    name = product.name,
                    type = product.type,
                    inventory = product.inventory
            )
        }
    }
}
