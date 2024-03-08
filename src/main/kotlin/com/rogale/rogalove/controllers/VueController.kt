package com.rogale.rogalove.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class VueController {
    @RequestMapping(value = ["/{path:[^\\.]*}"])
    fun redirect(@PathVariable path: String): String {
        return "forward:/index.html"
    }
}
