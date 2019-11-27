package edu.greenriver.it.viewtemplatesexample.controllers

import edu.greenriver.it.viewtemplatesexample.model.Product
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class ProductsController {
    val fakeProducts = listOf(
            Product("Surfboard", 99.99, "A board to surf upon", false),
            Product("Bowling Ball", 19.99, "A ball to bowl with", true),
            Product("Bicycle", 199.99, "A bike", true),
            Product("Rocketship", 7.99, "A kid's rocket", false)
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

    @RequestMapping("/products/{name}")
    fun product(@PathVariable name: String, model: Model): String {
        // find the product
        for (product in fakeProducts) {
            if (product.name == name) {
                model.addAttribute("product", product)
            }
        }

        // assume we found it

        // load the view
        return "products/product"
    }

    @GetMapping("/products/add")
    fun showAddForm(model: Model): String {
        model.addAttribute("product", Product())
        return "products/add_product_form"
    }

    @GetMapping("/products/add")
    fun handleAddForm(@ModelAttribute product: Product, model: Model): String {
        // save the data

        // test to make sure we got it
        println(product)

        model.addAttribute("product", product)

        return "products/product"
    }

    @GetMapping("/products/edit/{id}")
    fun showEditForm(@PathVariable id: Int, model: Model): String {
        return ""
    }
}