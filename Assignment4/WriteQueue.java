import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteQueue extends WriteFile{

    String fileName= "queueOut.txt";

    @Override
    void writeRemoveGreaterNumber(String lis, int num) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("After removeGreater "+num+":");
            writer.newLine();
            writer.write(lis);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void writeCalculateDistance(int distance) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("After calculateDistance:\n");
            writer.write("Total distance="+distance);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void writeAddOrRemove(String lis, int num) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("After addOrRemove "+num +":");
            writer.newLine();
            writer.write(lis);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void writeReverse(String lis, int num) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("After reverse "+num+":");
            writer.newLine();
            writer.write(lis);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void writeSortElements(String lis) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("After sortElements:");
            writer.newLine();
            writer.write(lis);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void writeDistinctElements(int num) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("After distinctElements:\n");
            writer.write("Total distinct element="+num);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateQueue(String string) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("queue.txt", false))) {
            writer.write(string);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


