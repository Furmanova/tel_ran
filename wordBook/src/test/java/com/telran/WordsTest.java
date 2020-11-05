package com.telran;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class WordsTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }
    @Test
    void testDoStuff1() {
        assertEquals(Map.of('a', List.of("a","abc","acb"),
                'b',List.of("baa","bac"),
                'c',List.of("cab")),
                task.doStuff(List.of("acb","a","abc","cab","bac","baa")));
    }
    @Test
    void testDoThing() {
        assertEquals(Map.of("a",List.of("a","abc","acb"),
                "b",List.of("baa","bac"),
                "c",List.of("cab")),
                task.doThing(List.of("acb","a","abc","cab","bac","baa")));
    }
}