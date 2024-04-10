package edu.itstep;

public interface Calculator<T> {

    T add(T t1, T t2);
    T sub(T t1, T t2);
    T div(T t1, T t2);
    T mul(T t1, T t2);

}
