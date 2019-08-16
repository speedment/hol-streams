package com.speedment.example.solution;

import com.speedment.example.unit.ExtraUnit;

import java.io.File;
import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MyExtraUnit implements ExtraUnit {

    @Override
    public LongStream factorial() {
        return IntStream.rangeClosed(1, 21).mapToLong(n -> LongStream.range(1, n). reduce(1, (a, b) -> a * b));
    }

    @Override
    public Stream<BigInteger> bigFactorial() {
        return Stream.empty();
    }

    @Override
    public IntStream primes() {
        return IntStream.empty();
    }

    @Override
    public Stream<File> filesInTheCurrentDirectoryOrderBySize() {
        return Stream.empty();
    }
}
