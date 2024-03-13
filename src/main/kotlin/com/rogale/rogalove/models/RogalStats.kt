package com.rogale.rogalove.models

import org.springframework.data.annotation.Id

data class RogalStats(
        @Id
        val id: String,
        val rogalName: String,
        val imageUrl: String,
        val totalVotes: Int,
        val averageRating: Double
)
