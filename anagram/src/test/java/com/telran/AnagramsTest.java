package com.telran;

import org.junit.Assert;
import org.junit.Test;


public class AnagramsTest {


    @Test
    public void testAnagrams1() {

        Assert.assertTrue(new AnagramWord("mama nina").isAnagram("amam anin"));
        System.out.println(new AnagramWord("mama nina").isAnagram("amam anin"));
    }

    @Test
    public void testAnagrams2() {

        Assert.assertTrue(new AnagramWord("auto audi").isAnagram("toau diua"));
        System.out.println(new AnagramWord("auto audi").isAnagram("toau diua"));

    }

    @Test
    public void testAnagrams3() {
        Assert.assertTrue(new AnagramWord("mama nina").isAnagram("amamanin"));
        System.out.println(new AnagramWord("mama nina").isAnagram("amamanin"));

    }

    @Test
    public void testAnagrams4() {
        Assert.assertFalse(new AnagramWord("mama nina").isAnagram("amamd anin"));
        System.out.println(new AnagramWord("mama nina").isAnagram("amamd anin"));

    }

    @Test
    public void testAnagrams5() {

        Assert.assertFalse(new AnagramWord("hello world").isAnagram("hollellwldor"));
        System.out.println(new AnagramWord("hello world").isAnagram("hollellwldor"));
    }

}