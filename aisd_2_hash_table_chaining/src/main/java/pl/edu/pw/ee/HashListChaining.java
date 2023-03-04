package pl.edu.pw.ee;

import pl.edu.pw.ee.services.HashTable;

import java.util.NoSuchElementException;

public class HashListChaining<T extends Comparable<T>> implements HashTable<T> {

    private final Elem<T> nil = null;
    private Elem<T>[] hashElems;
    private int nElem;


    public HashListChaining(int size) {
        if (size < 1) {
            throw new IllegalStateException("Cannot create HashTable with size less than 1!");
        }
        hashElems = new Elem[size];
        initializeHash();
    }

    @Override
    public void add(T value) {
        if (value == null) {
            throw new IllegalArgumentException("The value you're trying to add is null!");
        }
        int hashCode = value.hashCode();
        int hashId = countHashId(hashCode);

        Elem<T> oldElem = hashElems[hashId];

        while (oldElem != nil && !oldElem.value.equals(value)) {
            oldElem = oldElem.next;
        }
        if (oldElem != nil) {
            oldElem.value = value;
        } else {
            hashElems[hashId] = new Elem(value, hashElems[hashId]);
            nElem++;
        }
    }

    @Override
    public T get(T value) {
        if (value == null) {
            throw new IllegalArgumentException("The value you're trying to get is null!");
        }


        int hashCode = value.hashCode();
        int hashId = countHashId(hashCode);

        Elem<T> elem = hashElems[hashId];

        while (elem != nil && !elem.value.equals(value)) {
            elem = elem.next;
        }

        return elem != nil ? elem.value : null;

    }

    @Override
    public void delete(T value) {
        if (value == null) {
            throw new IllegalArgumentException("The value you're trying to delete is already null!");
        }
        int hashCode = value.hashCode();
        int hashId = countHashId(hashCode);

        Elem<T> elem = hashElems[hashId];

        if (elem == nil) {
            throw new NoSuchElementException("No such element in HashTable!");
        }
        if (elem.value.compareTo(value) == 0) {
            Elem<T> temp = elem.next;
            hashElems[hashId] = temp;
            nElem--;
            return;
        }
        while (elem.next != nil && elem.next.value.compareTo(value) != 0) {
            elem = elem.next;
        }
        if (elem.next == nil) {
            throw new NoSuchElementException("No such element in HashTable!");
        }
        if (elem.next.next != nil && elem.next.value.compareTo(value) == 0) {
            Elem<T> temp = elem.next.next;
            elem.next = temp;
            nElem--;
        }
        if (elem.next.next == nil && elem.next.value.compareTo(value) == 0) {
            elem.next = nil;
            nElem--;
        }
    }

    public double countLoadFactor() {
        double size = hashElems.length;
        return nElem / size;
    }

    public int getnElem() {
        return nElem;
    }

    private void initializeHash() {
        int n = hashElems.length;

        for (int i = 0; i < n; i++) {
            hashElems[i] = nil;
        }
    }

    private int countHashId(int hashCode) {
        if (hashCode == Integer.MIN_VALUE) {
            hashCode = Integer.MAX_VALUE;
        }
        int n = hashElems.length;
        return Math.abs(hashCode) % n;
    }

    private class Elem<T extends Comparable<T>> {
        private T value;
        private Elem next;

        Elem(T value, Elem<T> nextElem) {
            this.value = value;
            this.next = nextElem;
        }
    }


}