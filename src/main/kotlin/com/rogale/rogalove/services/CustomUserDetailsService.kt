package com.rogale.rogalove.services

import com.rogale.rogalove.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service


@Service
class CustomUserDetailsService @Autowired constructor(private val userRepository: UserRepository) : UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user: com.rogale.rogalove.models.User = userRepository.findByUsername(username)
            .orElseThrow { UsernameNotFoundException("User not found with username or email : $username") }
        return User(user.username, user.password, ArrayList())
    }
}

