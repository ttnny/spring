package edu.greenriver.it.di.shelves

import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

@Component
@Primary //use as the primary bean of this type
class WoodenBookShelf : IBookShelf {
    init {
        println("Wooden book shelf created by Spring container")
    }

    override fun addBook(bookName: String) {
        println("Book added to wooden shelf - $bookName")
    }
}