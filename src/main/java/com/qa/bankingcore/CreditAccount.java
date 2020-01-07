package com.qa.bankingcore;

public class CreditAccount extends Account {

    InterestRate rate;

    public CreditAccount(int id, String name, double amount, InterestRate rate) {
        super(id, name, amount);
        this.rate = rate;
    }

    //does amount drop balance below zero
    //calculate interest rate on overdrawn amount
    //call super.debit() so calculate the amount owed

    public double debit(double amt) {
        if (super.availableBalance() - amt < 0) {
           double amountToDebit = amt + (rate.getRate()/100)*amt;
           super.debit(amountToDebit);
        } else {
            super.debit(amt);
        }
        return super.availableBalance();
    }


}
