package edu.itstep.repository;

public interface JpaRepository<ID, T> {

    T findById(ID id);

    java.util.List<T> findAll();

    T save(T t);

}
