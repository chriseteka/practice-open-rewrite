package com.chrisworks.practicecoderewrite.v1_0.controllers;

import com.chrisworks.practicecoderewrite.v1_0.models.Book;
import com.chrisworks.practicecoderewrite.v1_0.services.BookService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> allBooks() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Book> singleBook(@PathVariable String id) {
        return bookService.findOne(id);
    }

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public boolean removeBook(@PathVariable String id) {
        return bookService.remove(id);
    }

    @GetMapping("/with-authors-alive")
    public List<Book> booksWithAuthorsAlive() {
        return bookService.fetchAllBooksWithAuthorsAlive();
    }

    @GetMapping("/with-no-co-author")
    public List<Book> booksWithNoCoAuthors() {
        return bookService.fetchAllBooksWithNoCoAuthors();
    }

    @GetMapping("/featured-in/{noOfAuthors}")
    public List<Book> booksWithNoOfAuthors(@PathVariable Integer noOfAuthors) {
        return bookService.fetchAllBooksWith(noOfAuthors);
    }
}
