package hh.backend.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;

@CrossOrigin
@RestController
public class BookRestController {

    @Autowired
    private BookRepository repository;

    @GetMapping("/books")
    public List<Book> bookListRest() {
        return (List<Book>) repository.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> findBookRest(@PathVariable("id") Long id) {
        return repository.findById(id);
    }

    @PostMapping("/books")
    public Book saveBookRest(@RequestBody Book book) {
        return repository.save(book);
    }
}
