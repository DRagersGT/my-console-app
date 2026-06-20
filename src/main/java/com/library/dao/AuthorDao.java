package com.library.dao;

import com.library.model.Author;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorDao {
    private List<Author> authors = new ArrayList<>();
    private int nextId = 1;

    public void add(Author author) {
        authors.add(author);
    }

    public Optional<Author> findById(int id) {
        return authors.stream().filter(a -> a.getId() == id).findFirst();
    }

    public List<Author> findAll() {
        return new ArrayList<>(authors);
    }

    public int getNextId() {
        return nextId++;
    }
}