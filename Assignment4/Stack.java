import java.util.ArrayList;

public class Stack extends DataStructure {
    private ArrayList<Integer> stack;

    public Stack() {
        stack = new ArrayList<>();
    }
    //last in first out
    @Override
    public  void add(int addingItem){
        //add to front
        stack.add(0,addingItem);
    }

    @Override
    public void remove(){
        //remove at front
        if (!stack.isEmpty()){
            stack.remove(0);
        }
    }

    @Override
    public String toString() {

        String returnString = "";
        for (int item: stack){
            returnString = returnString + item + " ";
        }
        //returnString = returnString.substring(0, returnString.length()-1);
        return returnString;
    }
    @Override
    public int size(){
        return stack.size();
    }
    @Override
    public int get(int location){
        return stack.get(location);
    }

    @Override
    public void remove(int location) {
        stack.remove(location);
    }

    public boolean isEmpty() {
        boolean rtEmpty = false;
        if(stack.size()==0){
            rtEmpty = true;
        }
        return rtEmpty;
    }

    @Override
    public void add(int i, int popItem) {
        stack.add(i,popItem);
    }
}

