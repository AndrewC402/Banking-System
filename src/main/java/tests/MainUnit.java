package tests;

import com.qa.bankingcore.*;

public class MainUnit {
    public static void main(String[] args) {

            test_transaction();
            test_does_balance_match_opening_amount_on_account();
            test_does_balance_match_after_credit();
            test_does_balance_match_after_debit();
            test_does_balance_match_after_debit_and_credit();
            test_does_balance_match_after_debiting_more_than_balance_on_credit_account();
            test_does_balance_match_after_debit_on_credit_account();

    }

    static void test_transaction() {
        Transaction transaction = new Transaction(105.50);
        System.out.println("Transaction amount: " + transaction.getAmt());
        System.out.println("Transaction time stamp: " + transaction.getWhen());
    }

    static void test_does_balance_match_opening_amount_on_account(){
        //arrange & act
        double openingBalance = 156.98;
        Account acc = new DebitAccount(1,"Andrew",openingBalance, InterestRate.HOME_LOAN);

        //assert
        if (openingBalance == acc.availableBalance() && openingBalance == acc.currentBalance()) {
            System.out.println("test_does_balance_match_opening_amount_on_account:PASSED");
        } else {
            System.out.println("test_does_balance_match_opening_amount_on_account:FAILED");
        }
    }

    static void test_does_balance_match_after_credit(){
        //arrange
        double openingBalance = 156.98;
        double amountToDeposit = 88.30;
        Account acc = new Account(1,"Andrew",openingBalance);

        //Act
        acc.credit(amountToDeposit);

        //assert
        if (openingBalance + amountToDeposit == acc.availableBalance() && openingBalance + amountToDeposit == acc.currentBalance()) {
            System.out.println("test_does_balance_match_after_credit:PASSED");
        } else {
            System.out.println("test_does_balance_match_after_credit:FAILED");
        }
    }

    static void test_does_balance_match_after_debit(){
        //arrange
        double openingBalance = 156.98;
        double amountToDebit = 55.62;
        Account acc = new Account(1,"Andrew", openingBalance);

        //act
        acc.debit(amountToDebit);

        //assert
        if(openingBalance - amountToDebit == acc.availableBalance() && openingBalance - amountToDebit == acc.currentBalance()) {
            System.out.println("test_does_balance_match_after_debit:PASSED");
        } else {
            System.out.println("test_does_balance_match_after_debit:FAILED");
        }
    }

    static void test_does_balance_match_after_debit_and_credit(){
        //arrange
        double openingBalance = 156.96;
        double amountToCredit = 50.55;
        double amountToDebit = 24.79;
        Account acc = new Account(1,"Andrew",openingBalance);

        //act
        acc.credit(amountToCredit);
        acc.debit(amountToDebit);

        //assert
        if (openingBalance + amountToCredit - amountToDebit == acc.availableBalance() && openingBalance + amountToCredit - amountToDebit == acc.currentBalance()) {
            System.out.println("test_does_balance_match_after_debit_and_credit:PASSED");
        } else {
            System.out.println("test_does_balance_match_after_debit_and_credit:FAILED");
        }
    }

    static void test_does_balance_match_after_debiting_more_than_balance_on_credit_account() {
        //arrange
        double openingBalance = 156.96;
        double amountToDebit = 254.67;
        Account acc = new CreditAccount(1,"Andrew",openingBalance,InterestRate.HOME_LOAN);

        //Act
        acc.debit(amountToDebit);

        //Assert
        amountToDebit += amountToDebit * InterestRate.HOME_LOAN.getRate()/100;
        if ((openingBalance - amountToDebit) == acc.availableBalance() && (openingBalance -amountToDebit) == acc.currentBalance()) {
            System.out.println("test_does_balance_match_after_debiting_more_than_balance_on_credit_account:PASSED");
        } else {
            System.out.println("test_does_balance_match_after_debiting_more_than_balance_on_credit_account:FAILED");
        }
    }

    static void test_does_balance_match_after_debit_on_credit_account() {
        //arrange
        double openingBalance = 156.96;
        double amountToDebit = 54.67;
        Account acc = new CreditAccount(1,"Andrew",openingBalance,InterestRate.HOME_LOAN);

        //Act
        acc.debit(amountToDebit);

        //Assert
        if ((openingBalance - amountToDebit) == acc.availableBalance() && (openingBalance -amountToDebit) == acc.currentBalance()) {
            System.out.println("test_does_balance_match_after_debit_on_credit_account:PASSED");
        } else {
            System.out.println("test_does_balance_match_after_debit_on_credit_account:FAILED");
        }
    }
}
