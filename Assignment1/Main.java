import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        //reading from the file
        String[] purchaseFileLines = ReadFromFile.readFile(args[0]);
        String[] priceFileLines = ReadFromFile.readFile(args[1]);

        //creating a products list from data
        ArrayList<Product> products= new ArrayList<>();
        products = Customer.createProductList(priceFileLines);
        // creating a customer list from data
        ArrayList<Customer> customerPurchases = new ArrayList<>();
        customerPurchases = Customer.createCustomerList(purchaseFileLines,products);
        //output to the file
        String outputFileName = "output.txt";
        OutputToFile.writeFile(outputFileName,customerPurchases);





    }
}