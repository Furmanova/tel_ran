package com.telran;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class CountUniqueUsersTest {
    @Test
    public void testCountUniqueUsers2() {
        List<LogEntry> logEntryList = Arrays.asList(
                new LogEntry("Peter", "tel-ran.com"),
                new LogEntry("Peter", "tel-ran.com"),
                new LogEntry("Alx", "tel-ran.com"),
                new LogEntry("Alx", "tel-ran.com"),
                new LogEntry("Peter", "tel-ran.com/news"),
                new LogEntry("Alx", "tel-ran.com"),
                new LogEntry("Alx", "tel-ran.com/news"));
        Map<String, Integer> res = logEntryList.stream().collect(groupingBy(LogEntry::getUrl, new CountUniqueUsers()));
        System.out.println(res);

        Map<String, Integer> expectedResult = new HashMap<>();
        expectedResult.put("tel-ran.com/news", 2);
        expectedResult.put("tel-ran.com", 2);


        Assert.assertEquals(res, expectedResult);
    }


}