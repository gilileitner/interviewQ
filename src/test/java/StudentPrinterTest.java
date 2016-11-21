import org.junit.Test;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;

import static org.junit.Assert.assertEquals;

public class StudentPrinterTest {

    @Test
    public void testExampleInput() {
        Writer writer = new StringWriter();
        StudentsPrinter studentsPrinter = new StudentsPrinter(writer);
        studentsPrinter.printStudents(new File("test_input.csv"));
        String output = writer.toString();
        assertEquals(expected(), output);
    }

    private String expected() {
        return
        "1,Erez,ERROR" + "\n" +
        "2.Netanel,82.5,Math,English" + "\n" +
        "3,Ronen,80,English";
    }
}
