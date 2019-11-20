package edu.greenriver.it.viewtemplatesexample.model

class Product(
        var name: String,
        var price: Double,
        var description: String,
        var onSale: SaleType
)

enum class SaleType {
    NO_SALE,
    ON_SALE,
    PREMIER_ITEM,
    LIMITED_ITEM
}