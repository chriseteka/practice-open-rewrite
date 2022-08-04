package com.chrisworks.practicecoderewrite.v1_0.services;

import com.chrisworks.practicecoderewrite.v1_0.AppStore;
import com.chrisworks.practicecoderewrite.v1_0.models.Book;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface BookService extends AppStoreAccessor<Book> {

    @Override
    default Map<String, Book> store() {
        return AppStore.bookStore;
    }

    @Override
    default Book save(Book data) {
        final String id = UUID.randomUUID().toString();
        data.setIsbn(id);
        store().put(id, data);
        return data;
    }

    //Say we define some naive ops for the book object

    //1. Fetch all books with no co-authors (too simple)
    default List<Book> fetchAllBooksWithNoCoAuthors() {
        return fetchAllBooksWith(0);
    }

    //2. Fetch all books with n-number of co-authors
    List<Book> fetchAllBooksWith(int nCoAuthors);

    //3. Fetch all books whose authors are still alive
    List<Book> fetchAllBooksWithAuthorsAlive();
}
