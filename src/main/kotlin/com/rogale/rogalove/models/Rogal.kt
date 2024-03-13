package com.rogale.rogalove.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "rogals")
data class Rogal(

        @Id
        val name: String,

        val imageUrl: String?,

        val description: String,

        val price: Double,

        val weight: Double,

        var ratings: MutableList<Rating> = mutableListOf(),

        var averageRating: Double = 0.0

)
