package edu.greenriver.it.springfirstproject.model

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Message(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,
        var author: String = "",
        var body: String = "",
        var datePosted: LocalDate = LocalDate.now()
) {
    // No class contents for now...
}
