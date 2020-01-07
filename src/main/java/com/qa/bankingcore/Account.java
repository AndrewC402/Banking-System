package com.qa.bankingcore;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private final int id;
    private final String name;
    private double balance;

    private final List<Transaction> transactionList = new ArrayList<>();

    public Account(int id, String name, double amount) {
        this.id = id;
        this.name = name;
        credit(amount);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double availableBalance() {
        return balance;
    }

    public double currentBalance() {
        double balance = 0;

        for (Transaction t: transactionList)
            balance += t.getAmt();

        return balance;
    }

    public void credit(double amt) {
        Transaction transaction = new Transaction(amt);
        transactionList.add(transaction);
        balance += amt;
    }

    public double debit(double amt) {
        Transaction transaction = new Transaction(amt/-1);
        transactionList.add(transaction);
        balance += (amt/-1);
        return availableBalance();
    }


    }


