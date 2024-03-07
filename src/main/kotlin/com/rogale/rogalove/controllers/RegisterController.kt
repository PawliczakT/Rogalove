package com.rogale.rogalove.controllers

import com.rogale.rogalove.models.RegisterForm
import com.rogale.rogalove.models.User
import com.rogale.rogalove.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/register")
class RegisterController(
    @Autowired private val userService: UserService,
    @Autowired private val passwordEncoder: BCryptPasswordEncoder) {

    @PostMapping
    fun register(@RequestBody form: RegisterForm): User {
        val user = User(
            username = form.username,
            email = form.email,
            password = passwordEncoder.encode(form.password)
        )
        return userService.save(user)
    }

//    @GetMapping
//    fun getAllUsers(): List<User> = userService.findAll()

//    @GetMapping
//    fun getRegisterForm(): String {
//        // Return some data for the register form
//        return "Register form data"
//    }
}
