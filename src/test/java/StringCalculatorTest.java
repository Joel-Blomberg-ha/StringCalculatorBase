import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.*;



public class StringCalculatorTest {

    @Test
    public void testEmptyStringReturnsZero(){
        assertEquals(0, new StringCalculator(new ConsolLogger()).Add(""));
    }

    @Test
    public void testSingleIntegerSum(){
    assertEquals(10, new StringCalculator(new ConsolLogger()).Add("10"));
    }

    @Test
    public void testMultipleIntegersSum(){
        assertEquals(10 , new  StringCalculator(new ConsolLogger()).Add("4,6"));
    }

    @Test
    public void testMultipleIntegerRowsSum(){
        assertEquals(10, new StringCalculator(new ConsolLogger()).Add("4\n1\n5"));
    }

    @Test
    public void testMultipleIntegerRowAndSum(){
        assertEquals(10, new StringCalculator(new ConsolLogger()).Add("4\n1,5"));
    }

    @Test
    public void testCustomSplitterSum(){
        assertEquals(10, new StringCalculator(new ConsolLogger()).Add("//;\n4;6"));
    }

    @Test
    public void testNegativeIntegerSum(){
        assertThrows(StringCalcException.class, () -> {new StringCalculator(new ConsolLogger()).Add("-10");});
    }

    @Test
    public void testLoggerTwice(){
        ConsolLogger mock = mock(ConsolLogger.class);
        mock.log("test");
        mock.log("test");
        verify(mock,times(2)).log("test");
    }

    @Test
    public void testStringCalcLogging(){
        ConsolLogger mock = mock(ConsolLogger.class);
        new StringCalculator(mock).Add("10000");
        verify(mock,times(1)).log("10000");
    }


}
