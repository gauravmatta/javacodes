package com.javaimplant.java17.features.interfaces;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public interface InterfaceWithPrivateMethods {
    default int addEvens(int... nums) {
        return addNums(n -> n % 2 == 0, nums);
    }
    default int addOdds(int... nums) {
        return addNums(n -> n % 2 != 0, nums);
    }

    default int addGreaterThanFive(int... nums) {
        return addNums(n -> n > 5, nums);
    }

    private int addNums(IntPredicate predicate, int... nums) {
        return IntStream.of(nums).filter(predicate).sum();
    }
}