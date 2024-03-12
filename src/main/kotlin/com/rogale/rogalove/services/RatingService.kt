package com.rogale.rogalove.services

import com.rogale.rogalove.models.Rating
import com.rogale.rogalove.repositories.RatingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class RatingService @Autowired constructor(private val ratingRepository: RatingRepository) {
    fun addRating(newRating: Rating): Rating {
        return ratingRepository.save(newRating)
    }

    fun getRatingsByRogalId(rogaleId: String?): List<Rating?>? {
        return ratingRepository.findByRogalId(rogaleId)
    }
}

