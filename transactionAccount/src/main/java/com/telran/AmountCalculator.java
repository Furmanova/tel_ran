package com.telran;
import java.util.List;

public class AmountCalculator {
    public static long cancelledTransactionsSum(List<Account> accounts){
       return accounts.stream().filter(account -> account.getBalance() > 0)
               .flatMap(account -> account.transactions.stream())
               .filter(transaction -> transaction.getState()==State.CANCELLED)
               .map(Transaction::getSum)
               .reduce(0L, Long::sum);
    }
}













