package com.speedment.example.solution;

import com.speedment.example.unit.ExtraUnit;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static com.speedment.example.solution.TestUtil.tester;
import static java.util.stream.Collectors.toList;

final class MyExtraUnitTest {

    private final ExtraUnit instance = new MyExtraUnit();


    // http://minborgsjavapot.blogspot.com/2015/07/java-8-master-permutations.html
    @Test
    void factorial() {
        tester(
            instance,
            IntStream.rangeClosed(1, 21).mapToLong(n -> LongStream.range(1, n).reduce(1, (a, b) -> a * b)),
            ExtraUnit::factorial,
            s -> s.boxed().collect(toList())
        );
    }

    @Test
    void bigFactorial() {
        tester(
            instance,
            IntStream.iterate(1, a -> a + 1).mapToObj(n -> LongStream.range(1, n).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply)).limit(30),
            i -> i.bigFactorial().limit(30),
            s -> s.collect(toList())
        );
    }


}