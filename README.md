# interviewQ
You are required to write an application that would read students courses and grades data from a text file. Each record is in a separate line in the format
StudentId,Student Name,Course Name,Grade


The application should print for each student:
* Average grade.
* Names of all the courses the student had, sorted by ABC order.
If a student had more than one grade for the same course, print the student name followed by an error message.




Your entry point for implementation is the method:
void printStudents(List<String>  lines) {
}


You can assume input format validity in terms of delimiter, number of records, order of records, content of records etc’.


Sample input:


1,Erez,Math,85
2,Netanel,Math,90
3,Ronen,English,80
2,Netanel,English,75
1,Erez,Math,65

Sample output:
1,Erez,ERROR
2.Netanel,82.5,Math,English
3,Ronen,80,English


