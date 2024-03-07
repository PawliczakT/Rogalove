package com.rogale.rogalove.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import com.rogale.rogalove.models.Rating

@Repository
interface RatingRepository : MongoRepository<Rating, Long> {
}