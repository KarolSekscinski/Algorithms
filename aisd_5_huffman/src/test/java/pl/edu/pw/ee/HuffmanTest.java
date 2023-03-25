package pl.edu.pw.ee;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class HuffmanTest {
    @Test
    public void checkIfHuffmanCouldEncodeCharactersForTest1() throws IOException {
        //given
        Huffman coding = new Huffman();
        int expected = 24;


        //when
        int actual = coding.huffman("src/main/resources/test1", true);

        //then
        assertEquals(expected, actual);

    }

    @Test
    public void checkIfHuffmanCouldDecodeCharactersForTest1() throws IOException {
        //given
        Huffman coding = new Huffman();
        int expected = 8;

        //when
        int actual = coding.huffman("src/main/resources/test1", false);

        //then
        assertEquals(expected, actual);

    }

    @Test
    public void checkIfHuffmanCouldEncodeCharactersForTest2() throws IOException {
        //given
        Huffman coding = new Huffman();
        int expected = 584;


        //when
        int actual = coding.huffman("src/main/resources/test2", true);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void checkIfHuffmanCouldDecodeCharactersForTest2() throws IOException {
        //given
        Huffman coding = new Huffman();
        int expected = 171;

        //when
        int actual = coding.huffman("src/main/resources/test2", false);

        //then
        assertEquals(expected, actual);

    }

    @Test
    public void checkIfHuffmanCouldEncodeCharactersForTest3() throws IOException {
        //given
        Huffman coding = new Huffman();
        int expected = 8904;

        //when
        int actual = coding.huffman("src/main/resources/test3", true);

        //then
        assertEquals(expected, actual);

    }

    @Test
    public void checkIfHuffmanCouldDecodeCharactersForTest3() throws IOException {
        //given
        Huffman coding = new Huffman();
        int expected = 1970;

        //when
        int actual = coding.huffman("src/main/resources/test3", false);

        //then
        assertEquals(expected, actual);

    }

    @Test
    public void checkIfHuffmanCouldEncodeCharactersForTest4() throws IOException {
        //given
        Huffman coding = new Huffman();
        int expected = 8;

        //when
        int actual = coding.huffman("src/main/resources/test4", true);

        //then
        assertEquals(expected, actual);

    }

    @Test
    public void checkIfHuffmanCouldDecodeCharactersForTest4() throws IOException {
        //given
        Huffman coding = new Huffman();
        int expected = 1;

        //when
        int actual = coding.huffman("src/main/resources/test4", false);

        //then
        assertEquals(expected, actual);

    }

    @Test(expected = IllegalArgumentException.class)
    public void checkIfHuffmanCouldEncodeCharactersForTest5() throws IOException {
        //given
        Huffman coding = new Huffman();


        //when
        int actual = coding.huffman("src/main/resources/test5", true);

        //then
        assert false;

    }

    @Test(expected = FileNotFoundException.class)
    public void checkIfHuffmanCouldDecodeCharactersForTest5() throws IOException {
        //given
        Huffman coding = new Huffman();


        //when
        int actual = coding.huffman("src/main/resources/test5", false);

        //then
        assert false;

    }

    @Test(expected = FileNotFoundException.class)
    public void checkIfHuffmanCouldEncodeCharactersForTest6() throws IOException {
        //given
        Huffman coding = new Huffman();


        //when
        int actual = coding.huffman("src/main/resources/test6", true);

        //then
        assert false;

    }

    @Test(expected = FileNotFoundException.class)
    public void checkIfHuffmanCouldDecodeCharactersForTest6() throws IOException {
        //given
        Huffman coding = new Huffman();


        //when
        int actual = coding.huffman("src/main/resources/test6", false);

        //then
        assert false;

    }

    @Test(expected = IllegalArgumentException.class)
    public void checkIfHuffmanCouldEncodeCharactersForTest7() throws IOException {
        //given
        Huffman coding = new Huffman();

        //when
        int actual = coding.huffman("src/main/resources/test7", true);

        //then
        assert false;

    }

    @Test(expected = FileNotFoundException.class)
    public void checkIfHuffmanCouldDecodeCharactersForTest7() throws IOException {
        //given
        Huffman coding = new Huffman();

        //when
        int actual = coding.huffman("src/main/resources/test7", false);

        //then
        assert false;

    }

    @Test
    public void checkIfHuffmanCouldEncodeCharactersForTest8() throws IOException {
        //given
        Huffman coding = new Huffman();
        int expected = 8904;

        //when
        int actual = coding.huffman("src/main/resources/test8", true);

        //then
        assertEquals(expected, actual);

    }

    @Test
    public void checkIfHuffmanCouldDecodeCharactersForTest8() throws IOException {
        //given
        Huffman coding = new Huffman();
        int expected = 1970;

        //when
        int actual = coding.huffman("src/main/resources/test8", false);

        //then
        assertEquals(expected, actual);

    }

    @Test
    public void checkIfHuffmanCouldEncodeCharactersForTest9() throws IOException {
        //given
        Huffman coding = new Huffman();
        int expected = 176;

        //when
        int actual = coding.huffman("src/main/resources/test9", true);

        //then
        assertEquals(expected, actual);

    }

    @Test
    public void checkIfHuffmanCouldDecodeCharactersForTest9() throws IOException {
        //given
        Huffman coding = new Huffman();
        int expected = 40;

        //when
        int actual = coding.huffman("src/main/resources/test9", false);

        //then
        assertEquals(expected, actual);

    }

}
