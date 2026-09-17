package patterns;

import java.math.BigDecimal;

public abstract class ProductDecorator implements Sellable{

    protected Sellable decoratedProduct;

    ProductDecorator(Sellable product){
        this.decoratedProduct = product;
    }

    @Override
    public String getName(){
        return decoratedProduct.getName();
    }

    @Override
    public BigDecimal getPrice(){
        return decoratedProduct.getPrice();
    }

    @Override
    public String getId(){
        return decoratedProduct.getId();
    }
}
