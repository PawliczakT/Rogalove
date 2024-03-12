package com.rogale.rogalove.controllers

import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.mvc.support.RedirectAttributes


@Controller
class LoginController {
    @GetMapping("/login")
    fun showLoginForm(): String {
        return "login"
    }

    @PostMapping("/login")
    fun login(
        @RequestParam username: String?,
        @RequestParam password: String?,
        result: BindingResult,
        redirectAttributes: RedirectAttributes?
    ): String {
        // Perform authentication logic here
        // If authentication fails, add errors to BindingResult and return to login page
        return if (result.hasErrors()) {
            "login"
        } else "redirect:/"

        // On successful authentication, redirect to the home page or dashboard
    }
}
