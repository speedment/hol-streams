package com.speedment.example.solution;

import com.speedment.example.unit.Unit3Terminal;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Collections.*;

public final class Unit3MyTerminal implements Unit3Terminal {

    @Override
    public void addToSet(Stream<String> stream, Set<String> set) {

    }

    @Override
    public void addToListInOrder(Stream<String> stream, List<String> list) {

    }

    @Override
    public Set<String> collectToSet(Stream<String> stream) {
        return emptySet();
    }

    @Override
    public List<String> collectToList(Stream<String> stream) {
        return emptyList();
    }

    @Override
    public String collectJoining(Stream<String> stream) {
        return null;
    }

    @Override
    public String[] toArray(Stream<String> stream) {
        return new String[0];
    }

    @Override
    public Map<String, Integer> collectToMap(Stream<String> stream) {
        return emptyMap();
    }

    @Override
    public int countCharacters(Stream<String> stream) {
        return 0;
    }

    @Override
    public int maxWordLen(Stream<String> stream) {
        return 0;
    }

    @Override
    public IntSummaryStatistics statistics(Stream<String> stream) {
        return new IntSummaryStatistics();
    }

    @Override
    public Optional<String> findLongestString(Stream<String> stream) {
        return Optional.empty();
    }

    @Override
    public Map<Integer, List<String>> wordsGroupedByLength(Stream<String> stream) {
        return emptyMap();
    }

    @Override
    public Map<Integer, Long> wordsGroupedByLengthCounted(Stream<String> stream) {
        return emptyMap();
    }

}
