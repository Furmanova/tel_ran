package com.telran.predicates;

import com.telran.Account;

import java.util.function.Predicate;

public class NotBlockedPredicate implements Predicate <Account> {

    @Override
    public boolean test(Account account) {
        return !account.isLocked() && account.getBalance() > 100000;
    }
}
