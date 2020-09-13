package com.telran;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AmountCalculatorTest {
    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void testAmountCalculatorTransaction() {
        List<Transaction> transactionList = Arrays.asList(
                new Transaction("Peter", State.CANCELLED, 120, 2000),
                new Transaction("Ivan", State.FINISHED, 120, 2000),
                new Transaction("Alx", State.PROCESSING, 120, 2000),
                new Transaction("Mark", State.CANCELLED, 20, 2000));
        List<Account> accountList = Arrays.asList(
                new Account("Peter", 100L, transactionList),
                new Account("Ivan", 1000L, transactionList),
                new Account("Alx", 10000L, transactionList),
                new Account("Mark", 200000L, transactionList));
        Long res = AmountCalculator.cancelledTransactionsSum(accountList);
        System.out.println(res);
        Assert.assertEquals(Long.valueOf(560), res);

    }

}

