package com.rogale.rogalove.models

data class RogalStats(
        val id: Long,
        val name: String,
        val imageUrl: String,
        val totalVotes: Int,
        val averageRating: Double
)
