package patterns;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

public class DiscountDecoratorTest {

    @Test
    void shouldApplyDiscountToProductPrice() {
        Product appleTree = new Product.Builder()
                .id("2")
                .name("Apple Tree")
                .category(Category.GARDENING)
                .price(BigDecimal.valueOf(3000))
                .rating(8)
                .build();

        DiscountDecorator wrappedObject = new DiscountDecorator(appleTree, 0.20);
        BigDecimal discountPrice = wrappedObject.getPrice();
        BigDecimal originalPrice = appleTree.getPrice();

        assertThat(discountPrice).isEqualByComparingTo(BigDecimal.valueOf(2400));
        assertThat(originalPrice).isEqualByComparingTo(BigDecimal.valueOf(3000));

        //Test that id and name are delegated unchanged
        assertThat(wrappedObject.getId()).isEqualTo("2");
        assertThat(wrappedObject.getName()).isEqualTo("Apple Tree");
    }

}
