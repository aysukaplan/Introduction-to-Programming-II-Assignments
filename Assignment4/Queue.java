import java.util.ArrayList;


public class Queue extends DataStructure {

    private ArrayList<Integer> queue;
    public Queue() {
        queue = new ArrayList<>();
    }

    @Override
    public void add(int addItem){
        //In queues, adding in the back, first in first out.
        queue.add(addItem);
    }
    public void add(int location,int item){
        queue.add(location,item);
    }

    @Override
    void remove() {
        //remove from back
        queue.remove(queue.size()-1);
    }

    @Override
    public String toString() {
        String returnString = "";
        for (int item: queue){
            returnString = returnString + item + " ";
        }
        //returnString = returnString.substring(0, returnString.length()-1);
        return returnString;
    }
    @Override
    public int size(){
        return queue.size();
    }


    //returns the element at the given index
    @Override
    public int get(int location){
        return queue.get(location);
    }


    //removes the element at the given index
    public void remove(int i){
        queue.remove(i);
    }


    //returns true if queue is empty
    public boolean isEmpty() {
        boolean rtEmpty = false;
        if(queue.size()==0){
            rtEmpty = true;
        }
        return rtEmpty;
    }

}