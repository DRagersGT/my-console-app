package com.library.model;

import java.time.LocalDate;

public class Loan {
    private int id;
    private int bookId;
    private String readerName;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private boolean returned;

    public Loan(int id, int bookId, String readerName, LocalDate loanDate) {
        this.id = id;
        this.bookId = bookId;
        this.readerName = readerName;
        this.loanDate = loanDate;
        this.returned = false;
    }

    public int getId() { return id; }
    public int getBookId() { return bookId; }
    public String getReaderName() { return readerName; }
    public LocalDate getLoanDate() { return loanDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public boolean isReturned() { return returned; }

    public void setReturned(boolean returned) { this.returned = returned; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }

    @Override
    public String toString() {
        return String.format("Читатель: %s | Дата выдачи: %s | %s",
                readerName, loanDate, returned ? "Возвращена" : "Активна");
    }
}