package com.qa.bankingcore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    public void does_balance_match_opening_amount_on_account() {
        //arrange
        double openingBalance = 156.98;
        double expectedResult = 156.98;

        //act
        Account acc = new Account(1,"Andrew",openingBalance);
        double actualResult = acc.currentBalance();

        //assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void does_balance_match_after_credit() {
        //arrange
        double openingBalance = 156.98;
        double creditToAdd = 50.00;
        double expectedResult = 206.98;

        //act
        Account acc = new Account(1,"Andrew",openingBalance);
        acc.credit(creditToAdd);
        double actualResult = acc.currentBalance();

        //assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void does_balance_match_after_debit() {
        //arrange
        double openingBalance = 156.98;
        double amountToDebit = 55.62;
        double expectedResult = openingBalance - amountToDebit;

        //act
        Account acc = new Account(1,"Andrew", openingBalance);
        acc.debit(amountToDebit);
        double actualResult = acc.currentBalance();

        //arrange
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void does_balance_match_after_debit_and_credit() {
        //arrange
        double openingBalance = 156.96;
        double amountToCredit = 50.55;
        double amountToDebit = 24.79;
        double expectedResult = openingBalance + amountToCredit - amountToDebit;

        //act
        Account acc = new Account(1,"Andrew",openingBalance);
        acc.credit(amountToCredit);
        acc.debit(amountToDebit);
        double actualResult = acc.currentBalance();

        //assert
        assertEquals(expectedResult,actualResult);
    }

}