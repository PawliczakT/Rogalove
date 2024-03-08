package com.rogale.rogalove.controllers

import com.rogale.rogalove.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import com.rogale.rogalove.models.User
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserProfileController(@Autowired private val userService: UserService) {

    @GetMapping
    fun getProfile(@AuthenticationPrincipal userDetails: UserDetails): User {
        val username = userDetails.username
        return userService.findByUsername(username)
                ?: throw RuntimeException("User not found with username: $username")
    }

    @PostMapping
    fun createUser(@RequestBody createUserDto: UserService.CreateUserDto): ResponseEntity<Any> {
        return try {
            val user = userService.createUser(createUserDto)
            ResponseEntity.ok(user)
        } catch (e: Exception) {
            ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
        }
    }

    data class UserDto(val username: String, val password: String, val email: String, val roles: Any?)
}
