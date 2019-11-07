package edu.greenriver.it.springfirstproject.controllers

import edu.greenriver.it.springfirstproject.repositories.IMessageRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController(val repo: IMessageRepository) {
    // Define a route
    @RequestMapping(path = ["", "/", "/index", "/index.html", "/home"])
    fun getIndex(model: Model): String {
        val messages = repo.findAll()
        model.addAttribute("messages", messages)

        //index is the name of my template (view)
        return "index"
    }
}