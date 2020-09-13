package com.telran;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        IntStream stream1 = revRange(1,10);
        IntStream stream2 = revRange(1,10);
        IntStream stream = IntStream.concat(stream1,stream2)
                .filter(i->i%3==0||i%5==0)
                .sorted()
                .skip(2);
        stream.forEach(System.out::println);
    }
    static IntStream revRange(int from, int to) {
        return IntStream.range(from, to)
                .map(i -> to - i + from - 1);
    }
}
