package com.telran;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AccountFilter implements AccountFilterInterface {
    @Override
    public List<Account> filter(List<Account> accounts, Predicate<Account> predicate) {
        List<Account> result = new ArrayList<>();
        for (Account account : accounts) {
            if (predicate.test(account))
                result.add(account);
            }
        return result;
        }
    }
