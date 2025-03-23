package hh.backend.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.boot.CommandLineRunner;
import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;
import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;
import hh.backend.bookstore.domain.User;
import hh.backend.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository,
			UserRepository userRepository) {
		return (args) -> {
			Category scifi = new Category("Scifi");
			Category comic = new Category("Comic");
			Category fiction = new Category("Fiction");

			categoryRepository.save(scifi);
			categoryRepository.save(comic);
			categoryRepository.save(fiction);

			bookRepository.save(new Book("Moby-Dick", "Herman Melville", 1851, "9781503280786", 14.50, scifi));
			bookRepository.save(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "9780061120084", 11.99, fiction));

			System.out.println("Fetch all categories");
			categoryRepository.findAll().forEach(category -> System.out.println(category));
			System.out.println("Fetch all books");
			bookRepository.findAll().forEach(book -> System.out.println(book));

			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			userRepository.save(new User("user", encoder.encode("user"), "user@example.com", "USER"));
			userRepository.save(new User("admin", encoder.encode("admin"), "admin@example.com", "ADMIN"));
		};
	}
}