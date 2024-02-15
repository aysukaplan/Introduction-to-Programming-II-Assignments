public class FullTime extends Employee{
    private int dayOfWork;
    private int severancePay;

    private int overWorkSalary;
    //constructor
    public FullTime(String name, String surname, String registerNumber, String memType, int year) {
        super(name, surname, registerNumber, memType, year);
        severancePay = calculateSeverancePay(year);
        dayOfWork = 5;
    }
    // polymorphic method to calculate salary
    @Override
    public int calculateSalary(int w1, int w2, int w3, int w4) {
        return super.calculateSalary(w1, w2, w3, w4);
    }

    // get and set methods
    public int getDayOfWork() {
        return dayOfWork;
    }

    public void setDayOfWork(int dayOfWork) {
        this.dayOfWork = dayOfWork;
    }

    public int getSeverancePay() {
        return severancePay;
    }

    public void setSeverancePay(int severancePay) {
        this.severancePay = severancePay;
    }

    public int getOverWorkSalary() {
        return overWorkSalary;
    }

    public void setOverWorkSalary(int overWorkSalary) {
        this.overWorkSalary = overWorkSalary;
    }
}
