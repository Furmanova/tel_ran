package com.telran;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toSet;


public  class CountUniqueUsers implements Collector <LogEntry, Set<String>, Integer> {

    @Override
    public Supplier<Set<String>> supplier() {

        return  HashSet::new;
    }

    @Override
    public BiConsumer<Set<String>, LogEntry> accumulator() {
        return (set,logEntry)-> set.add(logEntry.url);
    }

    @Override
    public BinaryOperator<Set<String>> combiner() {
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };

    }
    @Override
    public Function<Set<String>, Integer> finisher() {
       return set-> set.stream()
               .collect(groupingBy(LogEntry::getUrl,
                       mapping(LogEntry::getUserName,
                               collectingAndThen(toSet(), Set::size)))
               );

            }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
