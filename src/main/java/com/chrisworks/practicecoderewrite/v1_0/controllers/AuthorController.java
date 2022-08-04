package com.chrisworks.practicecoderewrite.v1_0.controllers;

import com.chrisworks.practicecoderewrite.v1_0.models.Author;
import com.chrisworks.practicecoderewrite.v1_0.services.AuthorService;
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
@RequestMapping("/author")
public class AuthorController {

  private final AuthorService authorService;

  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @GetMapping
  public List<Author> allAuthors() {
    return authorService.getAll();
  }

  @GetMapping("/{id}")
  public Optional<Author> singleAuthor(@PathVariable String id) {
    return authorService.findOne(id);
  }

  @PostMapping
  public Author saveAuthor(@RequestBody Author author) {
    return authorService.save(author);
  }

  @DeleteMapping("/{id}")
  public boolean removeAuthor(@PathVariable String id) {
    return authorService.remove(id);
  }

  @GetMapping("/alive")
  public List<Author> livingAuthors() {
    return authorService.fetchAllAuthorThatAreStillAlive();
  }

  @GetMapping("/older/{age}")
  public List<Author> authorsOlderThan(@PathVariable Integer age) {
    return authorService.fetchAllAuthorOlderThan(age);
  }

  @GetMapping("/featured-in/{noOfBooks}")
  public List<Author> authorsFeaturedAtLeastIn(@PathVariable Integer noOfBooks) {
    return authorService.fetchAllAuthorThatHaveFeaturedAtLeastIn(noOfBooks);
  }
}
