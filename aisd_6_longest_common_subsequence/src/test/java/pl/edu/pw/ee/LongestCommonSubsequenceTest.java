package pl.edu.pw.ee;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonSubsequenceTest {
    @Test
    public void checkIfLCSCouldReturnLongestLCS() {
        //given
        LongestCommonSubsequence lcs = new LongestCommonSubsequence
                ("PREZENTY", "RESZTA");

        //when
        String actual = lcs.findLCS();
        String expected = "REZT";

        //then
        assertEquals(expected, actual);
    }


    @Test
    public void checkIfLCSCouldReturnLongestLCSForSubsequenceFromISOD() {
        //givem
        LongestCommonSubsequence lcs =
                new LongestCommonSubsequence
                        ("często_z_odkrywaniem", "rzeczy_nie_trzeba\n_się_spieszyć");

        //when
        String actual = lcs.findLCS();
        String expected = "cz__raie";

        //hen
        assertEquals(expected, actual);

    }

    @Test(expected = IllegalArgumentException.class)
    public void checkIfLCSCouldReturnValueWhenStringsAreNull() {
        //given
        String firstStr = null;
        String secondStr = null;

        //when
        LongestCommonSubsequence lcs =
                new LongestCommonSubsequence(firstStr, secondStr);

        //then
        assert false;
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkIfLCSCouldReturnValueWhenOneStringIsNull() {
        //given
        String firstStr = null;
        String secondStr = "JAN";

        //when
        LongestCommonSubsequence lcs =
                new LongestCommonSubsequence(firstStr, secondStr);

        //then
        assert false;
    }

    @Test
    public void checkIfLCSCouldReturnValueWhenStringsAreEmpty() {
        //given
        String firstStr = "";
        String secondStr = "";
        LongestCommonSubsequence lcs =
                new LongestCommonSubsequence(firstStr, secondStr);

        //when
        String expected = "";
        String actual = lcs.findLCS();

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void checkIfLCSCouldReturnValueWhenStringsHaveTab() {
        //given
        String firstStr = "Jan\tPawel\tdwa";
        String secondStr = "Papiez\tpolak\t";
        LongestCommonSubsequence lcs =
                new LongestCommonSubsequence(firstStr, secondStr);

        //when
        String expected = "Pae\ta";
        String actual = lcs.findLCS();

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void checkIfLCSCouldReturnValueWhenStringsHaveNewLine() {
        //given
        String firstStr = "Jan\nPawel\ndwa";
        String secondStr = "Papiez\npolak\n";
        LongestCommonSubsequence lcs =
                new LongestCommonSubsequence(firstStr, secondStr);

        //when
        String expected = "Pae\na";
        String actual = lcs.findLCS();

        //then
        assertEquals(expected, actual);

    }

    @Test
    public void checkIfLCSCouldReturnValueWhenStringsHaveCarrigeReturn() {
        //given
        String firstStr = "Jan\rPawel\rdwa";
        String secondStr = "Papiez\rpolak\r";
        LongestCommonSubsequence lcs =
                new LongestCommonSubsequence(firstStr, secondStr);

        //when
        String expected = "Pae\ra";
        String actual = lcs.findLCS();

        //then
        assertEquals(expected, actual);

    }

    @Test
    public void checkIfLCSCouldReturnValueWhenStringsHaveSpecialCharacters() {
        //given
        String firstStr = "a \u001F b \u001E c \u001C e \f f \u000B j ";
        String secondStr = "x \u001F y \u001E w \u001C v \f a \u000B g ";
        LongestCommonSubsequence lcs =
                new LongestCommonSubsequence(firstStr, secondStr);

        //when
        String expected = " \u001F  \u001E  \u001C  \f  \u000B  ";
        String actual = lcs.findLCS();

        //then
        assertEquals(expected, actual);

    }

    @Test
    public void checkIfLCSCouldReturnValueWhenStringsHaveOneStringInAnother() {
        //given
        String firstStr = "PREZENTY";
        String secondStr = "REZENT";
        LongestCommonSubsequence lcs =
                new LongestCommonSubsequence(firstStr, secondStr);

        //when
        String expected = "REZENT";
        String actual = lcs.findLCS();

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void checkIfLCSCouldReturnValueWhenStringsAreSeparated() {
        //given
        String firstStr = "ABCDE";
        String secondStr = "FGHIJ";
        LongestCommonSubsequence lcs =
                new LongestCommonSubsequence(firstStr, secondStr);

        //when
        String expected = "";
        String actual = lcs.findLCS();

        //then
        assertEquals(expected, actual);

    }

    @Test
    public void checkIfLCSCouldReturnValueWhenStringsAreIdentical() {
        //given
        String firstStr = "PREZENTY";
        String secondStr = "PREZENTY";
        LongestCommonSubsequence lcs =
                new LongestCommonSubsequence(firstStr, secondStr);

        //when
        String expected = "PREZENTY";
        String actual = lcs.findLCS();

        //then
        assertEquals(expected, actual);

    }

    @Test
    public void checkIfDisplayMethodIsWorkingProperly() {
        //given
        String firstStr = "PREZENTY";
        String secondStr = "RESZTA";
        LongestCommonSubsequence lcs =
                new LongestCommonSubsequence(firstStr, secondStr);

        //when
        String actual = lcs.findLCS();
        String expected = "REZT";

        //then
        lcs.display();
        assertEquals(expected, actual);

    }

    @Test
    public void checkIfDisplayMethodIsWorkingProperlyForExampleFromIsod() {
        //given
        LongestCommonSubsequence lcs = new LongestCommonSubsequence
                ("często_z_odkrywaniem", "rzeczy_nie_trzeba\n_się_spieszyć");

        //when
        String actual = lcs.findLCS();
        String expected = "cz__raie";

        //then
        lcs.display();
        assertEquals(expected, actual);
    }
}
