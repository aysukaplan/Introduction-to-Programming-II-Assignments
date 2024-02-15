import java.util.ArrayList;

public interface OutputDAO {
    void  writeStudentsToFile(ArrayList<Student> students);

    //operation: added or removed
    void writeStudent(Student student, String operation);
    void writeEnrollment(Enrollment enrollment);
    void writeAssessment(String assessment);

}
