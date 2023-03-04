package pl.edu.pw.ee;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DeterministicFiniteAutomatonTextSearchTest {
    
    
    
    
    
    @Test
    public void testAutomationTextSearch() {
        //given
        String pattern = "ABACABC";
        String text = "CABABACABCAAAC";
        DeterministicFiniteAutomatonTextSearch automat = new DeterministicFiniteAutomatonTextSearch(pattern);
        
        //when
        int actual = automat.findFirst(text);
        int expected = 3;
        
        //then
        assertEquals(expected, actual);
        
    }
    
    @Test
    public void testAutomationTextSearchForAll(){
        DeterministicFiniteAutomatonTextSearch automat = new DeterministicFiniteAutomatonTextSearch("motyw");
        int [] array = new int[3];
        array[0] = 4;
        array[1] = 10;
        array[2] = 20;
        Assert.assertArrayEquals(array, automat.findAll("motomotywomotywotootmotywoy"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAutomationTextSearchForNullPattern() {
        DeterministicFiniteAutomatonTextSearch automat = new DeterministicFiniteAutomatonTextSearch(null);
        assert false;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAutomationTextSearchForNullText(){
        DeterministicFiniteAutomatonTextSearch automat = new DeterministicFiniteAutomatonTextSearch("motyw");
        automat.findAll(null);
        assert false;
    }

    @Test
    public void testAutomationTextSearchForAllNoMatchingPattern(){
        DeterministicFiniteAutomatonTextSearch automat = new DeterministicFiniteAutomatonTextSearch("motyw");
        Assert.assertEquals(0, automat.findAll("motomotwomotyotootmtywoo").length);
    }
    @Test
    public void voidText() {
        DeterministicFiniteAutomatonTextSearch automat = new DeterministicFiniteAutomatonTextSearch("motyw");
        int [] actual = automat.findAll("");
        int actualSize = actual.length;
        int expectedSize = 0;
        assertEquals(expectedSize, actualSize);
    }
    
    @Test
    public void voidPattern() {
        DeterministicFiniteAutomatonTextSearch automat = new DeterministicFiniteAutomatonTextSearch("");
        automat.findAll("motomotywomotywotootmotywoy");
        int [] actual = automat.findAll("");
        int actualSize = actual.length;
        int expectedSize = 0;
        assertEquals(expectedSize, actualSize);
    }
    
     @Test
    public void voidTextForFirst() {
        DeterministicFiniteAutomatonTextSearch automat = new DeterministicFiniteAutomatonTextSearch("motyw");
        
        int actualSize = automat.findFirst("");
        int expectedSize = -1;
        assertEquals(expectedSize, actualSize);
        
    }
    
    @Test
    public void voidPatternForFirst() {
        DeterministicFiniteAutomatonTextSearch automat = new DeterministicFiniteAutomatonTextSearch("");
        
        int actualSize = automat.findFirst("motomotywomotywotootmotywoy");
        int expectedSize = 1;
        assertEquals(expectedSize, actualSize);
    }
    
}
