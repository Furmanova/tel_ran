package com.telran.predicates;

import com.telran.Account;

import java.util.function.Predicate;

public class PositiveBalancePredicate implements Predicate<Account> {
    @Override
    public boolean test(Account account) {
        return account.getBalance() > 0;
    }
}
