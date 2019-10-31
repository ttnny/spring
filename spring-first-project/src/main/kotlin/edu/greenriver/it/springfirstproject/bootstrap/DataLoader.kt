package edu.greenriver.it.springfirstproject.bootstrap

import edu.greenriver.it.springfirstproject.model.Message
import edu.greenriver.it.springfirstproject.repositories.IMessageRepository
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component
import java.time.LocalDate

// Create a class that responds to the Spring event - context refreshed
@Component
class DataLoader(val repo: IMessageRepository) : ApplicationListener<ContextRefreshedEvent> {
    override fun onApplicationEvent(p0: ContextRefreshedEvent) {
        repo.save(Message(
                id = 1,
                author = "Bilbo",
                body = "I like my ring",
                datePosted = LocalDate.now()
        ))

        repo.save(Message(
                id = 2,
                author = "Katniss",
                body = "Let me out of these darn games...",
                datePosted = LocalDate.now()
        ))
        repo.save(Message(
                id = 3,
                author = "Yoda",
                body = "Do or do not, there is no try",
                datePosted = LocalDate.now()
        ))

        println("Loaded bootstrap data...")
    }
}