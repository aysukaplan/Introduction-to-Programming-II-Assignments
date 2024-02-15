import java.util.ArrayList;

public interface StudentDAO {
    Student getByID(int studentID);
    void add(String studentLine);
    void deleteByID(String deleteLine);
    void writeAllStudents();
}
