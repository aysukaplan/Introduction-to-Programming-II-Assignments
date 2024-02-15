public abstract class WriteFile {

    //removes numbers greater than num in stack or queue
    abstract void writeRemoveGreaterNumber(String lis, int num);

    //finds the sum of the distances of all elements to other all elements in the
    //current queue or stack file
    abstract void writeCalculateDistance(int distance);

    //, a negative or positive value is read from the input file. If the number is
    //negative, remove elements as the number of times. If the number is positive, add new random
    //elements as the number of times (between 0-50).
    abstract void writeAddOrRemove(String lis, int num);

    //according to integer k that is given in command.txt, reverses the first k
    //elements of stack or queue.
    abstract void writeReverse(String lis, int num);

    //sorts the queue or stack
    abstract void writeSortElements(String lis);

    //writes the total number of distinct elements
    abstract void writeDistinctElements(int num);
}
