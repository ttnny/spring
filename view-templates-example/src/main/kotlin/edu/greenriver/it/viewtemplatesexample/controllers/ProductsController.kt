package edu.greenriver.it.viewtemplatesexample.controllers

import edu.greenriver.it.viewtemplatesexample.model.Product
import edu.greenriver.it.viewtemplatesexample.model.SaleType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class ProductsController {
    val fakeProducts = listOf(
            Product("Surfboard", 99.99, "A board to surf upon", SaleType.NO_SALE),
            Product("Bowling Ball", 19.99, "A ball to bowl with", SaleType.ON_SALE),
            Product("Bicycle", 199.99, "A bike", SaleType.PREMIER_ITEM),
            Product("Rocketship", 7.99, "A kid's rocket", SaleType.LIMITED_ITEM)
    )

    @RequestMapping("/products/afew")
    fun aFewProducts(model: Model): String {
        model.addAttribute("product1", fakeProducts[0])
        model.addAttribute("product2", fakeProducts[1])

        return "products/a_few_products"
    }

    @RequestMapping("/products/all")
    fun allProducts(model: Model): String {
        model.addAttribute("products", fakeProducts)

        return "products/all_products"
    }
}