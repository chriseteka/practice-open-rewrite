package com.chrisworks.practicecoderewrite.v1_0.models;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//This is a naive definition of an author class, POJO style
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

  private String id;
  private String name;
  private String email;
  private LocalDate dateOfBirth;
  private Set<Book> books = new HashSet<>();

  public int authorAge() {
    //Assume zero, if an age isn't provided
    return Optional.ofNullable(dateOfBirth)
        .map(dob -> Period.between(LocalDate.now(), dob).getYears())
        .orElse(0);
  }

  //Naive impl, you are considered to be still alive if you are below 150
  public boolean stillAlive() {
    return authorAge() < 150;
  }
}
