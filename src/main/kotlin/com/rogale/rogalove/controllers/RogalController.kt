package com.rogale.rogalove.controllers

import com.rogale.rogalove.models.Rogal
import com.rogale.rogalove.repositories.RogalRepository
import com.rogale.rogalove.services.RogalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/rogale")
class RogalController(@Autowired private val rogalService: RogalService, @Autowired private val rogalRepository: RogalRepository) {

    @PostMapping
    fun addRogal(@RequestBody rogal: Rogal): Rogal {
        return rogalService.save(rogal)
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

}
