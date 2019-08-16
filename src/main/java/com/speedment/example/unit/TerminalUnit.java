package com.speedment.example.unit;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public interface TerminalUnit {

    // Do Stuff

    void addToList(Stream<String> stream, List<String> list);


    // Convert list to collections and others

    List<String> collectToList(Stream<String> stream);

    Set<String> collectToSet(Stream<String> stream);

    Map<String, Integer> collectToMap(Stream<String> stream);

    String collectToString(Stream<String> stream);

    String[] toArray(Stream<String> stream);


    // Summarization

    long countCharacters(Stream<String> stream);

    int maxWordLen(Stream<String> stream);

    IntSummaryStatistics statistics(Stream<String> stream);


    // Map/Reduce



    // Grouping

    Map<Integer, List<String>> wordsGroupedByLength(Stream<String> stream);

    Map<String, Long> wordCountFrequencyMap(Stream<String> stream);

}
