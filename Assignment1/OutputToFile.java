import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Locale;

public class OutputToFile {

    public static void writeFile(String fileName, ArrayList<Customer> customers) throws IOException{ //write to the file
        //customer : name surname memType purchase
        //purchase : shoppingdate purchaseProductslist totalcost
        //product : name quantity pricelist subcost productcost
        // price : price memtype startdate enddate
        try (FileWriter writer = new FileWriter(fileName, false);
             BufferedWriter bw = new BufferedWriter(writer)) {
            for(int i = 0; i<customers.size();i++){
                bw.append("------------Bill for Customer ");
                bw.append(Integer.toString(i+1));
                bw.append("-------------\n");
                Customer customer = customers.get(i);
                bw.append("Customer: ");
                bw.append(customer.getName());
                bw.append(" ");
                bw.append(customer.getSurname());
                bw.newLine();
                bw.append("Membership Type: ");
                bw.append(customer.getMembershipType());
                bw.newLine();
                bw.append("Date: ");
                bw.append(customer.getPurchase().getShoppingDate().getDateString());
                bw.newLine();
                bw.newLine();
                bw.append("Items Purchased:\n");
                Purchase purchase = customer.getPurchase();
                for(Product product: purchase.getPurchaseProducts()){
                    bw.append(product.getName());
                    bw.append(" (Qty: ");
                    bw.append(Integer.toString(product.getQuantity()));
                    bw.append(") - ");
                    String strProductCost = String.format(Locale.US, "%.2f", product.getProductCost());
                    bw.append(strProductCost);
                    bw.append(" each\n");
                    for(Price price : product.getPriceList()){
                        if(price.getMembershipType().equals(customer.getMembershipType()) & price.getPrice().equals(strProductCost)){
                            if(customer.isInBetween(purchase.getShoppingDate(),price.getStartDate(),price.getEndDate())){
                                bw.append("(Valid from ");
                                bw.append(price.getStartDate().getDateString());
                                bw.append(" to ");
                                bw.append(price.getEndDate().getDateString());
                                bw.append(")");
                                bw.newLine();
                            }
                        }
                    }
                    bw.append("Subtotal: ");
                    bw.append(String.format(Locale.US, "%.2f", product.getSubCost()));
                    bw.newLine();
                }
                bw.newLine();
                bw.append("Total Cost: ");
                bw.append(Float.toString(purchase.getTotalCost()));
                //add newlines unless its the end of the file
                if(i!=customers.size()-1){
                    bw.newLine();
                    bw.newLine();
                }
            }
        }
    }
}
