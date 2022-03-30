import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

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

    @Test
    public void testStringCalcMain(){
        InputStream is = new ByteArrayInputStream("1,2,3\n".getBytes(StandardCharsets.UTF_8));
        System.setIn(is);

        ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
        System.setOut(new PrintStream(bos));

        StringCalculator.main(new String[0]);

        assertEquals("Enter input:"+System.lineSeparator()+"The result is6"+System.lineSeparator(),bos.toString());
    }

    @Test
    public void testStringCalcContinuingRead(){
        InputStream is = new ByteArrayInputStream("1,2,3\n2,4\n3,3".getBytes(StandardCharsets.UTF_8));
        System.setIn(is);

        ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
        System.setOut(new PrintStream(bos));

        StringCalculator.main(new String[0]);

        assertEquals("Enter input:"+System.lineSeparator()+"The result is18"+System.lineSeparator(),bos.toString());
    }

    @Test
    public void testCustomDelimiters(){
        assertEquals(10, new StringCalculator(new ConsolLogger()).Add("//[***][%%%]\n1***4%%%5"));
    }



}
