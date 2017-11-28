package de.codepub.bakeandroid.items;

import java.io.Serializable;

public class Ingredient implements Serializable {
    public double quantity;
    public String measure;
    public String ingredient;

    public Ingredient() {
    }

    public Ingredient(String ingredient, double quantity, String measure) {
        this.quantity = quantity;
        this.measure = measure;
        this.ingredient = ingredient;
    }

    public String getQuantity() {
        if (quantity % 1 == 0) {
            return String.valueOf((int) quantity);
        }
        return String.valueOf(quantity);
    }
}
