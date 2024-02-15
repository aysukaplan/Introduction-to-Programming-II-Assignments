public class Chief extends FullTime{
    //constructor
    public Chief(String name, String surname, String registerNumber, String memType, int year) {
        super(name, surname, registerNumber, memType, year);

    }

    //polymorphic method to calculate salary
    @Override
    public int calculateSalary(int w1, int w2, int w3, int w4) {
        int baseSalary = 125 * getDayOfWork() * 4;
        int overWorkPay = calculateOverWorkHours(w1,w2,w3,w4) * 15;
        return baseSalary + overWorkPay + getSeverancePay();
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
}
