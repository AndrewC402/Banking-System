package com.qa.bankingcore;

public enum InterestRate {
    HOME_LOAN (5.67),
    BUSINESS_LOAN (2.34);

    private double rate;

    InterestRate(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
