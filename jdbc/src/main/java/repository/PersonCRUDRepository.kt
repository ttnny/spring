package repository

import com.mysql.cj.x.protobuf.MysqlxPrepare
import entities.Person
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement

class PersonCRUDRepository : DBConnection() {
    fun findAll(): List<Person> {
        val listResults = mutableListOf<Person>()
        val stmt = connection.createStatement()
        val results = stmt.executeQuery("SELECT id, fName, lName, nickname, age FROM people")

        while (results.next()) { // return TRUE if found AND ALSO move to the next one
            listResults.add(Person(
                    id = results.getInt("id"),
                    fName = results.getString("fName"),
                    lName = results.getString("lName"),
                    nickname = results.getString("nickname"),
                    age = results.getInt("age")
            ))
        }

        return listResults
    }

    fun findById(id: Int): Person? {
        // Create a prepared statement
        val pStmt: PreparedStatement = connection.prepareStatement(
                "SELECT id, fName, lName, nickname, age FROM people WHERE id=?"
        )

        // Bind the parameters to the query
        pStmt.setInt(1, id)
        val results: ResultSet = pStmt.executeQuery()

        if (results.next()) {
            return Person(
                    id = results.getInt("id"),
                    fName = results.getString("fName"),
                    lName = results.getString("lName"),
                    nickname = results.getString("nickname"),
                    age = results.getInt("age")
            )
        }

        return null
    }

    fun save(person: Person) {
        // Create a prepared statement
        val pStmt: PreparedStatement = connection.prepareStatement(
                "INSERT INTO people (fName, lName, nickname, age)" +
                        "VALUES (?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
        )

        // Bind my parameters to the query (prevent SQL injection)
        pStmt.setString(1, person.fName)
        pStmt.setString(2, person.lName)
        pStmt.setString(3, person.nickname)
        pStmt.setInt(4, person.age)

        person.id = pStmt.executeUpdate()
    }

    fun update(person: Person) {
        // Create a prepared statement
        val pStmt: PreparedStatement = connection.prepareStatement(
                "UPDATE people SET fName = ?, lName = ?, nickname =?, age = ?" +
                        "WHERE id = ?"
        )

        // Bind my parameters to the query (prevent SQL injection)
        pStmt.setString(1, person.fName)
        pStmt.setString(2, person.lName)
        pStmt.setString(3, person.nickname)
        pStmt.setInt(4, person.age)
        pStmt.setInt(5, person.id)

        pStmt.execute()
    }

    fun delete(id: Int) {

    }
}