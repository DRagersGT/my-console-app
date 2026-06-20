package com.library.service;

import com.library.dao.BookDao;
import com.library.model.Book;
import java.util.List;

public class BookService {
    private BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void addBook(String title, int authorId, int year, String isbn) {
        Book book = new Book(bookDao.getNextId(), title, authorId, year, isbn);
        bookDao.add(book);
        System.out.println("Книга добавлена: " + title);
    }

    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    public Book findBookById(int id) {
        return bookDao.findById(id).orElse(null);
    }

    public List<Book> findBooksByAuthor(int authorId) {
        return bookDao.findByAuthorId(authorId);
    }

    public void markBookAsUnavailable(int bookId) {
        Book book = findBookById(bookId);
        if (book != null) {
            book.setAvailable(false);
            bookDao.update(book);
        }
    }

    public void markBookAsAvailable(int bookId) {
        Book book = findBookById(bookId);
        if (book != null) {
            book.setAvailable(true);
            bookDao.update(book);
        }
    }
}