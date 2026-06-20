package com.library.ui;

import com.library.model.*;
import com.library.service.*;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI {
    private BookService bookService;
    private AuthorService authorService;
    private LoanService loanService;
    private Scanner scanner;

    public ConsoleUI(BookService bookService, AuthorService authorService, LoanService loanService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.loanService = loanService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== БИБЛИОТЕКА ===");
        boolean running = true;

        while (running) {
            System.out.println("\n1. Добавить автора");
            System.out.println("2. Добавить книгу");
            System.out.println("3. Показать все книги");
            System.out.println("4. Выдать книгу");
            System.out.println("5. Вернуть книгу");
            System.out.println("6. Показать все выдачи");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addAuthor();
                case 2 -> addBook();
                case 3 -> showBooks();
                case 4 -> borrowBook();
                case 5 -> returnBook();
                case 6 -> showLoans();
                case 0 -> running = false;
                default -> System.out.println("Неверный выбор!");
            }
        }
    }

    private void addAuthor() {
        System.out.print("Имя автора: ");
        String name = scanner.nextLine();
        System.out.print("Страна: ");
        String country = scanner.nextLine();
        authorService.addAuthor(name, country);
    }

    private void addBook() {
        System.out.print("Название книги: ");
        String title = scanner.nextLine();
        System.out.print("ID автора: ");
        int authorId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Год издания: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        bookService.addBook(title, authorId, year, isbn);
    }

    private void showBooks() {
        System.out.println("\n=== СПИСОК КНИГ ===");
        for (Book b : bookService.getAllBooks()) {
            System.out.println(b);
        }
    }

    private void borrowBook() {
        System.out.print("ID книги: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Имя читателя: ");
        String reader = scanner.nextLine();
        loanService.borrowBook(bookId, reader);
    }

    private void returnBook() {
        System.out.print("ID книги: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        loanService.returnBook(bookId);
    }

    private void showLoans() {
        System.out.println("\n=== ВСЕ ВЫДАЧИ ===");
        for (Loan l : loanService.getAllLoans()) {
            System.out.println(l);
        }
    }
}