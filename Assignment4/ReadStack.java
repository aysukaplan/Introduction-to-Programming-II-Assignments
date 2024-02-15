import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadStack {
    String fileName = "stack.txt";
    public Stack createStackFromFile() throws IOException {
        // reads from file and returns the first line in the file
        String thisLine;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            thisLine= br.readLine();
        }
        Stack returnStack = createStackFromLine(thisLine);
        return returnStack;
    }

    private Stack createStackFromLine(String line){
        String[] sep = line.split(" ");
        Stack stack = new Stack();
        for(int i=sep.length-1;i>=0;i--){
            String s = sep[i];
            if(!s.equals(" ")){
                int element = Integer.parseInt(s);
                stack.add(element);
            }
        }
        return stack;
    }

}
