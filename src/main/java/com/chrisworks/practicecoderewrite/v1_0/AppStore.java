package com.chrisworks.practicecoderewrite.v1_0;

import com.chrisworks.practicecoderewrite.v1_0.models.Author;
import com.chrisworks.practicecoderewrite.v1_0.models.Book;
import java.util.HashMap;
import java.util.Map;

//Say we define a simple class to mimic a DB
public class AppStore {

    public static final Map<String, Book> bookStore = new HashMap<>();
    public static final Map<String, Author> authorStore = new HashMap<>();

    //NB We may have chosen to use inheritance and ensure we have one Map as a Storage for both book and author
    //In fact this is the next goal, we need to see how the re-write tool deals with inheritance.

}
