package edu.greenriver.it.mvcexample.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/cooking/baking")
class BakingController {
    val tips = listOf(
            "Always Have the Correct Butter Consistency.",
            "Room Temperature is KEY.",
            "Read the Recipe Before Beginning.",
            "Always Have Ingredients Prepped.",
            "Learn How to Measure.",
            "Weigh Your Ingredients.",
            "Get an Oven Thermometer.",
            "Keep Your Oven Door Closed."
    )

    @RequestMapping("/numOfTips")
    @ResponseBody
    fun numBakingTips(): String {
        return "<h1>Baking Tips</h1><p>There are ${tips.size} tips"
    }
}