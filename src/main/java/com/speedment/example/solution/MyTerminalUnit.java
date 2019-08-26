package com.speedment.example.solution;

import com.speedment.example.unit.TerminalUnit;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public final class MyTerminalUnit implements TerminalUnit {

    @Override
    public void addToSet(Stream<String> stream, Set<String> set) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addToListInOrder(Stream<String> stream, List<String> list) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<String> collectToSet(Stream<String> stream) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> collectToList(Stream<String> stream) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String collectJoining(Stream<String> stream) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String[] toArray(Stream<String> stream) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map<String, Integer> collectToMap(Stream<String> stream) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int countCharacters(Stream<String> stream) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int maxWordLen(Stream<String> stream) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IntSummaryStatistics statistics(Stream<String> stream) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<String> findLongestString(Stream<String> stream) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map<Integer, List<String>> wordsGroupedByLength(Stream<String> stream) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map<Integer, Long> wordsGroupedByLengthCounted(Stream<String> stream) {
        throw new UnsupportedOperationException();
    }

}
