package com.rogale.rogalove.controllers

import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class VueController {

    // Catch-all endpoint for routing to Vue.js
    @RequestMapping(value = ["/{path:[^\\.]*}"])
    fun redirect(request: HttpServletRequest): String {
        // Forward to home page so that route is preserved.
        return "forward:/"
    }
}

