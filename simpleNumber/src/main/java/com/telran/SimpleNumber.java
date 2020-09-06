package com.telran;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class SimpleNumber {
        public static boolean isPrime(Integer num) {
            return num > 1 && IntStream.rangeClosed(2, (int)Math.sqrt(num)).noneMatch(div-> num % div== 0);
        }
        public static boolean test(String str, Predicate<String> predicate){
            return predicate.test(str);
        }
}
