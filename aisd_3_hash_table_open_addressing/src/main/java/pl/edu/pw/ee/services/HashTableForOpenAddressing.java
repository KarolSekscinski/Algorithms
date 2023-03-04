package pl.edu.pw.ee.services;

public interface HashTableForOpenAddressing<T extends Comparable<T>> {

    void put(T elem);

    T get(T elem);

    void delete(T elem);
}
