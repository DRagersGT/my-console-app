package com.library.dao;

import com.library.model.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDao {
    private List<Book> books = new ArrayList<>();
    private int nextId = 1;

    public void add(Book book) {
        books.add(book);
    }

    public Optional<Book> findById(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst();
    }

    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    public List<Book> findByAuthorId(int authorId) {
        return books.stream().filter(b -> b.getAuthorId() == authorId).toList();
    }

    public void update(Book book) {
        findById(book.getId()).ifPresent(b -> {
            b.setAvailable(book.isAvailable());
        });
    }

    public int getNextId() {
        return nextId++;
    }
}