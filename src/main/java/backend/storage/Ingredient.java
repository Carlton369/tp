package backend.storage;

public class Ingredient {
    private String ingredientName;
    private int quantity;

    public Ingredient(String ingredientName, int quantity) {
        this.ingredientName = ingredientName;
        this.quantity = quantity;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(int quantity) { this.quantity += quantity; }

    public void subtractQuantity(int quantity) { this.quantity -= quantity; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient other = (Ingredient) o;
        return this.ingredientName.equals(other.ingredientName);
    }

    @Override
    public String toString() {
        return ingredientName + " (" + quantity + ")";
    }
}
