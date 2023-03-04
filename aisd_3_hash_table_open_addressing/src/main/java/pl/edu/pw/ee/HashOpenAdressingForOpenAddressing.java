package pl.edu.pw.ee;

import pl.edu.pw.ee.services.HashTableForOpenAddressing;

import java.util.NoSuchElementException;

public abstract class HashOpenAdressingForOpenAddressing<T extends Comparable<T>> implements HashTableForOpenAddressing<T> {

    private final T nil = null;

    private final T delete = (T) new Comparable<T>() {

        @Override
        public int compareTo(T o) {
            return 0;
        }
    };
    private final double correctLoadFactor;
    private int size;
    private int nElems;
    private T[] hashElems;

    HashOpenAdressingForOpenAddressing() {
        this(2039);
    }

    HashOpenAdressingForOpenAddressing(int size) {
        validateHashInitSize(size);

        this.size = size;
        this.hashElems = (T[]) new Comparable[this.size];
        this.correctLoadFactor = 0.75;
    }

    @Override
    public void put(T newElem) {

        validateInputElem(newElem);
        resizeIfNeeded();

        int key = newElem.hashCode();
        int i = 0;
        int hashId = hashFunc(key, i);
        int tempId;

        while (hashElems[hashId] != nil && hashElems[hashId] != delete) {

            if (hashElems[hashId].compareTo(newElem) == 0) {
                hashElems[hashId] = newElem;
                return;
            }
            if (i + 1 == size) {
                doubleResize();
                i = -1;
            }
            i = (i + 1) % size;
            hashId = hashFunc(key, i);
        }
        if (hashElems[hashId] == delete) {
            tempId = hashId;
            i = (i + 1) % size;
            hashId = hashFunc(key, i);
            while (hashElems[hashId] != nil && hashElems[hashId].compareTo(newElem) != 0) {
                i = (i + 1) % size;
                hashId = hashFunc(key, i);
                if (i == 0) {
                    break;
                }
            }
            if (hashElems[hashId] != nil && hashElems[hashId] != delete && hashElems[hashId].compareTo(newElem) == 0) {
                hashElems[hashId] = newElem;
                return;
            }
            hashElems[tempId] = newElem;
            nElems++;
            return;
        }
        hashElems[hashId] = newElem;
        nElems++;


    }

    @Override
    public T get(T value) {
        validateInputElem(value);

        int key = value.hashCode();
        int i = 0;
        int hashId = hashFunc(key, i);

        while (hashElems[hashId] != nil) {
            if (hashElems[hashId] != delete && hashElems[hashId].compareTo(value) == 0) {
                return hashElems[hashId];
            }
            i = (i + 1) % size;
            hashId = hashFunc(key, i);
            if (i == 0) {
                break;
            }

        }
        if (hashElems[hashId] == null) {
            throw new NoSuchElementException("The elem isn't in hashTable!");
        }
        return null;
    }

    @Override
    public void delete(T elemToDelete) {
        validateInputElem(elemToDelete);

        int key = elemToDelete.hashCode();
        int i = 0;
        int hashId = hashFunc(key, i);
        while (hashElems[hashId] != nil) {
            if (hashElems[hashId].compareTo(elemToDelete) == 0) {
                hashElems[hashId] = delete;
                nElems--;
                return;
            }
            i = (i + 1) % size;
            hashId = hashFunc(key, i);
            if (i == 0) {
                break;
            }
        }
    }

    private void validateHashInitSize(int initialSize) {
        if (initialSize < 1) {
            throw new IllegalArgumentException("Initial size of hash table cannot be lower than 1!");
        }
    }

    private void validateInputElem(T newElem) {
        if (newElem == null) {
            throw new IllegalArgumentException("Input elem cannot be null!");
        }
    }

    abstract int hashFunc(int key, int i);

    int getSize() {
        return size;
    }

    private void resizeIfNeeded() {
        double loadFactor = countLoadFactor();

        if (loadFactor >= correctLoadFactor) {
            doubleResize();
        }
    }

    private double countLoadFactor() {
        return (double) nElems / size;
    }

    private void doubleResize() {

        this.size *= 2;
        nElems = 0;
        T[] oldElems = hashElems;
        hashElems = (T[]) new Comparable[this.size];


        for (T elem : oldElems) {
            if (elem != nil && elem != delete) {
                put(elem);
            }
        }
    }
}
