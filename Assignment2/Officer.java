public class Officer extends Personnel{
    private int baseSalary;
    private int ssBenefits;

    private int severancePay;
    private int overWorkSalary;

    //constructor
    public Officer(String name, String surname, String registerNumber, String memType, int year) {
        super(name,surname,registerNumber,memType,year);
        baseSalary = 2600;
        severancePay = calculateSeverancePay(year);
        ssBenefits = baseSalary * 65 / 100;
    }

    // polymorphic method to calculate salary
    @Override
    public int calculateSalary(int w1, int w2, int w3, int w4) {
        int fullSalary = baseSalary + ssBenefits + severancePay;
        int overWorkHours = calculateOverWorkHours(w1,w2,w3,w4);
        int overWorkPay = overWorkHours * 20;
        overWorkSalary = overWorkPay;
        return  overWorkPay + fullSalary;
    }
    private int calculateOverWorkHours(int w1, int w2, int w3, int w4) {
        //up to 10 hours per week base is 40 hours
        int[] weeks = new int[]{w1,w2,w3,w4};
        int overWorkHours = 0;
        for(int week:weeks){
            int num = week - 40;
            if(num>10){
                overWorkHours +=10;
            }
            else{
                overWorkHours += num;
            }
        }
        return overWorkHours;
    }
}
