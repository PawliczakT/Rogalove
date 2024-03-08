package com.rogale.rogalove.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class VueController {

    @GetMapping("/")
    fun index(): ModelAndView {
        return ModelAndView("index")
    }

    // Since you are using history mode in Vue Router,
    // you don't need the catch-all route handler here.
}
