package com.telran;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


public class CalculateUrl {
    public static Map<String, Long> countForEachURLHowManyTimesItWasClickedOn1(List<LogEntry> logEntries) {
        return logEntries.stream().collect(groupingBy(LogEntry::getUrl,
                Collectors.counting()));

    }

    public static Map<String, Integer> countUniqueUsers2(List<LogEntry> logEntries) {
        Map<String, Set<String>> usernameMap = logEntries.stream()
                .collect(groupingBy(LogEntry::getUrl,
                        mapping(LogEntry::getUserName, toSet())));
        return usernameMap.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue().size()
                ));
    }

    public static Map<String, Integer> uniqueUrl3(List<LogEntry> logEntries) {
        Map<String, Set<String>> urlMap = logEntries.stream()
                .collect(groupingBy(LogEntry::getUserName,
                        mapping(LogEntry::getUrl, toSet())));
        return urlMap.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue().size()));


    }


}