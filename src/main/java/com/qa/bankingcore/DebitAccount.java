package com.qa.bankingcore;

public class DebitAccount extends Account {

    InterestRate rate;

    public DebitAccount(int id, String name, double amount, InterestRate rate) {
        super(id, name, amount);
        this.rate = rate;
    }
}
