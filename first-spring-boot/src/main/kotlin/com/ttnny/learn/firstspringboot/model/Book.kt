package com.ttnny.learn.firstspringboot.model

import javax.persistence.*

@Entity
class Book(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private var title: String,
        private var isbn: String,
        private var publisher: String,

        @ManyToMany
        @JoinTable(name = "author_book", joinColumns = [JoinColumn(name = "book_id")], inverseJoinColumns = [JoinColumn(name = "author_id")])
        private var author: Set<Author>
) {

}