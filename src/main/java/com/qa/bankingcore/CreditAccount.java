package com.qa.bankingcore;

public class CreditAccount extends Account {

    InterestRate rate;

    public CreditAccount(int id, String name, double amount, InterestRate rate) {
        super(id, name, amount);
        this.rate = rate;
    }
}
