package com.telran;

import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) {
        System.out.println(sumOfOddNumbersInRange(1, 99));
    }
    public static long sumOfOddNumbersInRange(long start, long end) {
        return LongStream.range(start, end + 1).filter(item -> item % 2 != 0).sum();
          }


}