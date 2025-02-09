package hh.backend.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			repository.save(new Book("Moby-Dick", "Herman Melville", 1851, "9781503280786", 14.50));
			repository.save(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "9780061120084", 11.99));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
