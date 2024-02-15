import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class EnrollmentFileDAO implements EnrollmentDAO {
    private final String filePath = "courseEnrollment.txt";

    @Override
    public void create(Enrollment enrollment) {

    }

    @Override
    public Enrollment getByID(int enrollmentID) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                int currentEnrollmentID = Integer.parseInt(parts[0].trim());
                if (currentEnrollmentID == enrollmentID) {
                    // Create and return an Enrollment object based on file data
                    return createEnrollmentFromData(parts);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle exception properly in a real application
        }
        return null; // Return null if enrollment with the specified ID is not found
    }

    @Override
    public void add(String enrollmentLine) {

        ArrayList<String> enrollments = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Create and add a Student object to the list based on file data
                if(!line.isEmpty()){
                    enrollments.add(line);
                }


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] sepTab = enrollmentLine.split(" ");
        int enrollmentID =Integer.parseInt(sepTab[1]);
        int studentID = Integer.parseInt(sepTab[2]);
        String insertLine = enrollmentID + "\t" + studentID;
        int insertIndex = -1;
        Boolean found = false;
        for(String enrollmentLine1:enrollments){
            //if it is enrollment
            if(Character.isDigit(enrollmentLine1.charAt(0))){
                String[] sepTab1 = enrollmentLine1.split("\t");
                int enrollmentID1 =Integer.parseInt(sepTab1[0]);
                int index = enrollments.indexOf(enrollmentLine1);
                if(enrollmentID1<enrollmentID){
                    insertIndex = index;
                }
                else{
                    found = true;
                }
            }
            else{
                if(!found){
                    insertIndex+=1;
                }
            }
        }
        enrollments.add(insertIndex+1,insertLine);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line1: enrollments) {
                writer.write(line1);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //write to output file
        Enrollment enrollment = new Enrollment(enrollmentID,studentID);

    }

    @Override
    public void deleteByID(int enrollmentID) {

    }

    @Override
    public ArrayList<Enrollment> getAll() {
        ArrayList<Enrollment> enrollments = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                // Create and add an Enrollment object to the list based on file data
                enrollments.add(createEnrollmentFromData(parts));
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle exception properly in a real application
        }
        return enrollments;
    }

    // Helper method to create an Enrollment object from file data
    private Enrollment createEnrollmentFromData(String[] parts) {
        int enrollmentID = Integer.parseInt(parts[0].trim());
        int studentID = Integer.parseInt(parts[1].trim());
        // Create and return an Enrollment object based on file data
        return new Enrollment(enrollmentID, studentID);
    }
    public void addAssessment(String line) {
        // line = AddAssessment 7 Essaybased QuestionSet LiteratureReview
        String[] sepTab = line.split(" ");
        String assessmentType = sepTab[2];
        ArrayList<String> sep = new ArrayList<>(Arrays.asList(sepTab));
        ArrayList<String> tasks = new ArrayList<>();
        for(int i =3; i<sep.size();i++){
            tasks.add(sep.get(i));
        }
        createAssessment(assessmentType,tasks);
        //write to assessment file
        writeToAssesmentFile(line);
        //write to output file
        OutputFileDAO outputFileDAO = new OutputFileDAO();
        outputFileDAO.writeAssessment(line);
    }
    private void writeToAssesmentFile(String line){
        String[] sepTab = line.split(" ");
        ArrayList<String> sep = new ArrayList<>(Arrays.asList(sepTab));
        int assessmentID = Integer.parseInt(sep.get(1));
        String lineToWrite = "";
        for(int i=2;i<sep.size();i++){
            lineToWrite = lineToWrite + sep.get(i);
            if(i!=sep.size()-1){
                lineToWrite+=" ";
            }
        }
        //find the given assessment and add the line
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line1;
            while ((line1 = reader.readLine()) != null) {
                // Create and add a Student object to the list based on file data
                lines.add(line1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int insertIndex = -1;
        for(String enrollmentLine1:lines){
            //if it is enrollment number
            if(Character.isDigit(enrollmentLine1.charAt(0))){
                String[] sepTab1 = enrollmentLine1.split("\t");
                int enrollmentID1 =Integer.parseInt(sepTab1[0]);
                int i=1;
                if(enrollmentID1==assessmentID){
                    insertIndex = lines.indexOf(enrollmentLine1);
                    while(!Character.isDigit(lines.get(enrollmentLine1.indexOf(enrollmentLine1)+i).charAt(0))){
                        insertIndex +=1;
                        i+=1;
                        }
                    }
                }
            }
        insertIndex+=1;

        if(insertIndex == lines.size() || insertIndex>lines.size()){
            lines.add(lineToWrite);
        }
        else{
            lines.add(insertIndex,lineToWrite);
        }


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line2: lines) {
                writer.write(line2);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private void createAssessment(String assessmentType,ArrayList<String> tasks){
        //creates assesments using decorator
        if(assessmentType.equals("Essaybased")){
            Assessment essayAssessment = new EssayAssessment();
            // Essay Assessment with additional tasks
            Assessment essayAssessmentWithTasks = new EssayAssessmentDecorator(essayAssessment);
            addTaskToAssessment(essayAssessmentWithTasks,tasks);
        }
        if(assessmentType.equals("MultipleChoice")){
            Assessment mcAssessment = new MultipleChoiceAssessment();
            // Essay Assessment with additional tasks
            Assessment mcAssessmentWithTasks = new MultipleChoiceAssessmentDecorator(mcAssessment);
            addTaskToAssessment(mcAssessmentWithTasks,tasks);
        }
    }
    private void addTaskToAssessment(Assessment assessment,ArrayList<String> tasks){
        for(String task:tasks){
            if(task.equals("Analysis")){
                assessment.addTask(new Analysis());
            }
            if(task.equals("QuestionSet")){
                assessment.addTask(new QuestionSet());
            }
            if(task.equals("LiteratureReview")){
                assessment.addTask(new LiteratureReview());
            }
            if(task.equals("AdditionalTasks")){
                assessment.addTask(new AdditionalTasks());
            }
        }
    }
    public void calculateTotalFee(String line) {
        String[] sepTab = line.split(" ");
        int enrollmentID = Integer.parseInt(sepTab[1]);
        int totalFee = 0;
        ArrayList<Integer> feeList = new ArrayList<>();
        ArrayList<String> linesAssessments = new ArrayList<>();
        //read the assessment file and found given assessment of id
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line1;
            while ((line1 = reader.readLine()) != null) {
                // Create and add a Student object to the list based on file data
                linesAssessments.add(line1);
                }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String> assessments = new ArrayList<>();
        for(String line2:linesAssessments){
            if(Character.isDigit(line2.charAt(0))){
                String[] sepTab1 = line2.split("\t");
                int enrollmentID1 =Integer.parseInt(sepTab1[0]);
                if(enrollmentID1==enrollmentID){
                    int i =1;
                    while(!Character.isDigit(linesAssessments.get(linesAssessments.indexOf(line2)+i).charAt(0))){
                        assessments.add(linesAssessments.get(linesAssessments.indexOf(line2)+i));
                        if(linesAssessments.size()==linesAssessments.indexOf(line2)+i+1){
                            break;
                        }
                        else{
                            i+=1;
                        }
                    }
                }
            }
        }
        //assessments is: ["Essaybased	Analysis", "MultipleChoice	LiteratureReview"] etc
        for(String as:assessments){
            int fee = calculateFeeOfAssessment(as);
            feeList.add(fee);
            totalFee += fee;
        }
        //write to output file
        OutputFileDAO outputFileDAO = new OutputFileDAO();
        outputFileDAO.writeTotalFee(enrollmentID,assessments,feeList,totalFee);

    }

    public int calculateFeeOfAssessment(String line){
        //line is MultipleChoice	LiteratureReview
        String[] sepTab = line.split(" ");
        String assessmentType = sepTab[0];
        ArrayList<String> sep = new ArrayList<>(Arrays.asList(sepTab));
        ArrayList<String> tasks = new ArrayList<>();
        for(int i =1; i<sep.size();i++){
            tasks.add(sep.get(i));
        }
        int fee = 0;
        if(assessmentType.equals("Essaybased")){
            Assessment essayAssessment = new EssayAssessment();
            // Essay Assessment with additional tasks
            Assessment essayAssessmentWithTasks = new EssayAssessmentDecorator(essayAssessment);
            addTaskToAssessment(essayAssessmentWithTasks,tasks);
            fee = essayAssessmentWithTasks.calculateFee();
        }
        if(assessmentType.equals("MultipleChoice")){
            Assessment mcAssessment = new MultipleChoiceAssessment();
            // Essay Assessment with additional tasks
            Assessment mcAssessmentWithTasks = new MultipleChoiceAssessmentDecorator(mcAssessment);
            addTaskToAssessment(mcAssessmentWithTasks,tasks);
            fee = mcAssessmentWithTasks.calculateFee();
        }
        return fee;
    }
    // Helper method to convert an Enrollment object to file data
    private String enrollmentToData(Enrollment enrollment) {
        return enrollment.getEnrollmentID() + "\t" + enrollment.getStudentID();
    }



}
