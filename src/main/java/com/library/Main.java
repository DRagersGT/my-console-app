package com.library;

import com.library.dao.*;
import com.library.service.*;
import com.library.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        BookDao bookDao = new BookDao();
        AuthorDao authorDao = new AuthorDao();
        LoanDao loanDao = new LoanDao();

        BookService bookService = new BookService(bookDao);
        AuthorService authorService = new AuthorService(authorDao);
        LoanService loanService = new LoanService(loanDao, bookService);

        ConsoleUI ui = new ConsoleUI(bookService, authorService, loanService);
        ui.start();
    }
}