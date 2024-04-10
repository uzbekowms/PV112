package edu.itstep.impl;

import edu.itstep.Calculator;

public class DoubleCalculator<X, T> implements Calculator<X> {

    @Override
    public X add(X t1, X t2) {
        return null;
    }

    @Override
    public X sub(X t1, X t2) {
        return null;
    }

    @Override
    public X div(X t1, X t2) {
        return null;
    }

    @Override
    public X mul(X t1, X t2) {
        return null;
    }
}


class ExtendedDoubleCalculator<T, K, V> extends DoubleCalculator<T, K> {
    public V get(V v1) {
        return null;
    }
}