
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileRead {

        public static ArrayList<String> readFile(String path) throws IOException {
                // reads from file and returns an array of lines in the file
                ArrayList<String> lines = new ArrayList<>();
                String thisLine;
                try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                        while ((thisLine = br.readLine()) != null) {
                                lines.add(thisLine);
                        }
                }
                return lines;
        }
}

