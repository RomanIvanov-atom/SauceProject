package products;

import java.util.HashMap;
import java.util.Map;

public class Products {
    public static final String BACKPACK = "Sauce Labs Backpack";
    public static final String LIGHT = "Sauce Labs Bike Light";
    public static final String T_SHIRT = "Sauce Labs Bolt T-Shirt";
    public static final String JACKET = "Sauce Labs Fleece Jacket";
    public static final String ONESIE = "Sauce Labs Onesie";
    public static final String RED_T_SHIRT = "Test.allTheThings() T-Shirt (Red)";

    public static final Map<String, Double> PRODUCT_PRICES = new HashMap<>(Map.ofEntries(
            Map.entry(BACKPACK, 29.99),
            Map.entry(LIGHT, 9.99),
            Map.entry(T_SHIRT, 15.99),
            Map.entry(JACKET, 49.99),
            Map.entry(ONESIE, 7.99),
            Map.entry(RED_T_SHIRT, 15.99)
    ));
}
