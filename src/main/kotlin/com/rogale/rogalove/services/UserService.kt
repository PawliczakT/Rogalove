package com.rogale.rogalove.services

import com.rogale.rogalove.models.User
import com.rogale.rogalove.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*


@Service
class UserService(
    @Autowired private val userRepository: UserRepository,
    private val passwordEncoder: BCryptPasswordEncoder
) : UserDetailsService {

    fun findAll(): List<User> = userRepository.findAll()

    fun findByUsername(username: String): User? = userRepository.findByUsername(username)

    fun findByEmail(email: String): User? = userRepository.findByEmail(email)

    fun findById(id: String): User? = userRepository.findById(id).orElse(null)

    fun save(user: User): User = userRepository.save(user)

    fun deleteById(id: String) = userRepository.deleteById(id)

    fun existsByUsernameOrEmail(username: String, email: String): Boolean {
        return userRepository.existsByUsername(username) || userRepository.existsByEmail(email)
    }

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("User not found with username: $username")

        return org.springframework.security.core.userdetails.User
            .withUsername(user.username)
            .password(user.password)
            .authorities(listOf(SimpleGrantedAuthority(user.role)))
            .accountExpired(false)
            .accountLocked(false)
            .credentialsExpired(false)
            .disabled(false)
            .build()
    }

    data class CreateUserDto(
        val id: String,
        val username: String,
        val email: String,
        val password: String,
        val role: String,
    )

    @Transactional
    fun createUser(createUserDto: CreateUserDto): User {
        if (userRepository.existsByUsername(createUserDto.username)) {
            throw Exception("Username already taken")
        }

        if (userRepository.existsByEmail(createUserDto.email)) {
            throw Exception("Email already in use")
        }

        val encodedPassword = passwordEncoder.encode(createUserDto.password)
        val newUser = User(
            UUID.randomUUID().toString(),
            createUserDto.username,
            createUserDto.email,
            encodedPassword,
            createUserDto.role
        )
        return userRepository.save(newUser)
    }
}
