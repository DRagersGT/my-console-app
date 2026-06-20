package com.library.service;

import com.library.dao.AuthorDao;
import com.library.model.Author;
import java.util.List;

public class AuthorService {
    private AuthorDao authorDao;

    public AuthorService(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public void addAuthor(String name, String country) {
        Author author = new Author(authorDao.getNextId(), name, country);
        authorDao.add(author);
        System.out.println("Автор добавлен: " + name);
    }

    public List<Author> getAllAuthors() {
        return authorDao.findAll();
    }

    public Author findAuthorById(int id) {
        return authorDao.findById(id).orElse(null);
    }
}