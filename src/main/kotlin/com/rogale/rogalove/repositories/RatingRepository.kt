package com.rogale.rogalove.repositories

import com.rogale.rogalove.models.Rating
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface RatingRepository : MongoRepository<Rating, String> {

    fun findByRogalId(rogaleId: String?): List<Rating?>?
}