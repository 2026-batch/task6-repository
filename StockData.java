public class StockData {

    private Cosmotics cosmotics;
    private Grocery grocery;

    public StockData(Cosmotics cosmotics, Grocery grocery) {
        this.cosmotics = cosmotics;
        this.grocery = grocery;
    }

    public Cosmotics getCosmotics() {
        return cosmotics;
    }

    public Grocery getGrocery() {
        return grocery;
    }

    @Override
    public String toString() {
        return "StockData:\n"
                + cosmotics + "\n"
                + grocery;
    }
}