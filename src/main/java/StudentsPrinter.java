import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;


public class StudentsPrinter {

    private final Writer writer;

    public StudentsPrinter(Writer writer){
        this.writer = writer;
    }

    public void printStudents(Reader csvFile) {
        List<String[]> rows = readRows(csvFile);
        printStudents(rows);
    }

    private void printStudents(List<String[]> rows){
        //YOUR CODE SHOULD COME HERE
    }

    private List<String[]> readRows(Reader csvFile){
        try {
            CSVReader reader = new CSVReader(csvFile);
            return reader.readAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
