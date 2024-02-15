import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadQueue {
    String fileName = "queue.txt";
    public Queue createQueueFromFile() throws IOException {
        // reads from file and returns an array of lines in the file
        String thisLine;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            thisLine= br.readLine();
        }
        Queue returnQueue = createQueueFromLine(thisLine);
        return returnQueue;
    }

    private Queue createQueueFromLine(String line){
        String[] sep = line.split(" ");
        Queue queue = new Queue();
        for(String s :sep){
            if(!s.equals(" ")){
                int element = Integer.parseInt(s);
                queue.add(element);
            }
        }
        return queue;
    }
}
