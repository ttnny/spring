package edu.greenriver.it.mvcexample.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class CookingTipsController {
    private val tipsByType = mutableMapOf<String, List<String>>(
            "grilling" to listOf<String>(
                    "Preheat the Grill.",
                    "Keep it Clean.",
                    "Oil the Food, Not the Grate.",
                    "Keep the Lid Down.",
                    "Time and Temperature.",
                    "Know When to Be Direct, Know When to be Indirect.",
                    "Maintaining Temperatures.",
                    "Tame the Flame."
            ),
            "baking" to listOf(
                    "Always Have the Correct Butter Consistency.",
                    "Room Temperature is KEY.",
                    "Read the Recipe Before Beginning.",
                    "Always Have Ingredients Prepped.",
                    "Learn How to Measure.",
                    "Weigh Your Ingredients.",
                    "Get an Oven Thermometer.",
                    "Keep Your Oven Door Closed."
            ),
            "steaming" to listOf(
                    "Don’t Add Too Much Water.",
                    "Boil the Water First.",
                    "Don’t Steam For Too Long.",
                    "Enhance the Steam By Using Stock & Herbs.",
                    "Make Sure the Seal is Air-Tight.",
                    "Prepare the Food Before Steaming."
            )
    )

    @RequestMapping("/cooking/grilling/random")
    @ResponseBody
    fun randomGrillingTip(): String {
        val listOfTips = tipsByType.get("grilling")
        val tip = listOfTips?.random()
        return "<h1>A random tip</h1><p>$tip</p>"
    }

    @RequestMapping(path = ["/cooking/grilling", "/cooking/grilling/all"])
    @ResponseBody
    fun grillTips(): String {
        val listOfTips = tipsByType.get("grilling")
        var results = "<h1>Grilling tips!</h1><ul>"

        if (listOfTips != null) {
            for (tip in listOfTips) {
                results += "<li>$tip</li>"
            }
        }

        results += "</ul"

        return results
    }
}