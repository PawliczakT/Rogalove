package com.rogale.rogalove.services

import com.rogale.rogalove.models.Rogal
import com.rogale.rogalove.repositories.RogalRepository
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service


@Service
class RogalService(private val rogalRepository: RogalRepository) {

    fun getAllRogaleOrdered(): List<Rogal> {
        val pageable = PageRequest.of(0, Int.MAX_VALUE)
        return rogalRepository.findAllOrdered(pageable)
    }

    fun getTopRatedRogale(): List<Rogal> {
        val pageable = PageRequest.of(0, 3)
        return rogalRepository.findTopRatedRogale(pageable)
    }

    fun findAll(): List<Rogal> = rogalRepository.findAll()

    fun findByName(name: String): Rogal? = rogalRepository.findByName(name)

    fun findById(id: String): Rogal? = rogalRepository.findById(id).orElse(null)

    fun addRogal(rogal: Rogal): Rogal = rogalRepository.save(rogal)

    fun deleteById(id: String) {
        try {
            rogalRepository.deleteById(id)
        } catch (e: EmptyResultDataAccessException) {
            throw NoSuchElementException("Rogal not found with id: $id")
        }
    }

    fun existsByName(name: String): Boolean = rogalRepository.existsByName(name)

    data class CreateRogalDto(
        val name: String,
        val imageUrl: String,
        val description: String,
        val price: Double,
        val weight: Double,
    )

    fun createRogal(createRogalDto: CreateRogalDto): Rogal {
        if (existsByName(createRogalDto.name)) {
            throw Exception("Rogal with the given name already exists")
        }

        val newRogal = Rogal(
            name = createRogalDto.name,
            imageUrl = createRogalDto.imageUrl,
            description = createRogalDto.description,
            price = createRogalDto.price,
            weight = createRogalDto.weight,
        )

        return rogalRepository.save(newRogal)
    }

    fun getAverageRatingForRogal(rogalName: String): Double {
        val rogal: Rogal = rogalRepository.findById(rogalName).orElseThrow {
            throw Exception("Rogal not found with id: $rogalName")
        }
        return if (rogal.ratings.isNotEmpty()) {
            rogal.ratings.map { it.rate }.average()
        } else 0.0
    }
}
