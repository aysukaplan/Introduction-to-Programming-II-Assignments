import java.util.ArrayList;

public class Purchase {
    private PriceDate shoppingDate;
    private ArrayList<Product> purchaseProducts;

    private float totalCost;

    public Purchase(PriceDate shoppingDate, ArrayList<Product> purchaseProducts) {
        this.shoppingDate = shoppingDate;
        this.purchaseProducts = purchaseProducts;
        this.totalCost = 0;
    }

    public Purchase() {
    }

    public Purchase(PriceDate shoppingDate, ArrayList<Product> purchaseProducts, int totalCost) {
        this.shoppingDate = shoppingDate;
        this.purchaseProducts = purchaseProducts;
        this.totalCost = totalCost;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public PriceDate getShoppingDate() {
        return shoppingDate;
    }

    public void setShoppingDate(PriceDate shoppingDate) {
        this.shoppingDate = shoppingDate;
    }

    public ArrayList<Product> getPurchaseProducts() {
        return purchaseProducts;
    }

    public void setPurchaseProducts(ArrayList<Product> purchaseProducts) {
        this.purchaseProducts = purchaseProducts;
    }


}
