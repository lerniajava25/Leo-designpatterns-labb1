package patterns;

import java.math.BigDecimal;

public class PrintProduct {
    public static void main(String[] args) {
        Product product = new Product.Builder()
                .id("1")
                .name("Fridge")
                .category(Category.ELECTRONICS)
                .price(BigDecimal.valueOf(200))
                .rating(5)
                .build();

        System.out.println(product.toString());

    }
}
