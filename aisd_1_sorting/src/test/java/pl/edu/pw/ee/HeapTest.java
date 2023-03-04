package pl.edu.pw.ee;

import java.util.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTest {
    private static final double S = 0;
    private List<Double> dataDouble;
    private List<String> dataString;
    private Heap<Double> heapDouble;
    private Heap<String> heapString;

    @Test
    public void givenOneNegativeInteger_whenSignedRightShiftOperator_thenNewDecimalNumber() {
    int value = -12;
    System.out.println(Integer.toBinaryString(value));
    int rightShift = value >> 2;
    System.out.println(Integer.toBinaryString(rightShift));
            
    assertEquals(-3, rightShift);
}
    @Test
public void givenOneNegativeInteger_whenUnsignedRightShiftOperator_thenNewDecimalNumber() {
    int value = -12;
        System.out.println(Integer.toBinaryString(value));
    int unsignedRightShift = value >>> 2;
        System.out.println(unsignedRightShift);
    assertEquals(1073741821, unsignedRightShift);
}
    @Test
    public void shouldCorrectlyUseIsItHeapMethodForHeapArray() {
        //given
        dataDouble = new ArrayList<>();
        heapDouble = new Heap<>(dataDouble);
        //when
        heapDouble.put(1.);
        heapDouble.put(3.);
        heapDouble.put(5.);
        heapDouble.put(4.);
        heapDouble.put(6.);
        heapDouble.put(13.);
        heapDouble.put(10.);
        heapDouble.put(9.);
        heapDouble.put(8.);
        heapDouble.put(15.);
        heapDouble.put(17.);
        //then
        heapDouble.build();
        assertTrue(heapDouble.isItHeap());
    }

    @Test
    public void shouldCorrectlyUseIsItHeapMethodForNonHeapArray() {
        //given
        dataDouble = new ArrayList<>();
        heapDouble = new Heap<>(dataDouble);
        //when
        heapDouble.put(1.);
        heapDouble.put(3.);
        heapDouble.put(5.);
        heapDouble.put(4.);
        heapDouble.put(6.);
        heapDouble.put(13.);
        heapDouble.put(10.);
        heapDouble.put(9.);
        heapDouble.put(8.);
        heapDouble.put(15.);
        heapDouble.put(17.);
        //then
        assertFalse(heapDouble.isItHeap());
    }

    @Test
    public void shouldCorrectlyUseHeapifyMethod() {
        //given
        dataDouble = new ArrayList<>();
        heapDouble = new Heap<>(dataDouble);
        //when
        heapDouble.put(1.);
        heapDouble.put(3.);
        heapDouble.put(5.);
        heapDouble.put(4.);
        heapDouble.put(6.);
        heapDouble.put(13.);
        heapDouble.put(10.);
        heapDouble.put(9.);
        heapDouble.put(8.);
        heapDouble.put(15.);
        heapDouble.put(17.);

        heapDouble.heapify(4, heapDouble.getData().size());
        //then
        double[] expected = {1.0, 3.0, 5.0, 4.0, 17.0, 13.0, 10.0, 9.0, 8.0, 15.0, 6.0};
        double[] actual = new double[heapDouble.getData().size()];
        for (int i = 0; i < heapDouble.getData().size(); i++) {
            actual[i] = heapDouble.getData().get(i);
        }
        assertArrayEquals(expected, actual, S);
    }

    @Test
    public void shouldCorrectlyUseBuildMethod() {
        //given
        dataDouble = new ArrayList<>();
        heapDouble = new Heap<>(dataDouble);
        //when
        heapDouble.put(1.);
        heapDouble.put(3.);
        heapDouble.put(5.);
        heapDouble.put(4.);
        heapDouble.put(6.);
        heapDouble.put(13.);
        heapDouble.put(10.);
        heapDouble.put(9.);
        heapDouble.put(8.);
        heapDouble.put(15.);
        heapDouble.put(17.);
        heapDouble.build();
        //then
        double[] expected = {17.0, 15.0, 13.0, 9.0, 6.0, 5.0, 10.0, 4.0, 8.0, 3.0, 1.0};
        double[] actual = new double[heapDouble.getData().size()];
        for (int i = 0; i < heapDouble.getData().size(); i++) {
            actual[i] = heapDouble.getData().get(i);
        }
        assertArrayEquals(expected, actual, S);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldBuildCorrectlyHeapWhenAddedNull() {
        //given
        dataDouble = new ArrayList<>();
        heapDouble = new Heap<>(dataDouble);
        //when
        Double item = null;
        heapDouble.put(item);
        heapDouble.build();
        //then
        assert false;
    }

    @Test
    public void shouldBuildCorrectlyHeapAfterRemovingElements() {
        //given
        dataDouble = new ArrayList<>();
        heapDouble = new Heap<>(dataDouble);
        //when
        heapDouble.put(1.);
        heapDouble.put(3.);
        heapDouble.put(5.);
        heapDouble.put(4.);
        heapDouble.put(6.);
        heapDouble.put(13.);
        heapDouble.put(10.);
        heapDouble.put(9.);
        heapDouble.put(8.);
        heapDouble.put(15.);
        heapDouble.put(17.);
        heapDouble.build();
        heapDouble.pop();
        heapDouble.pop();
        heapDouble.pop();
        //then
        double[] expected = {10.0, 9.0, 5.0, 8.0, 6.0, 1.0, 3.0, 4.0};
        double[] actual = new double[heapDouble.getData().size()];
        for (int i = 0; i < heapDouble.getData().size(); i++) {
            actual[i] = heapDouble.getData().get(i);
        }
        assertArrayEquals(expected, actual, S);
    }

    @Test
    public void shouldBuildCorrectlyHeapWhenAddedStrings() {
        //given
        dataString = new ArrayList<>();
        heapString = new Heap<>(dataString);
        //when
        heapString.put("D");
        heapString.put("A");
        heapString.put("B");
        heapString.put("C");
        heapString.put("E");
        heapString.put("G");
        heapString.put("J");
        heapString.put("I");
        heapString.put("K");
        heapString.build();
        //then
        String[] expected = {"K", "I", "J", "D", "E", "G", "B", "A", "C"};
        String[] actual = new String[heapString.getData().size()];
        for (int i = 0; i < heapString.getData().size(); i++) {
            actual[i] = heapString.getData().get(i);
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldBuildCorrectlyHeapWhenRemovingFromCompleteHeap() {
        //given
        dataDouble = new ArrayList<>();
        heapDouble = new Heap<>(dataDouble);
        //when
        heapDouble.put(1.);
        heapDouble.put(3.);
        heapDouble.put(5.);
        heapDouble.put(4.);
        heapDouble.put(6.);
        heapDouble.put(13.);
        heapDouble.put(10.);
        heapDouble.put(9.);
        heapDouble.put(8.);
        heapDouble.put(15.);
        heapDouble.put(17.);
        heapDouble.put(20.);
        heapDouble.put(14.);
        heapDouble.put(7.);
        heapDouble.put(11.);
        heapDouble.build();
        //then
        double[] expected = {20.0, 17.0, 14.0, 9.0, 15.0, 13.0, 11.0, 4.0, 8.0, 3.0, 6.0, 1.0, 5.0, 7.0, 10.0};
        double[] actual = new double[heapDouble.getData().size()];
        for (int i = 0; i < heapDouble.getData().size(); i++) {
            actual[i] = heapDouble.getData().get(i);
        }
        assertArrayEquals(expected, actual, S);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldBuildCorrectlyHeapWhenRemovingFromEmptyHeap() {
        //given
        dataDouble = new ArrayList<>();
        heapDouble = new Heap<>(dataDouble);
        //when
        heapDouble.pop();
        //then
        assert false;
    }

    @Test
    public void shouldBuildCorrectlyHeapWhenAddedBigAndRandomlyGeneratedDataSet() {

        //given
        dataDouble = new ArrayList<>();
        heapDouble = new Heap<>(dataDouble);
        int bigNumber = 1000000;
        Random number = new Random(213);
        for (int i = 0; i < bigNumber; i++) {
            heapDouble.put(number.nextDouble());
        }
        double[] expectedArray = new double[bigNumber];
        for (int i = 0; i < heapDouble.getData().size(); i++) {
            expectedArray[i] = heapDouble.getData().get(i);
        }
        Arrays.sort(expectedArray);
        double expected = expectedArray[expectedArray.length - 1];
        //when
        heapDouble.build();
        //then
        double actual = heapDouble.getData().get(0);
        assertEquals(expected, actual, S);

    }
}
