import java.util.ArrayList;

public interface EnrollmentDAO {

    void create(Enrollment enrollment);

    Enrollment getByID(int enrollmentID);

    void add(String enrollmentLine);

    void deleteByID(int enrollmentID);

    ArrayList<Enrollment> getAll();

    void calculateTotalFee(String line);
    public void addAssessment(String line);
}
