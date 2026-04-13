public enum Vegetable {

    TOMATO(100),
    MIRCHI(100),
    CAPSICUM(100),
    BOTTLE_GOURD(100);

    private int quantity;

    Vegetable(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%-15s : %d KG", name(), quantity);
    }
}