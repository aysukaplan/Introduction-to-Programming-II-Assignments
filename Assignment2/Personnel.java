import java.time.Year;
import java.util.ArrayList;

public class Personnel {
    private String name;
    private String surname;
    private String registerNumber;
    private String position;//memtype
    private int yearOfStart;
    private int salary;

    //constructor
    public Personnel(String name, String surname, String registerNumber, String position, int yearOfStart) {
        this.name = name;
        this.surname = surname;
        this.registerNumber = registerNumber;
        this.position = position;
        this.yearOfStart = yearOfStart;
    }

    //method to calculate severance pay
    public int calculateSeverancePay(int year){
        int yearNow = Year.now().getValue();
        return (yearNow-year) * 16;
    }

    //creates personnel list from list of lines from personnel.txt
    public static ArrayList<Personnel> createPersonnelList(ArrayList<String> personnelLines) {
        ArrayList<Personnel> personnels = new ArrayList<>();
        for (String line : personnelLines) {
            String[] sepTab = line.split("\t");
            String[] sepNameSurname = sepTab[0].split(" ");
            String name = sepNameSurname[0];
            String surname = sepNameSurname[1];
            String registerNumber = sepTab[1];
            String memType = sepTab[2];
            int year = Integer.parseInt(sepTab[3]);
            Personnel p = null;
            if(memType.equals("ACADEMICIAN")){
                p = new Academician(name,surname,registerNumber,memType,year);
            }
            if(memType.equals("FACULTY_MEMBER")){
                p = new FacultyMembers(name,surname,registerNumber,memType,year);
            }
            if(memType.equals("RESEARCH_ASSISTANT")){
                p = new ResearchAssistants(name,surname,registerNumber,memType,year);
            }
            if(memType.equals("OFFICER")){
                p = new Officer(name,surname,registerNumber,memType,year);
            }
            if(memType.equals("EMPLOYEE")){
                p = new Employee(name,surname,registerNumber,memType,year);
            }
            if(memType.equals("PARTTIME_EMPLOYEE")){
                p = new PartTime(name,surname,registerNumber,memType,year);
            }
            if(memType.equals("FULLTIME_EMPLOYEE")){
                p = new FullTime(name,surname,registerNumber,memType,year);
            }
            if(memType.equals("WORKER")){
                p = new Worker(name,surname,registerNumber,memType,year);
            }
            if(memType.equals("CHIEF")){
                p = new Chief(name,surname,registerNumber,memType,year);
            }
            if(memType.equals("SECURITY")){
                p = new Security(name,surname,registerNumber,memType,year);
            }
            personnels.add(p);
        }
        return personnels;
    }

    //polymorphic method to calculate salary
    public int calculateSalary(int w1,int w2,int w3, int w4){
        return salary;
    }

    //get and set methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public int getYearOfStart() {
        return yearOfStart;
    }

    public void setYearOfStart(int yearOfStart) {
        this.yearOfStart = yearOfStart;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}