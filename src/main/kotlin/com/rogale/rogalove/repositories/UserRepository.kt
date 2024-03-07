package com.rogale.rogalove.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import com.rogale.rogalove.models.User

@Repository
interface UserRepository : MongoRepository<User, Long> {
    fun findByUsername(username: String): User?
    fun findByEmail(email: String): User?
}