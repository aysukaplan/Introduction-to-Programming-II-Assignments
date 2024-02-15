import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class StackCommands extends DataStructureCommands {


    WriteStack writeStack = new WriteStack();

    @Override
    public void removeGreaterNumber(DataStructure ds, int num) {
        Stack tempStack = new Stack();

        // Iterate through the stack
        while (!ds.isEmpty()) {
            int current = ds.get(0);
            ds.remove();

            // Check if the current element is less than or equal to n
            if (current <= num) {
                // If it is, push it onto the temporary stack
                tempStack.add(current);
            }
        }

        // Push elements back to the original stack
        while (!tempStack.isEmpty()) {
            int current = tempStack.get(0);
            ds.add(current);
            tempStack.remove();
        }

        writeStack.writeRemoveGreaterNumber(ds.toString(),num);
        writeStack.updateStack(ds.toString());
    }

    @Override
    void distinctElements(DataStructure ds) {
        ArrayList<Integer> distincts = new ArrayList<>();
        int size = ds.size();
        for (int i = 0; size > i; i++) {
            if (!distincts.contains(ds.get(i))) {
                distincts.add(ds.get(i));
            }
        }
        int num = distincts.size();
        writeStack.writeDistinctElements(num);
        writeStack.updateStack(ds.toString());
    }

    @Override
    public void sortElements(DataStructure ds) {
        ArrayList<Integer> listToSort = new ArrayList<>();
        while (!ds.isEmpty()){
            int popItem = ds.get(0);
            listToSort.add(popItem);
            ds.remove();
        }

        Collections.sort(listToSort);
        while (!listToSort.isEmpty()) {
            int popItem = listToSort.get(listToSort.size()-1);
            ds.add(popItem);
            listToSort.remove(listToSort.size()-1);
        }
        writeStack.writeSortElements(ds.toString());
        writeStack.updateStack(ds.toString());
    }

    @Override
    public void addOrRemove(DataStructure ds, int num) {
        if(num<0){//if num is negative remove elements
            int num1 = -1 * num;
            for(int i =0;num1>i;i++){
                ds.remove();
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
                ds.add(randomNum);
            }
        }
        writeStack.writeAddOrRemove(ds.toString(),num);
        writeStack.updateStack(ds.toString());
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
        writeStack.writeCalculateDistance(distance);
        writeStack.updateStack(ds.toString());
    }

    @Override
    public void reverse(DataStructure ds, int k) {
        // Create a temporary list
        ArrayList<Integer> auxStack = new ArrayList<>();

        // Pop the first N elements from the original stack and push them onto the temp list
        for (int i = 0; i < k; i++) {
            int popItem = ds.get(0);
            auxStack.add(popItem);
            ds.remove();
        }

        // Pop the elements from the temp list and push them back onto the original stack
        while (!auxStack.isEmpty()) {
            int popItem = auxStack.get(0);
            ds.add(popItem);
            auxStack.remove(0);
        }
        writeStack.writeReverse(ds.toString(),k);
        writeStack.updateStack(ds.toString());
    }
}
