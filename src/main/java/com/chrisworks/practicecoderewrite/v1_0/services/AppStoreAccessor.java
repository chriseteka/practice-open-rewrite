package com.chrisworks.practicecoderewrite.v1_0.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//We assume this to be an interface accesses our store, but requires that it's implementor provides the reference to the store
//Here the generic type M is tells which model will be accessed as every method within this interface will be typed against it
public interface AppStoreAccessor<M> {

  Map<String, M> store();

  //Simple CRUD ops
  default List<M> getAll() {
    return new ArrayList<>(store().values());
  }

  default Optional<M> findOne(String id) {
    return Optional.ofNullable(store().get(id));
  }

  M save(M data);

  default boolean remove(String id) {
    return Optional.ofNullable(store().remove(id)).isPresent();
  }

  //Since both service implementations have similar kind of filter functions, we can provide it here
  default Function<Predicate<M>, List<M>> filteringFunction() {
    return predicate -> getAll()
        .stream()
        .filter(predicate)
        .collect(Collectors.toList());
  }
}
