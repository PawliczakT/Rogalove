package com.rogale.rogalove.controllers

import com.rogale.rogalove.models.Rating
import com.rogale.rogalove.models.Rogal
import com.rogale.rogalove.services.RatingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/ratings")
class RatingController(@Autowired private val ratingService: RatingService) {


    @PostMapping("/rogal/{rogalName}")
    fun addRatingToRogal(@RequestBody rating: Rating, @PathVariable rogalName: String): Rogal {
        return ratingService.addRatingToRogal(rogalName, rating)
    }
}
