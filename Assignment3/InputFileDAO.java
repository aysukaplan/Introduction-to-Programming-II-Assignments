import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class InputFileDAO {
    public ArrayList<String> readInputFile(String filePath) {
        ArrayList<String> lines = new ArrayList<>();
        String thisLine;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((thisLine = br.readLine()) != null) {
                lines.add(thisLine);
            }

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }
}
