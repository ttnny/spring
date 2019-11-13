package edu.greenriver.it.di

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DependencyInjectionApplication

fun main(args: Array<String>) {
    runApplication<DependencyInjectionApplication>(*args)
}
