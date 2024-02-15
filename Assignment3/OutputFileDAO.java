import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class OutputFileDAO implements OutputDAO{
    private final String filePath = "output.txt";

    //student added or removed
    public void writeStudent(Student s, String m) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write("Student "+s.getId()+" "+s.getName()+" "+m);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //lists all students
    public void writeStudentsToFile(ArrayList<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
            writer.write("Student List:\n");
            for (Student student : students) {
                String data = studentToString(student);
                writer.write(data);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeEnrollment(Enrollment enrollment) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
            writer.write("CourseEnrollment " + enrollment.getEnrollmentID() + " created");
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeAssessment(String assessment) {
        //assessment is AddAssessment 7 Essaybased QuestionSet LiteratureReview
        //line to write is Essaybased assessment added to enrollment 7
        String[] sepTab = assessment.split(" ");
        int asID = Integer.parseInt(sepTab[1]);
        String asType = sepTab[2];
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
            writer.write( asType+ " assessment added to enrollment " + asID +"\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String studentToString(Student student) {
        return String.valueOf(student.getId()) + " " + student.getName() + " " +
                student.getSurname() + " " + student.getPhoneNumber() + " Address: " +
                student.getAddress();
    }


    public void writeTotalFee(int enrollmentID, ArrayList<String> assessments, ArrayList<Integer> feeList, int totalFee) {
        //assessments is: ["Essaybased	Analysis", "MultipleChoice	LiteratureReview"] etc
        //feelist fee of tasks ordered
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
            writer.write("TotalFee for enrollment " + enrollmentID + "\n");
            for(String as:assessments){
                writer.write("\t"+as+" "+feeList.get(assessments.indexOf(as))+"$\n");
            }
            writer.write("\t"+"Total: "+totalFee+"$\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

