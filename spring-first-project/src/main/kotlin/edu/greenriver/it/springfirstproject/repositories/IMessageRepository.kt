package edu.greenriver.it.springfirstproject.repositories

import edu.greenriver.it.springfirstproject.model.Message
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IMessageRepository : CrudRepository<Message, Long> {

}