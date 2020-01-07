package com.qa.bankingcore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditAccountTest {

    @Test
    public void does_balance_match_after_debiting_more_than_balance_on_credit_account() {
        //arrange
        double openingBalance = 156.96;
        double amountToDebit = 254.67;
        double expectedResult = openingBalance - (amountToDebit + (amountToDebit * InterestRate.HOME_LOAN.getRate()/100));

        //act
        Account acc = new CreditAccount(1,"Andrew",openingBalance,InterestRate.HOME_LOAN);
        acc.debit(amountToDebit);
        double actualResult = acc.currentBalance();

        //assert
        assertEquals(expectedResult,actualResult);
    }

}