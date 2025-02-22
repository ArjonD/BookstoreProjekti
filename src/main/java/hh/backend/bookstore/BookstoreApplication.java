package hh.backend.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;
import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			categoryRepository.save(new Category("Scifi"));
			categoryRepository.save(new Category("Comic"));
			categoryRepository.save(new Category("Fiction"));

			bookRepository.save(new Book("Moby-Dick", "Herman Melville", 1851, "9781503280786", 14.50));
			bookRepository.save(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "9780061120084", 11.99));
		
			System.out.println("Fetch all categories");
			categoryRepository.findAll().forEach(category -> System.out.println(category));
			System.out.println("Fetch all books");
			bookRepository.findAll().forEach(book -> System.out.println(book));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
}
