import java.util.ArrayList;

public class Product {
    private String name;
    private int quantity;

    private ArrayList<Price> priceList;


    float subCost ; //price of the product times quantity
    float productCost; //price of the product

    public Product() {
    }

    public Product(String name) {
        this.name = name;
        this.quantity = 0;
        priceList = new ArrayList<>();

    }

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        priceList = new ArrayList<>();

    }
    public Product(String name,  ArrayList<Price> priceList) {
        this.name = name;
        this.quantity = 0;
        this.priceList = priceList;

    }


    public Product(String name, int quantity, ArrayList<Price> priceList) {
        this.name = name;
        this.quantity = quantity;
        this.priceList = priceList;

    }

    public Product(String name, int quantity, ArrayList<Price> priceList, int subCost, int productCost) {
        this.name = name;
        this.quantity = quantity;
        this.priceList = priceList;
        this.productCost = productCost;
        this.subCost = quantity * productCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ArrayList<Price> getPriceList() {
        return priceList;
    }

    public void setPriceList(ArrayList<Price> priceList) {
        this.priceList = priceList;
    }

    public void addPriceToPriceList(Price p){
        priceList.add(p);
    }

    public float getSubCost() {
        return subCost;
    }

    public void setSubCost(float subCost) {
        this.subCost = subCost;
    }

    public float getProductCost() {
        return productCost;
    }

    public void setProductCost(float productCost) {
        this.productCost = productCost;
    }
}
