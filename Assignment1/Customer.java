import java.util.ArrayList;

public class Customer {
    private String name;
    private String surname;
    private String membershipType;
    private Purchase purchase;


    public Customer(String name, String surname, String membershipType, Purchase purchase) {
        this.name = name;
        this.surname = surname;
        this.membershipType = membershipType;
        this.purchase = purchase;
    }

    public static ArrayList<Product> createProductList(String[] priceLines) {
        //customer : name surname memType purchase
        //purchase : shoppingdate purchaseProductslist totalcost
        //product : name quantity pricelist subcost productcost
        // price : price memtype startdate enddate

        ArrayList<Product> productsSold = new ArrayList<>();
        for(String line:priceLines){
            String[] sepTab = line.split("\t");
            String productName = sepTab[0];
            String memType = sepTab[1];
            PriceDate startDate = new PriceDate(sepTab[2]);
            PriceDate endDate = new PriceDate(sepTab[3]);
            String price = sepTab[4];
            Price pri = new Price(price,memType,startDate,endDate);


            //checking if the product already added to the product list
            boolean isProductInList = false;

            if(!productsSold.isEmpty()){
                for(Product product:productsSold){
                    if(product.getName().equals(productName)){
                        isProductInList = true;
                    }
                }
            }

            //if product is in the list
            if (isProductInList) {
                //if the product is already in list
                //add price to pricelist
                for(Product product:productsSold){
                    if(product.getName().equals(productName)) {
                        product.addPriceToPriceList(pri);
                    }
                }
            }
            else { //product is not in product list
                ArrayList<Price> priceList = new ArrayList<>();
                priceList.add(pri);
                //subcost and productcost will be added in costumer list creation
                Product product = new Product(productName,priceList);
                productsSold.add(product);
            }
        }
        return productsSold; //these products dont have sub cost and productcost
    }

        public static ArrayList<Customer> createCustomerList(String[] purchaseLines, ArrayList<Product> products) {

        //creating customer and filling customer list with prices
        ArrayList<Customer> customers = new ArrayList<>();
        // customer’s name(space) surname (tab) type of membership
        //(Premium, Standard, or Basic), shopping date, and a list of book titles with quantities
        for(String line:purchaseLines){
            //first divide with tab
            //then name and surname with space
            //length matters
            String[] sepTab = line.split("\t");
            String[] sepNameSurname = sepTab[0].split(" ");
            String name = sepNameSurname[0];
            String surname = sepNameSurname[1];
            String memType = sepTab[1];
            String dateString = sepTab[2];
            PriceDate shoppingDate = new PriceDate(dateString);

            //customer : name surname memType purchase
            //purchase : shoppingdate purchaseProductslist totalcost
            //product : name quantity pricelist subcost productcost
            // price : price memtype startdate enddate

            //setting the product list of the customer
            ArrayList<Product> purchaseProducts = new ArrayList<>();
            for(int i=3;  i <sepTab.length-1 ; i=i+2 ){
                String productName = sepTab[i];
                int quantity = Integer.parseInt(sepTab[i+1]);
                //find the product from product list
                for(Product product:products) {
                    if (product.getName().equals(productName)) {
                        Product pNew = new Product(product.getName(),quantity,product.getPriceList());
                        //add product to products list
                        purchaseProducts.add(pNew);

                    }
                }
            }
            Purchase purchase = new Purchase(shoppingDate,purchaseProducts);
            Customer customer = new Customer(name,surname,memType,purchase);
            customer.calculateProductCostSubCost();
            customer.calculateTotalCost();
            customers.add(customer);
        }
        return customers;
    }




    public void calculateTotalCost() {
        //adding all subcosts and set it as the totalcost of the purchase
        Purchase purchase = this.getPurchase();
        float totalCost = 0;
        for (Product product : purchase.getPurchaseProducts()) {
            //product : name quantity pricelist subcost productcost
            totalCost += product.getSubCost();
        }
        purchase.setTotalCost(totalCost);
    }

    public void calculateProductCostSubCost() {
        Purchase purchase = this.getPurchase();
        PriceDate shoppingDate = purchase.getShoppingDate();
        String memType = this.getMembershipType();
        for (Product product : purchase.getPurchaseProducts()) {
            int productQuantity = product.getQuantity();
            ArrayList<Price> pricesOfProduct = product.getPriceList();
            for(Price priceOfProduct : pricesOfProduct){
                //check the membership type
                if(priceOfProduct.getMembershipType().equals(memType)){
                    //check the valid dates
                    if(isInBetween(shoppingDate,priceOfProduct.getStartDate(),priceOfProduct.getEndDate())){
                        product.setProductCost(Float.parseFloat(priceOfProduct.getPrice()));
                        product.setSubCost(Float.parseFloat(priceOfProduct.getPrice()) * productQuantity);
                    }
                }
            }
        }
    }


    //checking if a date is between given dates
    public boolean isInBetween(PriceDate date, PriceDate start, PriceDate end){
        //check the year
        boolean bool = false;
        if((end.getYear() >= date.getYear()) & (date.getYear() >= start.getYear())){
            if((end.getMonth() >= date.getMonth()) & (date.getMonth() >= start.getMonth())){
                if((end.getDay() >= date.getDay()) & (date.getDay() >= start.getDay())){
                    bool =  true;
                }
            }
        }
        return bool;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
