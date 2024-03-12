package com.rogale.rogalove.controllers


import com.rogale.rogalove.services.UserService
import com.rogale.rogalove.models.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class AuthController {
    @Autowired
    private val authenticationManager: AuthenticationManager? = null

    @Autowired
    private val userService: UserService? = null

    @Autowired

    @PostMapping("/api/auth/login")
    fun authenticateUser(@RequestBody loginRequest: User): ResponseEntity<*> {
        val authentication = authenticationManager!!.authenticate(
            UsernamePasswordAuthenticationToken(
                loginRequest.username,
                loginRequest.password
            )
        )
        SecurityContextHolder.getContext().authentication = authentication
        return ResponseEntity.ok(jwt)
    } // Inne metody (rejestracja itd.)
}

