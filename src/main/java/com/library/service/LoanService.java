package com.library.service;

import com.library.dao.LoanDao;
import com.library.model.Loan;
import com.library.model.Book;
import java.time.LocalDate;
import java.util.List;

public class LoanService {
    private LoanDao loanDao;
    private BookService bookService;

    public LoanService(LoanDao loanDao, BookService bookService) {
        this.loanDao = loanDao;
        this.bookService = bookService;
    }

    // Выдача книги
    public void borrowBook(int bookId, String readerName) {
        Book book = bookService.findBookById(bookId);
        if (book == null) {
            System.out.println("Книга с ID " + bookId + " не найдена!");
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("Книга \"" + book.getTitle() + "\" уже выдана!");
            return;
        }

        Loan loan = new Loan(loanDao.getNextId(), bookId, readerName, LocalDate.now());
        loanDao.add(loan);
        bookService.markBookAsUnavailable(bookId);
        System.out.println("Книга \"" + book.getTitle() + "\" выдана читателю " + readerName);
    }

    // Возврат книги
    public void returnBook(int bookId) {
        Book book = bookService.findBookById(bookId);
        if (book == null) {
            System.out.println("Книга с ID " + bookId + " не найдена!");
            return;
        }
        if (book.isAvailable()) {
            System.out.println("Книга \"" + book.getTitle() + "\" уже доступна!");
            return;
        }

        // Ищем активную выдачу
        List<Loan> loans = loanDao.findByBookId(bookId);
        Loan activeLoan = loans.stream().filter(l -> !l.isReturned()).findFirst().orElse(null);

        if (activeLoan == null) {
            System.out.println("Не найдена активная выдача для книги \"" + book.getTitle() + "\"");
            return;
        }

        activeLoan.setReturned(true);
        activeLoan.setReturnDate(LocalDate.now());
        bookService.markBookAsAvailable(bookId);
        System.out.println("Книга \"" + book.getTitle() + "\" возвращена читателем " + activeLoan.getReaderName());
    }

    // Получить все выдачи
    public List<Loan> getAllLoans() {
        return loanDao.findAll();
    }

    // Получить активные выдачи
    public List<Loan> getActiveLoans() {
        return loanDao.findAll().stream().filter(l -> !l.isReturned()).toList();
    }

    // Получить выдачи по книге
    public List<Loan> getLoansByBook(int bookId) {
        return loanDao.findByBookId(bookId);
    }
}