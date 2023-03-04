package pl.edu.pw.ee;

import pl.edu.pw.ee.services.HashTableForOpenAddressing;

import java.lang.reflect.Field;

public class HashTesting {
    public static int getNumOfElems(HashTableForOpenAddressing<?> hash) {
        String fieldNumOfElems = "nElems";
        try {

            Field field = hash.getClass().getSuperclass().getDeclaredField(fieldNumOfElems);
            field.setAccessible(true);

            int numOfElems = field.getInt(hash);

            return numOfElems;

        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getIndexOfElem(HashTableForOpenAddressing<?> hashTable, Comparable<?> elem) {
        String elems = "hashElems";
        try {

            Field field = hashTable.getClass().getSuperclass().getDeclaredField(elems);
            field.setAccessible(true);

            Comparable[] array = (Comparable[]) field.get(hashTable);
            int indexOfElem = -1;
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    if (array[i].equals(elem)) {
                        indexOfElem = i;
                    }
                }
            }
            return indexOfElem;
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }
}
