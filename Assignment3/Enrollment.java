public class Enrollment {
    int enrollmentID;
    int studentID;

    public Enrollment(int enrollmentID, int studentID) {
        this.enrollmentID = enrollmentID;
        this.studentID = studentID;
        OutputFileDAO output = new OutputFileDAO();
        output.writeEnrollment(this);
    }

    public int getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
}
