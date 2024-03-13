package com.rogale.rogalove.services

import com.rogale.rogalove.repositories.RatingRepository
import com.rogale.rogalove.models.Rating
import com.rogale.rogalove.models.Rogal
import com.rogale.rogalove.repositories.RogalRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RatingService(@Autowired private val ratingRepository: RatingRepository, @Autowired private val rogalRepository: RogalRepository) {

    fun findAll(): List<Rating> = ratingRepository.findAll()

    fun findById(id: Long): Rating? = ratingRepository.findById(id).orElse(null)

    fun save(rating: Rating): Rating = ratingRepository.save(rating)

    fun deleteById(id: Long) = ratingRepository.deleteById(id)

    fun addRatingToRogal(rogalId: String, rating: Rating): Rogal {
        val rogal = rogalRepository.findById(rogalId).orElseThrow {
            throw Exception("Rogal not found with id: $rogalId")
        }

        // Dodaj ocenę do listy ocen rogala
        rogal.ratings.add(rating)

        // Oblicz nową średnią ocenę
        val newAverageRating = rogal.ratings.map { it.rate }.average()
        rogal.averageRating = newAverageRating

        // Zapisz zaktualizowanego rogala
        return rogalRepository.save(rogal)
    }
}
