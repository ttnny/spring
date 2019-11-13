package edu.greenriver.it.di.shelves

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
@Qualifier(value = "digital") //naming the type of bean
class DigitalBookShelf : IBookShelf {
    init {
        println("Digital book shelf created by Spring container")
    }

    override fun addBook(bookName: String) {
        println("Book added to digital shelf - $bookName")
    }
}