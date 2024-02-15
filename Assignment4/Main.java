import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        FileRead read = new FileRead();
        Command command = new Command();
        // reads command file and create commands arraylist
        ArrayList<String> commandLines = read.readFile(args[0]);
        //run commands
        command.run(commandLines);
    }
}
