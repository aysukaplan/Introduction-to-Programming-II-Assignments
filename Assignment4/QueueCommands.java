import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QueueCommands extends DataStructureCommands {
    WriteQueue writeQueue = new WriteQueue();

    //function the run removegreaternumber command
    @Override
    public void removeGreaterNumber(DataStructure ds, int num) {
        //temporary stack to store numbers smaller than num
        Stack temp = new Stack();

        // Iterate through the original queue
        while (!ds.isEmpty()) {
            int current = ds.get(ds.size()-1);
            ds.remove();
            // Check if the current element is less than or equal to n
            if (current <= num) {
                // If it is, add it to the temporary stack
                temp.add(current);
            }
        }

        // Add elements back to the original queue
        for (int i=0;temp.size()>i;i++) {
            int n = temp.get(i);
            ds.add(n);
        }

        writeQueue.writeRemoveGreaterNumber(ds.toString(),num);
        writeQueue.updateQueue(ds.toString());
    }

    @Override
    public void sortElements(DataStructure ds) {
        ArrayList<Integer> listToSort = new ArrayList<>();
        //add elements from queue to arraylist and remove from queue
        while (!ds.isEmpty()){
            int popItem = ds.get(ds.size()-1);
            listToSort.add(popItem);
            ds.remove();
        }
        //sort the arraylist
        Collections.sort(listToSort);
        //remove elements from arraylist and add back to queue
        while (!listToSort.isEmpty()) {
            int popItem = listToSort.get(0);
            ds.add(popItem);
            listToSort.remove(0);
        }
        writeQueue.writeSortElements(ds.toString());
        writeQueue.updateQueue(ds.toString());
    }

    @Override
    public void addOrRemove(DataStructure ds, int num) {
        //if num is negative remove elements
        if(num<0){
            //multiply number with -1 to iterate
            int num1 = -1 * num;
            for(int i =0;num1>i;i++){
                ds.remove(0);
            }
        }
        else{
            //if num is positive add new random elements
            int min = 0;
            int max=50;
            Random random = new Random();

            for(int i =0;num>i;i++){
                //create a random number
                int randomNum = random.nextInt(max - min + 1) + min;
                //add the number to the queue
                ds.add(randomNum);
            }
        }
        writeQueue.writeAddOrRemove(ds.toString(),num);
        writeQueue.updateQueue(ds.toString());
    }

    @Override
    public void calculateDistance(DataStructure ds) {
        int distance =0;
        int size = ds.size();
        for(int i=0;size-1>i;i++){
            int element = ds.get(i);
            for(int j=i;size>j;j++){
                int num = ds.get(j) - element;
                if(num<0){
                    num *=-1;
                }
                distance += num;
            }
        }
        writeQueue.writeCalculateDistance(distance);
        writeQueue.updateQueue(ds.toString());
    }

    @Override
    public void reverse(DataStructure ds, int k) {
        // Create a temporary list
        Stack auxStack = new Stack();

        // Pop the first N elements from the queue and push them onto the temporary list
        for (int i = 0; i < k; i++) {
            int popItem = ds.get(0);
            auxStack.add(popItem);
            ds.remove(0);
        }

        // Pop the elements from the temporary list and push them back onto the queue
        while (!auxStack.isEmpty()) {
            int popItem = auxStack.get(auxStack.size()-1);
            ds.add(0,popItem);
            auxStack.remove(auxStack.size()-1);
        }
        writeQueue.writeReverse(ds.toString(),k);
        writeQueue.updateQueue(ds.toString());
    }

    @Override
    void distinctElements(DataStructure ds) {
        //add distinct elements to the list
        ArrayList<Integer> distincts = new ArrayList<>();
        int size = ds.size();
        for (int i = 0; size > i; i++) {
            if (!distincts.contains(ds.get(i))) {
                distincts.add(ds.get(i));
            }
        }
        int num = distincts.size();
        writeQueue.writeDistinctElements(num);
        writeQueue.updateQueue(ds.toString());
    }
}
