import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Locale;

public class FileWrite {

    public static void writeFile(String fileName, Personnel p) throws IOException { //write to the file
        //writes to the file personnel's information
        //personnel : name surname regnumber position yearofstart total salary
        try (FileWriter writer = new FileWriter(fileName, false);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.append("Name : ");
            bw.append(p.getName());
            bw.newLine();
            bw.newLine();
            bw.append("Surname : ");
            bw.append(p.getSurname());
            bw.newLine();
            bw.newLine();
            bw.append("Registration Number : ");
            bw.append(p.getRegisterNumber());
            bw.newLine();
            bw.newLine();
            bw.append("Position : ");
            bw.append(p.getPosition());
            bw.newLine();
            bw.newLine();
            bw.append("Year of Start : ");
            bw.append(Integer.toString(p.getYearOfStart()));
            bw.newLine();
            bw.newLine();
            bw.append("Total Salary : ");
            bw.append(Integer.toString(p.getSalary()));
            bw.append(".00 TL");
        }
    }
}