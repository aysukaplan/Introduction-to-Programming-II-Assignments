public class Security extends Personnel{
    private int hourOfWork;
    private int severancePay;
    private int transMoney; //daily 5 tl * 6
    private int foodMoney; //daily 10 tl * 6

    //constructor
    public Security(String name, String surname, String registerNumber, String memType, int year) {
        super(name,surname,registerNumber,memType,year);
        transMoney = 30;
        foodMoney = 60;
        severancePay = calculateSeverancePay(year);
    }

    //polymorphic method to calculate salary
    @Override
    public int calculateSalary(int w1, int w2, int w3, int w4) {
        int workingHours = calculateTotalWorkingHours(w1,w2,w3,w4);
        return  workingHours*10 + severancePay + foodMoney*4 + transMoney*4;
    }
    private int calculateTotalWorkingHours(int w1, int w2, int w3, int w4) {
        //up to 54 hours per week min is 30 hours
        int[] weeks = new int[]{w1,w2,w3,w4};
        int totalWorkHours = 0;
        for(int week:weeks){
            if(week>54){
                totalWorkHours +=54;
            }
            if(week>29 && week<55){
                totalWorkHours += week;
            }

        }
        return totalWorkHours;
    }
}
