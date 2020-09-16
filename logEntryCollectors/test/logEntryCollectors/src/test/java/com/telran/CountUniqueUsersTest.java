package com.telran;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CountUniqueUsersTest {
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
        Integer res = logEntryList.stream().collect(new CountUniqueUsers());
        System.out.println(res);

        Map<String, Integer> expectedResult = new HashMap<>();
        expectedResult.put("tel-ran.com/news", 2);
        expectedResult.put("tel-ran.com", 2);


      Assert.assertEquals(res,expectedResult);
    }


}