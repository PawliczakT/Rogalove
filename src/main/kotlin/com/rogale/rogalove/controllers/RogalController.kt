package com.rogale.rogalove.controllers

import com.rogale.rogalove.models.Rogal
import com.rogale.rogalove.repositories.RogalRepository
import com.rogale.rogalove.services.RogalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/rogals")
class RogalController(private val rogalService: RogalService) {

    @PostMapping
    fun addRogal(@RequestBody rogal: Rogal): Rogal {
        return rogalService.addRogal(rogal)
    }

    @GetMapping
    fun getAllRogaleOrdered(): List<Rogal> = rogalService.getAllRogaleOrdered()

    @GetMapping("/top-rated")
    fun getTopRatedRogale(): List<Rogal> = rogalService.getTopRatedRogale()

    @GetMapping("/rogale")
    fun getAllRogale(): ResponseEntity<List<Rogal>> {
        val rogale = rogalService.findAll()
        return ResponseEntity.ok(rogale)
    }

    @GetMapping("/{rogalName}/average-rating")
    fun getRogalAverageRating(@PathVariable rogalName: String): ResponseEntity<Double> {
        val averageRating = rogalService.getAverageRatingForRogal(rogalName)
        return ResponseEntity.ok(averageRating)
    }

    @PostMapping("/create")
    fun createRogal(@RequestBody createRogalDto: RogalService.CreateRogalDto): ResponseEntity<Rogal> {
        val rogal = rogalService.createRogal(createRogalDto)
        return ResponseEntity.ok(rogal)
    }

}
