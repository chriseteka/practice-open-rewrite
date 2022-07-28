package com.chrisworks.practicecoderewrite.v1_0.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//This is a naive definition of a book class, POJO style
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

  private String isbn;
  private String title;
  private Author mainAuthor;
  private LocalDate publishYear;
  private Set<Author> coAuthors = new HashSet<>();
}
