import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class StudentPrinterTest {

    @Test
    public void testExampleInput() {
        Writer writer = new StringWriter();
        StudentsPrinter studentsPrinter = new StudentsPrinter(writer);
        studentsPrinter.printStudents(readerFromTestResource("test_input.csv"));
        String output = writer.toString();
        assertEquals(expected(), output);
    }

    private Reader readerFromTestResource(String resourcePath) {
        return new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream(resourcePath)));
    }

    private String expected() {
        return
        "1,Erez,ERROR" + "\n" +
        "2,Netanel,82.5,English,Math" + "\n" +
        "3,Ronen,80,English";
    }
}
