package com.telran;

import java.util.*;

public class Words {
    public static void main(String[] args) {

        String words = "acb a cab abc bac baa";

        Map<Character, List<String>> items = new HashMap<>();
        for (String word : words.split(" ")) {
            Character key = word.charAt(0);
            List<String> list = items.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(word);
        }
        System.out.println(items);
// {a=[acb, a, abc], b=[bac, baa], c=[cab]}

    }
}





