package edu.greenriver.it.springfirstproject.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController {
    // Define a route
    @RequestMapping(path = ["", "/", "/index", "index.html", "/home"])
    fun getIndex() : String {
        // "index" is the name of my template (view)
        return "index"
    }
}