package com.telran.predicates;
import java.util.List;
import java.util.function.Predicate;

public class ListPredicate {
        public static <T> Predicate<T> complexPredicate(List<Predicate<T>> predicates) {
            Predicate<T> result = (x)-> true;

            /*Predicate<T> result = new Predicate<T>() {
            @Override
            public boolean test(T o) {
                return true;
            }
        };*/

        for (Predicate predicate : predicates) {
            result.and(predicate);
        }
            return result;
    }
    }

