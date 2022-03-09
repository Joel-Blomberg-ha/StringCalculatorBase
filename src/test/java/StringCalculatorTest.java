import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    @Test
    public void testEmptyStringReturnsZero(){
        assertEquals(0, new StringCalculator().Add(""));
    }

    @Test
    public void testSingleIntegerSum(){
    assertEquals(10, new StringCalculator().Add("10"));
    }

    @Test
    public void testMultipleIntegersSum(){
        assertEquals(10 , new  StringCalculator().Add("4,6"));
    }

    @Test
    public void testMultipleIntegerRowsSum(){
        assertEquals(10, new StringCalculator().Add("4\n1\n5"));
    }

    @Test
    public void testMultipleIntegerRowAndSum(){
        assertEquals(10, new StringCalculator().Add("4\n1,5"));
    }

    @Test
    public void testCustomSplitterSum(){
        assertEquals(10, new StringCalculator().Add("//;\n4;6"));
    }

    @Test
    public void testNegativeIntegerSum(){
        assertThrows(StringCalcException.class, () -> {new StringCalculator().Add("-10");});
    }
   /* @Test
    public void testNegatives(){
        assertEquals( ));
    }*/
}
