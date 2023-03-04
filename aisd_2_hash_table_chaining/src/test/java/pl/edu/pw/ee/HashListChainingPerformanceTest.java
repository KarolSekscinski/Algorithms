package pl.edu.pw.ee;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class HashListChainingPerformanceTest {

    private HashListChaining hash;

    private int size = 4096;

    private int numberOfWords = 100000;

    @Test
    public void checkingSpeedOfHashTableForMultiplesOf4096() throws FileNotFoundException {
        File words = new File("listOfWords.txt");

        Scanner readingLine = new Scanner(words);
        hash = new HashListChaining(64 * size);
        String[] arrayOfStrings = new String[numberOfWords];
        long[] arrayOfPerformance = new long[30];
        for (int i = 0; i < numberOfWords; i++) {
            arrayOfStrings[i] = readingLine.next();
            hash.add(arrayOfStrings[i]);
        }
        for (int i = 0; i < arrayOfPerformance.length; i++) {
            long expectedTimeToGet = System.currentTimeMillis();
            for (int j = 0; j < numberOfWords; j++) {
                hash.get(arrayOfStrings[j]);
            }
            long time = System.currentTimeMillis() - expectedTimeToGet;
            long finalTime = time;
            arrayOfPerformance[i] = finalTime;
        }
        Arrays.sort(arrayOfPerformance);
        int sum = 0;
        for (int i = 10; i < 20; i++) {
            sum += arrayOfPerformance[i];
        }
        int average = sum / 10;
        System.out.println(average);
    }

    @Test
    public void checkingSpeedOfHashTableForPrimeNumbers() throws FileNotFoundException {
        File words = new File("listOfWords.txt");
        Scanner readingLine = new Scanner(words);
        hash = new HashListChaining(131861);
        String[] arrayOfStrings = new String[numberOfWords];
        long[] arrayOfPerformance = new long[30];
        for (int i = 0; i < numberOfWords; i++) {
            arrayOfStrings[i] = readingLine.next();
            hash.add(arrayOfStrings[i]);
        }
        for (int i = 0; i < arrayOfPerformance.length; i++) {
            long expectedTimeToGet = System.currentTimeMillis();
            for (int j = 0; j < numberOfWords; j++) {
                hash.get(arrayOfStrings[j]);
            }
            long time = System.currentTimeMillis() - expectedTimeToGet;
            long finalTime = time;
            arrayOfPerformance[i] = finalTime;
        }
        Arrays.sort(arrayOfPerformance);
        int sum = 0;
        for (int i = 10; i < 20; i++) {
            sum += arrayOfPerformance[i];
        }
        int average = sum / 10;
        System.out.println(average);


    }

}
