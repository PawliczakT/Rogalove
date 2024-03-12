package com.rogale.rogalove.services

import com.rogale.rogalove.models.Rogal
import com.rogale.rogalove.repositories.RogalRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service


@Service
class RogalService(@Autowired private val rogalRepository: RogalRepository) {

    fun getAllRogaleOrdered(): List<Rogal> {
        val pageable = PageRequest.of(0, Int.MAX_VALUE)
        return rogalRepository.findAllOrdered(pageable)
    }

    fun getTopRatedRogale(): List<Rogal> {
        val pageable = PageRequest.of(0, 3)
        return rogalRepository.findTopRatedRogale(pageable)
    }

    fun findById(id: String): Rogal? = rogalRepository.findById(id).orElse(null)

    fun add(rogal: Rogal): Rogal = rogalRepository.save(rogal)

    fun findAll(): List<Rogal> = rogalRepository.findAll()

    fun deleteById(id: String) = rogalRepository.deleteById(id)

}
