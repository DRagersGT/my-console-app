package com.library.dao;

import com.library.model.Loan;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LoanDao {
    private List<Loan> loans = new ArrayList<>();
    private int nextId = 1;

    public void add(Loan loan) {
        loans.add(loan);
    }

    public Optional<Loan> findById(int id) {
        return loans.stream().filter(l -> l.getId() == id).findFirst();
    }

    public List<Loan> findAll() {
        return new ArrayList<>(loans);
    }

    public List<Loan> findByBookId(int bookId) {
        return loans.stream().filter(l -> l.getBookId() == bookId).toList();
    }

    public int getNextId() {
        return nextId++;
    }
}