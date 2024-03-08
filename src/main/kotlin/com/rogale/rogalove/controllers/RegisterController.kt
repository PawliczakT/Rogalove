package com.rogale.rogalove.controllers

import com.rogale.rogalove.models.RegisterForm
import com.rogale.rogalove.models.User
import com.rogale.rogalove.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/register")
class RegisterController(
    private val userService: UserService,
    private val passwordEncoder: BCryptPasswordEncoder
) {

    @PostMapping
    fun register(@RequestBody form: RegisterForm): ResponseEntity<Any> {
        // Check if user already exists to avoid duplicate usernames or emails
        if (userService.existsByUsernameOrEmail(form.username, form.email)) {
            return ResponseEntity.badRequest().body(mapOf("message" to "User already exists with the given username or email."))
        }

        val encodedPassword = passwordEncoder.encode(form.password)
        val newUser = User(
            username = form.username,
            email = form.email,
            password = encodedPassword
        )

        userService.save(newUser)

        // Return a response indicating successful registration without returning the user object
        return ResponseEntity.ok(mapOf("message" to "User registered successfully."))
    }
}
