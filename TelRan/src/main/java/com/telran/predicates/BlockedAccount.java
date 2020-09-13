package com.telran.predicates;

import com.telran.Account;
import com.telran.AccountFilter;
import com.telran.AccountFilterInterface;

import java.util.List;
import java.util.function.Predicate;


public class BlockedAccount  {

        public boolean test(Account account) {

            return account.isLocked() && account.getBalance() > 100000;
        }
}
