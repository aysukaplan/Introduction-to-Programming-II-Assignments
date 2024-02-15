public class Employee extends Personnel{
    //constructor
    public Employee(String name, String surname, String registerNumber, String memType, int year) {
        super(name,surname,registerNumber,memType,year);
    }

    //polymorphic method to calculate salary
    @Override
    public int calculateSalary(int w1, int w2, int w3, int w4) {
        return super.calculateSalary(w1, w2, w3, w4);
    }
}
