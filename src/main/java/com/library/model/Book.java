package com.library.model;

public class Book {
    private int id;
    private String title;
    private int authorId;
    private int year;
    private String isbn;
    private boolean available;

    public Book(int id, String title, int authorId, int year, String isbn) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.year = year;
        this.isbn = isbn;
        this.available = true;
    }

    // Геттеры и сеттеры
    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getAuthorId() { return authorId; }
    public int getYear() { return year; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return String.format("ID: %d | %s (%d) | ISBN: %s | %s",
                id, title, year, isbn, available ? "Доступна" : "Выдана");
    }
}