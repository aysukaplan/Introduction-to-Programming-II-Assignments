import java.io.IOException;
import java.util.ArrayList;

public class Command {
    ReadQueue readQueue = new ReadQueue();
    ReadStack readStack = new ReadStack();

    DataStructureCommands dsCommands;

    public void run(ArrayList<String> commandLines) throws IOException {
        //reading from file and create stack and queue
        Stack stack = readStack.createStackFromFile();
        Queue queue = readQueue.createQueueFromFile();
        //run the commands one by one
        for(String line: commandLines){
            String[] sep = line.split(" ");
            if(sep[0].equals("Q")){
                dsCommands = new QueueCommands();
                runCommand(queue,line);
            }
            else{
                dsCommands = new StackCommands();
                runCommand(stack,line);
            }
        }
    }

    //ds is either stack or queue
    private void runCommand(DataStructure ds, String line) {
        //need to modify queue or stack
        String[] sep = line.split(" ");
        String command = sep[1];
        if(command.equals("removeGreater")){
            dsCommands.removeGreaterNumber(ds,Integer.parseInt(sep[2]));
        }
        if(command.equals("calculateDistance")){
            dsCommands.calculateDistance(ds);
        }
        if(command.equals("addOrRemove")){
            dsCommands.addOrRemove(ds,Integer.parseInt(sep[2]));
        }
        if(command.equals("reverse")){
            dsCommands.reverse(ds,Integer.parseInt(sep[2]));
        }
        if(command.equals("sortElements")){
            dsCommands.sortElements(ds);
        }
        if(command.equals("distinctElements")){
            dsCommands.distinctElements(ds);
        }
    }
}
