import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        //reading from the file
        ArrayList<String> PersonnelLines = FileRead.readFile(args[0]);
        ArrayList<String> MonitoringLines = FileRead.readFile(args[1]);

        //creating a personnels list from data
        // personnels have no salary info
        ArrayList<Personnel> personnels= new ArrayList<>();
        personnels = Personnel.createPersonnelList(PersonnelLines);

        //reading from monitoring file
        ArrayList<String> monitoring= new ArrayList<>();
        monitoring = createMonitoringList(MonitoringLines);

        //adds salary information to each personnel
        updateSalary(personnels, monitoring);

        //output to the files
        for(Personnel p: personnels){
            FileWrite.writeFile(p.getRegisterNumber(),p);
        }
    }

    //update the salary of the personnels
    public static void updateSalary(ArrayList<Personnel> personnels, ArrayList<String> monitoringLines) {
        for (Personnel p: personnels){
            String regNum = p.getRegisterNumber();
            int w1 = 0;
            int w2 = 0;
            int w3 = 0;
            int w4 = 0;
            for(int i =0 ; i <monitoringLines.size();i+=5){
                if(monitoringLines.get(i).equals(regNum)){
                    w1 = Integer.parseInt(monitoringLines.get(i+1));
                    w2 = Integer.parseInt(monitoringLines.get(i+2));
                    w3 = Integer.parseInt(monitoringLines.get(i+3));
                    w4 = Integer.parseInt(monitoringLines.get(i+4));
                }
            }
            int salary = p.calculateSalary(w1,w2,w3,w4);
            p.setSalary(salary);
        }
    }

    //create monitoring list from lines
    public static ArrayList<String> createMonitoringList(ArrayList<String> monitoringLines) {
        ArrayList<String> monitoring = new ArrayList<>();
        for (String line : monitoringLines) {
            String[] sepTab = line.split("\t");
            monitoring.add(sepTab[0]);
            monitoring.add(sepTab[1]);
            monitoring.add(sepTab[2]);
            monitoring.add(sepTab[3]);
            monitoring.add(sepTab[4]);
        }
        return monitoring;
    }
}