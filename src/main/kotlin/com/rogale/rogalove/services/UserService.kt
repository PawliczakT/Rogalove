package com.rogale.rogalove.services

import com.rogale.rogalove.models.User
import com.rogale.rogalove.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserService(@Autowired private val userRepository: UserRepository) : UserDetailsService {

    fun findAll(): List<User> = userRepository.findAll()

    fun findByUsername(username: String): User? = userRepository.findByUsername(username)

    fun findByEmail(email: String): User? = userRepository.findByEmail(email)

    fun findById(id: Long): User? = userRepository.findById(id).orElse(null)

    fun save(user: User): User = userRepository.save(user)

    fun deleteById(id: Long) = userRepository.deleteById(id)

    fun existsByUsernameOrEmail(username: String, email: String): Boolean {
        return userRepository.existsByUsername(username) || userRepository.existsByEmail(email)
    }

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("User not found with username: $username")
        return org.springframework.security.core.userdetails.User
            .withUsername(username)
            .password(user.password)
            .authorities(emptyList())
            .accountExpired(false)
            .accountLocked(false)
            .credentialsExpired(false)
            .disabled(false)
            .build()
    }
}