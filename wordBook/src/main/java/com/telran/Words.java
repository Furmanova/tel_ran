package com.telran;

import java.util.*;
import java.util.stream.Collectors;

public class Words {
    public static void main(String[] args) {


        String words = "acb a cab abc bac baa";

        Map<Character, List<String>> items = new HashMap<>();
        for (String word : words.split(" ")) {
            Character key = word.charAt(0);
            List<String> list = items.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(word);
        }

        items.entrySet().stream()
                .map(Map.Entry::getValue)
                .forEach(list -> list.sort(Comparator.comparing((String x) -> x)));
        System.out.println(items);
        // {a=[a, abc, acb], b=[baa, bac], c=[cab]}
    }

}







