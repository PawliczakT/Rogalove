package com.rogale.rogalove.controllers

import com.rogale.rogalove.models.RogalStats
import com.rogale.rogalove.services.RogalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/stats")
class RogalStatsController(@Autowired private val rogalService: RogalService) {

//    @GetMapping
//    fun getRogalStats(): List<RogalStats> {
//        return rogalService.getRogalStats()
//    }
}
