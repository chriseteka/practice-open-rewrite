package com.chrisworks.practicecoderewrite.v1_0.services;

import com.chrisworks.practicecoderewrite.v1_0.AppStore;
import com.chrisworks.practicecoderewrite.v1_0.models.Author;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface AuthorService extends AppStoreAccessor<Author> {

  @Override
  default Map<String, Author> store() {
    return AppStore.authorStore;
  }

  @Override
  default Author save(Author data) {
    final String id = UUID.randomUUID().toString();
    data.setId(id);
    store().put(id, data);
    return data;
  }

  //We define some naive contracts for the author service

  //1. Fetch all author older than a given age
  List<Author> fetchAllAuthorOlderThan(int age);

  //2. Fetch all authors that have featured in at least n-books
  List<Author> fetchAllAuthorThatHaveFeaturedAtLeastIn(int numberOfBooks);

  //3. Fetch all authors that are still alive
  List<Author> fetchAllAuthorThatAreStillAlive();

}
