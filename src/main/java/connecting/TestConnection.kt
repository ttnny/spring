package connecting

import java.sql.DriverManager
import java.util.*

fun main() {
    val properties = Properties()

    properties.put("user", "dev")
    properties.put("password", "dev")

    val connString = "jdbc:mysql://localhost:3306/test_db"

    try {
        // tentatively load the mysql driver
        // Class.forName("com.mysql.jdbc.Driver")

        val connection = DriverManager.getConnection(connString, properties)

        println("Connected to DB")
    } catch (ex: Exception) {
        println("Error: ${ex.message}")
    }
}