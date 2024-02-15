public class PartTime extends Employee{
    private int hourOfWork;
    private int severancePay;

    //constructor
    public PartTime(String name, String surname, String registerNumber, String memType, int year) {
        super(name, surname, registerNumber, memType, year);
        severancePay = calculateSeverancePay(year);
    }

    //polymorphic method to calculate salary
    @Override
    public int calculateSalary(int w1, int w2, int w3, int w4) {
        int workingHours = calculateTotalWorkingHours(w1,w2,w3,w4);
        return  workingHours*18 + severancePay ;
    }
    private int calculateTotalWorkingHours(int w1, int w2, int w3, int w4) {
        //up to 20 hours per week min is 10 hours
        int[] weeks = new int[]{w1,w2,w3,w4};
        int totalWorkHours = 0;
        for(int week:weeks){
            if(week>20){
                totalWorkHours +=20;
            }
            if (week>9 && week<21){
                totalWorkHours += week;
            }
        }
        return totalWorkHours;
    }
}

