import java.util.ArrayList;

public class FacultyMembers extends Academician{
    private int addCourseFee;

    //constructor
    public FacultyMembers(String name, String surname, String registerNumber, String memType, int year) {
        super(name, surname, registerNumber, memType, year,135);

    }
    //polymorphic method to calculate salary
    @Override
    public int calculateSalary(int w1, int w2, int w3, int w4) {
        int fullSalary = super.calculateSalary(w1, w2, w3, w4);
        int overWorkHours = calculateOverWorkHours(w1,w2,w3,w4);
        int overWorkPay = overWorkHours * 20;
        addCourseFee = overWorkPay;
        return  overWorkPay + fullSalary;
    }

    private int calculateOverWorkHours(int w1, int w2, int w3, int w4) {
        //up to 8 hours per week base is 40 hours
        int[] weeks = new int[]{w1,w2,w3,w4};
        int overWorkHours = 0;
        for(int week:weeks){
            int num = week - 40;
            if(num>8){
                overWorkHours +=8;
            }
            else{
                overWorkHours += num;
            }
        }
        return overWorkHours;
    }
    //get and set methods
    public int getAddCourseFee() {
        return addCourseFee;
    }

    public void setAddCourseFee(int addCourseFee) {
        this.addCourseFee = addCourseFee;
    }
}
