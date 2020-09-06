package com.telran;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class TestSimpleNumber {
    private static final List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19);
    @Test
    public void testNumberIsPrime() {
       primes.stream().forEach(integer -> assertTrue(SimpleNumber.isPrime(integer)));
    }
    @Test
    public void testNumberIsNotPrime() {
        List<Integer> nonPrime = new ArrayList<>();
        for (int i = 2; i < 20; i++) {
            if (!primes.contains(i)) {
                nonPrime.add(i);
            }
        }
        nonPrime.stream().forEach(integer -> assertFalse(SimpleNumber.isPrime(integer)));

        primes.stream().forEach(System.out::println);
    }
    @Test
    public void test9() {
        SimpleNumber.test("Hello world", s->s.length()>10);
    }
}