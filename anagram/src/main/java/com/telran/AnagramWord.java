package com.telran;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramWord {

    private final String cannibalisedWord;
    private static Pattern replace = Pattern.compile("\\s+");

    public AnagramWord(String word) {
        cannibalisedWord = canonicalize(word);
    }

    public boolean isAnagram(String word) {
        return cannibalisedWord.equals(canonicalize(word));
    }

    private static String canonicalize(String s) {
        Matcher m = replace.matcher(s);
        return Stream.of(m.replaceAll("").split(""))
                .sorted().collect(Collectors.joining());
    }
}
