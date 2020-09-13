package com.telran;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculateUrlTest {
    @Test
    public void testCountForEachURLHowManyTimesItWasClickedOn1() {
        List<LogEntry> logEntryList = Arrays.asList(
                new LogEntry("Peter", "tel-ran.com"),
                new LogEntry("Peter", "tel-ran.com"),
                new LogEntry("Alx", "tel-ran.com"),
                new LogEntry("Alx", "tel-ran.com"),
                new LogEntry("Peter", "tel-ran.com"),
                new LogEntry("Alx", "tel-ran.com"),
                new LogEntry("Frank", "tel-ran.com/news"));
        Map<String, Long> expectedResult = new HashMap<>();
        expectedResult.put("tel-ran.com/news", 1L);
        expectedResult.put("tel-ran.com", 6L);
        Assert.assertEquals(expectedResult, CalculateUrl.
                countForEachURLHowManyTimesItWasClickedOn1(logEntryList));
    }

    @Test
    public void testCountUniqueUsers2(){
        List<LogEntry> logEntryList = Arrays.asList(
                new LogEntry("Peter", "tel-ran.com"),
                new LogEntry("Peter", "tel-ran.com"),
                new LogEntry("Alx", "tel-ran.com"),
                new LogEntry("Alx", "tel-ran.com"),
                new LogEntry("Peter", "tel-ran.com/news"),
                new LogEntry("Alx", "tel-ran.com"),
                new LogEntry("Alx", "tel-ran.com/news"));
        Map<String, Integer> expectedResult = new HashMap<>();
        expectedResult.put("tel-ran.com/news", 2);
        expectedResult.put("tel-ran.com", 2);
        System.out.println(CalculateUrl.countUniqueUsers2(logEntryList));
        Assert.assertEquals(expectedResult, CalculateUrl.
               countUniqueUsers2(logEntryList));
    }
    @Test
    public void testUniqueUrl3(){
        List<LogEntry> logEntryList = Arrays.asList(
                new LogEntry("Peter", "tel-ran.com"),
                new LogEntry("Peter", "tel-ran.com"),
                new LogEntry("Alx", "tel-ran.com"),
                new LogEntry("Alx", "tel-ran.com/?"),
                new LogEntry("Peter", "tel-ran.com/news"),
                new LogEntry("Alx", "tel-ran.com"),
                new LogEntry("Alx", "tel-ran.com/news"));
        Map<String, Integer> expectedResult = new HashMap<>();
        expectedResult.put("Alx", 3);
        expectedResult.put("Peter", 2);
        System.out.println(CalculateUrl.uniqueUrl3(logEntryList));
        Assert.assertEquals(expectedResult, CalculateUrl.
                uniqueUrl3(logEntryList));

    }
}