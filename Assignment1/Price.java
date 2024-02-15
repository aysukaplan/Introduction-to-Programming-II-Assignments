public class Price {
    private String price;
    private String membershipType;

    private PriceDate startDate;
    private  PriceDate endDate;

    public Price(String price, String membershipType, PriceDate startDate, PriceDate endDate) {
        this.price = price;
        this.membershipType = membershipType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public PriceDate getStartDate() {
        return startDate;
    }

    public void setStartDate(PriceDate startDate) {
        this.startDate = startDate;
    }

    public PriceDate getEndDate() {
        return endDate;
    }

    public void setEndDate(PriceDate endDate) {
        this.endDate = endDate;
    }
}
