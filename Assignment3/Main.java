import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        String inputFileName = args[0];
        String studentFileName = "student.txt";
        String courseEnrollment =" courseEnrollment.txt";
        StudentFileDAO studentFileDAO = new StudentFileDAO(studentFileName);
        EnrollmentFileDAO enrollmentFileDAO = new EnrollmentFileDAO();

        InputFileDAO inputFileDAO = new InputFileDAO();
        ArrayList<String> inputLines = inputFileDAO.readInputFile(inputFileName);
        for (String line:inputLines){
            if (line.startsWith("AddStudent")){
                studentFileDAO.add(line);
            }
            if(line.startsWith("RemoveStudent")){
                studentFileDAO.deleteByID(line);
            }
            if(line.startsWith("CreateEnrollment")){
                enrollmentFileDAO.add(line);
            }
            if(line.startsWith("AddAssessment")){
                enrollmentFileDAO.addAssessment(line);
            }
            if(line.startsWith("TotalFee")){
                enrollmentFileDAO.calculateTotalFee(line);
            }
            if(line.startsWith("ListStudents")){
                studentFileDAO.writeAllStudents();
            }
        }







    }
}