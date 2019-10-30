package repository

import java.lang.RuntimeException
import java.sql.Connection
import java.sql.DriverManager
import java.util.*

open class DBConnection {
    var connection: Connection

    init {
        val properties = Properties()

        properties.put("user", "dev")
        properties.put("password", "dev")

        val connString = "jdbc:mysql://localhost:3306/test_db"

        try {
            // tentatively load the mysql driver
            // Class.forName("com.mysql.jdbc.Driver")

            connection = DriverManager.getConnection(connString, properties)

            println("Connected to DB!")
        } catch (ex: Exception) {
            println("Error: ${ex.message}")
            throw RuntimeException("Cannot connect to DB")
        }
    }
}