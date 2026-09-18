package patterns;

import java.math.BigDecimal;

public class DiscountDecorator extends ProductDecorator {

    private double discountPercentage;

    DiscountDecorator(Sellable product, double discountPercentage) {
        super(product);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public BigDecimal getPrice(){
        BigDecimal price = decoratedProduct.getPrice();
        BigDecimal discount = BigDecimal.valueOf(discountPercentage)
                .multiply(price);
        return price.subtract(discount);
    }
}
