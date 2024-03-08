package com.rogale.rogalove.controllers

import com.rogale.rogalove.models.RegisterForm
import com.rogale.rogalove.models.User
import com.rogale.rogalove.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/register")
class RegisterController(
    private val userService: UserService,
    private val passwordEncoder: BCryptPasswordEncoder
) {

    @PostMapping
    fun register(@RequestBody form: RegisterForm): ResponseEntity<Any> {
        if (userService.existsByUsernameOrEmail(form.username, form.email)) {
            return ResponseEntity.badRequest().body(mapOf("message" to "User already exists with the given username or email."))
        }
        val userId = UUID.randomUUID().toString()
        val encodedPassword = passwordEncoder.encode(form.password)
        val newUser = User(
            id = userId,
            username = form.username,
            email = form.email,
            password = encodedPassword,
            role = "USER"
        )

        userService.save(newUser)

        return ResponseEntity.ok(mapOf("message" to "User registered successfully."))
    }
}
