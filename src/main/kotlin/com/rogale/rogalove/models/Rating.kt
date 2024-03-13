package com.rogale.rogalove.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "ratings")
data class Rating(
        @Id
        val id: String? = null,
        val userId: String? = null,
        val rogalName: String? = null,
        val rate: Double,
        val comment: String? = null
)