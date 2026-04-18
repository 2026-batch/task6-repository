public class Vegetables {

    private Vegetable vegetable;

    public void setVegetable(Vegetable vegetable) {
        this.vegetable = vegetable;
    }

    public Vegetable getVegetable() {
        return vegetable;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Vegetables:\n");

        for (Vegetable veg : Vegetable.values()) {
            sb.append("      ").append(veg).append("\n");
        }

        return sb.toString();
    }
}