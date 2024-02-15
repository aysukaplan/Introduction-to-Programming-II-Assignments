import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class StudentFileDAO implements StudentDAO{
    private final String filePath;

    public StudentFileDAO(String filePath) {
        this.filePath = filePath;
    }


    @Override
    public Student getByID(int studentID) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Student student = createStudentFromLineString(line);
                if(student.getId() == studentID){
                    return student;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Return null if student with the specified ID is not found
    }

    @Override
    public void add(String studentLine) {
        String[] sepTab = studentLine.split(" ");
        //id name,surname address
        int id = Integer.parseInt(sepTab[1]);

        String name = sepTab[2];
        String surname = sepTab[3];
        String phone = sepTab[4];
        ArrayList<String> sep = new ArrayList<>(Arrays.asList(sepTab));
        String address = "";
        for(int i= 5; i<sep.size();i++){
            address+=sep.get(i);
            if(i!=sep.size()-1){
                address+=" ";
            }
        }
        Student student = new Student(id, name, surname, phone, address);
        OutputFileDAO outputFileDAO = new OutputFileDAO();
        outputFileDAO.writeStudent(student,"added");
        ArrayList<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Create and add a Student object to the list based on file data
                students.add(createStudentFromLineString(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        students.add(student);
        Collections.sort(students, Comparator.comparing(Student::getId));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Student student1 : students) {
                String data = studentToString(student1);
                writer.write(data);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteByID(String studentLine) {
        String[] sepTab = studentLine.split(" ");
        int studentID = Integer.parseInt(sepTab[1]);
        ArrayList<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Create and add a Student object to the list based on file data
                Student student = createStudentFromLineString(line);
                if(student.getId() != studentID){
                    students.add(student);
                }
                else{
                    OutputFileDAO outputFileDAO = new OutputFileDAO();
                    outputFileDAO.writeStudent(student,"removed");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Student student : students) {
                String data = studentToString(student);
                writer.write(data);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //writes to the output file ordered by name
    @Override
    public void writeAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Create and add a Student object to the list based on file data
                students.add(createStudentFromLineString(line));
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        Collections.sort(students, Comparator.comparing(Student::getName));
        OutputFileDAO outputFileDAO = new OutputFileDAO();
        outputFileDAO.writeStudentsToFile(students);

    }

    // create a Student object from file line
    private Student createStudentFromLineString(String line) {
        String[] sepTab = line.split("\t");
        //id name,surname address
        int id = Integer.parseInt(sepTab[0]);

        String name = sepTab[1];
        String surname = sepTab[2];
        String phone = sepTab[3];
        String[] sepAddress = sepTab[4].split(":");
        String address = sepAddress[1];

        // Create and return a Student object
        return new Student(id, name, surname, phone, address);
    }

    // convert a Student object to string
    private String studentToString(Student student) {
        return (student.getId()) + "\t" + student.getName() + "\t" +
                student.getSurname() + "\t" + student.getPhoneNumber() + "\tAddress:" +
                student.getAddress();
    }

}
