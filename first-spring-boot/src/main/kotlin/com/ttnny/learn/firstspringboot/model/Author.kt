package com.ttnny.learn.firstspringboot.model

import javax.persistence.*

@Entity
class Author(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private var id: Long,
        private var firstName: String,
        private var lastName: String,

        @ManyToMany(mappedBy = "authors")
        private var books: MutableSet<Book>
) {

}