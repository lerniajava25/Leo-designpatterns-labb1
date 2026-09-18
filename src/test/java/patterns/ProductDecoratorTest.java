package patterns;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;


public class ProductDecoratorTest {

    private static class TestProductDecorator extends ProductDecorator{

        TestProductDecorator(Sellable product){
            super(product);
        }
    }

    @Test
    void shouldDelegateSellableMethodsToDecoratedProduct() {

        Product appleTree = new Product.Builder()
                .id("2")
                .name("Apple Tree")
                .category(Category.GARDENING)
                .price(BigDecimal.valueOf(3000))
                .rating(8)
                .build();

        TestProductDecorator decorator = new TestProductDecorator(appleTree);

        assertThat(decorator.getId()).isEqualTo(appleTree.getId());
        assertThat(decorator.getName()).isEqualTo(appleTree.getName());
        assertThat(decorator.getPrice()).isEqualByComparingTo(appleTree.getPrice());
    }
}
