package com.chrisworks.practicecoderewrite.v1_0.services.impls;

import com.chrisworks.practicecoderewrite.v1_0.models.Author;
import com.chrisworks.practicecoderewrite.v1_0.services.AuthorService;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

  //Method one and three has a common xteristics, note that in the AppStoreAccessor, I have this already defined
  //We added it here again, so we see how the re-write too will work
  final Function<Predicate<Author>, List<Author>> filterAuthors =
      predicate -> getAll()
          .stream()
          .filter(predicate)
          .collect(Collectors.toList());

  @Override
  public List<Author> fetchAllAuthorOlderThan(int age) {
    return filterAuthors.apply(a -> a.authorAge() >= age);
  }

  @Override
  public List<Author> fetchAllAuthorThatHaveFeaturedAtLeastIn(int numberOfBooks) {
    return Collections.emptyList();
  }

  @Override
  public List<Author> fetchAllAuthorThatAreStillAlive() {
    return filteringFunction().apply(Author::stillAlive);
  }
}
