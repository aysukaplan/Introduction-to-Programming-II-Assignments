import java.time.Year;

public class Academician extends Personnel{
    private int baseSalary; //2600
    private int ssBenefits;
    private int severancePay ;

    //constructors
    public Academician(String name, String surname, String registerNumber, String memType, int year, int ssBenefitsPerc) {
        super(name,surname,registerNumber,memType,year);
        baseSalary = 2600;
        severancePay = calculateSeverancePay(year);
        ssBenefits = baseSalary * ssBenefitsPerc / 100; //SSBenefitssalary
    }

    public Academician(String name, String surname, String registerNumber, String position, int yearOfStart) {
        super(name, surname, registerNumber, position, yearOfStart);
    }
    //polymorphic method to calculate salary
    @Override
    public int calculateSalary(int w1, int w2, int w3, int w4) {
        return baseSalary + ssBenefits + severancePay;
    }
}
