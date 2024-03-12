package com.rogale.rogalove.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class VueController {

    @RequestMapping("/")
    fun index(): String {
        return "forward:/index.html"
    }
}


