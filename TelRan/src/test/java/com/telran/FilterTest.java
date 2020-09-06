package com.telran;

import com.telran.predicates.ListPredicate;
import com.telran.predicates.NotBlockedPredicate;
import com.telran.predicates.PositiveBalancePredicate;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

public class FilterTest {
    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void testListPredicate() {
                List<Account> accountList = Arrays.asList(
                new Account("1", 100L, false),
                new Account("2", 1000L, true),
                new Account("3", 10000L, false),
                new Account("4", 200000L, false)
        );
        AccountFilter accountFilter = new AccountFilter();
        List<Predicate<Account>> predicates = Arrays.asList(
                new PositiveBalancePredicate());
               List<Account> result = accountFilter.filter(accountList,
                ListPredicate.complexPredicate(predicates)
        );
        List<Account> expectedList = Arrays.asList(
                new Account("4", 200000L, false));
       // Assert.assertEquals(result, expectedList);
        result.stream().forEach(System.out::println);


    }
        @Test
        public void testFilterAccount () {
            List<Account> accountList = Arrays.asList(
                    new Account("1", 100L, false),
                    new Account("2", 1000L, true),
                    new Account("3", 10000L, false),
                    new Account("4", 200000L, false));
            AccountFilter accountFilter = new AccountFilter();
            List<Account> result = accountFilter.filter(accountList, new NotBlockedPredicate());
            List<Account> expectedList = Arrays.asList(
                    new Account("4", 200000L, false));
            Assert.assertEquals(result, expectedList);
            result.stream().forEach(System.out::println);
        }
    }
