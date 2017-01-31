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
        printStudents((Vector<String[]>)rows);
    }

    private List<String[]> readRows(Reader csvFile){
        try {
            CSVReader reader = new CSVReader(csvFile);
            return reader.readAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
public void printStudents(Vector<String[]> rows){
        Vector<Student> Students=new Vector<Student>();
        for(int i=0;i<rows.size();i++){
            Vector<String> Row=DivideString(rows.elementAt(i));
            if(StudentIsNew(Students,Row.elementAt(0)))
                Students.add(new Student(Row));
            else
                if(CourseIsNew(Students,Row.elementAt(0),Row.elementAt(2))){
                    for(int j=0;j<Students.size();j++)
                        if(Students.elementAt(j).StudentId.equals(Row.elementAt(0)))
                            Students.elementAt(j).Legal=false;
                }
                else
                    AddCourse(Students,Row);
        }
        //calculate average
        for(int j,i=0;i<Students.size();i++)
            if(Students.elementAt(i).Legal){
                for(j=0;j<Students.elementAt(i).Courses.size();j++)
                    Students.elementAt(i).Average+=Students.elementAt(i).Courses.elementAt(j).Grade;
                Students.elementAt(i).Average/=j;
            }
        //printing started
        //STILL HAVE TO PRINT THE SUBJECTS SORTED
        for (int i = 0; i < Students.size(); i++) {
            if(Students.elementAt(i).Legal)
                System.out.println(Students.elementAt(i).StudentId+". "+Students.elementAt(i).StudentName+", the average is: "+Students.elementAt(i).Average);
            else
                System.out.println(Students.elementAt(i).StudentId+". "+Students.elementAt(i).StudentName+" ERROR!");
        }
    }
    
    public Vector<String> DivideString(String[] row){
        int i,j; 
        String[] string=null;
        Vector<String> Strings=new Vector<String>();
        
        for(i=0;row[i]!="";i++){
            for(j=0;row[i]!=","&&row[i]!="";i++,j++)
                string[j]=row[i];
            Strings.add(string.toString());
            string=null;
        }
      return Strings;
    }
    public boolean StudentIsNew(Vector<Student> students,String studentId){
        for(int i=0;i<students.size();i++)
            if(students.elementAt(i).StudentId.equals(studentId))
                return false;
        return true;
}
    public boolean CourseIsNew(Vector<Student> students,String studentId,String courseName){
         for(int i=0;i<students.size();i++)
            if(students.elementAt(i).StudentId.equals(studentId))
                for(int j=0;j<students.elementAt(i).Courses.size();j++)
                    if(students.elementAt(i).Courses.elementAt(j).CourseName.equals(courseName))
                        return false;
         return true;
    }
    public void AddCourse(Vector<Student> students,Vector<String> row){
        for(int i=0;i<students.size();i++)
            if(students.elementAt(i).equals(row.elementAt(0)))
                students.elementAt(i).Courses.add(new Course(row.elementAt(2),row.elementAt(3)));
    }

}

class Student{
    public String StudentId;
    public String StudentName;
    public Vector<Course> Courses=new Vector<Course>();
    public double Average;
    public boolean Legal;
    
    public Student(){
        
    }
    public Student(Vector<String> row){
        StudentId=row.elementAt(0);
        StudentName=row.elementAt(1);
        Courses.add(new Course(row.elementAt(2),row.elementAt(3)));
        Legal=true;
    }
}

class Course{
    public String CourseName;
    public int Grade;
    
    public Course(){
        
    }
    
    public Course(String courseName,String grade){
       CourseName=courseName.toString();
       Grade=Integer.parseInt(grade.toString());
    }
}
