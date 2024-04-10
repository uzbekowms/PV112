package edu.itstep.impl;

import edu.itstep.Calculator;

public class IntegerCalculator implements Calculator<Integer> {
    @Override
    public Integer add(Integer t1, Integer t2) {
        return t1 + t2;
    }

    @Override
    public Integer sub(Integer t1, Integer t2) {
        return t1 - t2;
    }

    @Override
    public Integer div(Integer t1, Integer t2) {
        return t1 / t2;
    }

    @Override
    public Integer mul(Integer t1, Integer t2) {
        return t1 * t2;
    }
}
