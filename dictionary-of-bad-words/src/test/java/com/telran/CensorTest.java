package com.telran;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class CensorTest {
    @Test
    public void testFindBadWords() {
        String text = "While things were uncomfortable and frightening for Belle at first," +
                " she soon grew fond of the beast," +
                " as he had done nothing but treat her with kindness." +
                " When Belle found out her father was sick, " +
                "she begged the beast to let her go to him and promised to return," +
                " but she was held up by the evil Gaston, " +
                "a famous hunter from the village who wanted to marry Belle." +
                " When the village found out about the beast, " +
                "they vowed to kill him and stormed his castle. " +
                "Though he nearly died, " +
                "he was saved and turned into a handsome prince because of Belle’s love for him. " +
                "It turns out that he had been a prince who, " +
                "along with his entire household, " +
                "was cursed by a witch because he did not treat her with kindness. " +
                "Belle and the Prince marry, and live a happy and peaceful life together.";
        Set<String> vocabulary = new HashSet<>();
        vocabulary.add("died");
        vocabulary.add("kill");
        vocabulary.add("beast");
        vocabulary.add("evil");
        vocabulary.add("cursed");
        vocabulary.add("witch");
        Censor censor = new Censor(vocabulary);
        // System.out.println(censor.findBadWords(text));
        List<String> expected = Arrays.asList("beast", "beast", "evil", "beast", "kill", "died",
                "cursed", "witch");
        Assert.assertEquals(expected, censor.findBadWords(text));
    }
}