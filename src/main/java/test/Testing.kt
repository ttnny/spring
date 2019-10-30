package test

import entities.Person
import repository.PersonCRUDRepository

fun main() {
    val repo = PersonCRUDRepository()

    // Enter a few test records
    repo.save(Person(
            id = 0,
            fName = "Chicken",
            lName = "Teriyaki",
            nickname = "FaveFood",
            age = 45
    ))

    val people = repo.findAll()

    for (person in people) {
        println(person)
    }
}