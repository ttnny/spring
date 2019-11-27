package edu.greenriver.it.viewtemplatesexample.model

@Entity
class Product(
        var name: String,
        var price: Double,
        var description: String,
        var onSale: Boolean
) {
    constructor(): this("", 0.0, "", false)
}