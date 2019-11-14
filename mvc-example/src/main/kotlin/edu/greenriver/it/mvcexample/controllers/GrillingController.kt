package edu.greenriver.it.mvcexample.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/cooking/grilling")
class GrillingController {
    val tips = listOf(
            "Preheat the Grill.",
            "Keep it Clean.",
            "Oil the Food, Not the Grate.",
            "Keep the Lid Down.",
            "Time and Temperature.",
            "Know When to Be Direct, Know When to be Indirect.",
            "Maintaining Temperatures.",
            "Tame the Flame."
    )

    @RequestMapping("/random")
    @ResponseBody
    fun randomGrillingTip(): String {
        val tip = tips.random()
        return "<h1>A random tip</h1><p>$tip</p>"
    }

    @RequestMapping(path = ["", "/", "/all"])
    @ResponseBody
    fun grillTips(): String {
        var results = "<h1>Grilling tips!</h1><ul>"

        for (tip in tips) {
            results += "<li>$tip</li>"
        }
        results += "</ul>"

        return results
    }

    @RequestMapping("/numOfTips")
    @ResponseBody
    fun numGrillingTips(): String {
        return "<h1>Grilling Tips</h1><p>There are ${tips.size} tips"
    }

    @RequestMapping("/{id}")
    @ResponseBody
    fun getGrillingTipById(@PathVariable id: Int): String {
        //double check that I have a good index
        if (id >= 0 && id < tips.size) {
            return "<h1>Tip at index - $id</h1><p>${tips[id]}</p>"
        }
        return "<h1>Index $id is not valid!</h1>"
    }
}