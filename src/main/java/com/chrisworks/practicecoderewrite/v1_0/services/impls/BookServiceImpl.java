package com.chrisworks.practicecoderewrite.v1_0.services.impls;

import com.chrisworks.practicecoderewrite.v1_0.models.Book;
import com.chrisworks.practicecoderewrite.v1_0.services.BookService;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

  //Method one and two has a common xteristics, note that in the AppStoreAccessor, I have this already defined
  //We added it here again, so we see how the re-write too will work
//  final Function<Predicate<Book>, List<Book>> filterBooks = filteringFunction(); //This is allowed
  final Function<Predicate<Book>, List<Book>> filterBooks =
      predicate -> getAll()
          .stream()
          .filter(predicate)
          .collect(Collectors.toList());

  @Override
  public List<Book> fetchAllBooksWith(int nCoAuthors) {
    return filterBooks.apply(b -> b.getCoAuthors().size() >= nCoAuthors);
  }

  @Override
  public List<Book> fetchAllBooksWithAuthorsAlive() {
    return filteringFunction().apply(b -> b.getMainAuthor().stillAlive());
  }
}
