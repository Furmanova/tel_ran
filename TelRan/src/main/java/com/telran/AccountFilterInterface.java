package com.telran;

import java.util.List;
import java.util.function.Predicate;

public interface AccountFilterInterface {
    List<Account> filter(List<Account> accounts, Predicate<Account> predicate);
}



