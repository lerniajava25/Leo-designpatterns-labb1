package patterns;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductTest {

    @Test
    void shouldBuildProductWithCorrectValues() {
        Product fridge = new Product.Builder()
                .id("1")
                .name("Fridge")
                .category(Category.ELECTRONICS)
                .price(BigDecimal.valueOf(3000))
                .rating(8)
                .build();

        assertThat(fridge.getId()).isEqualTo("1");
        assertThat(fridge.getName()).isEqualTo("Fridge");
        assertThat(fridge.getCategory()).isEqualTo(Category.ELECTRONICS);
        assertThat(fridge.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(3000));
        assertThat(fridge.getRating()).isEqualTo(8);
        assertThat(fridge.getCreatedDate()).isEqualTo(LocalDate.now());
        assertThat(fridge.getModifiedDate()).isEqualTo(LocalDate.now());
    }

    @Test
    void shouldThrowIllegalStateExceptionIfNameIsMissing() {

        Product.Builder builder = new Product.Builder()
                .id("1")
                .category(Category.ELECTRONICS)
                .price(BigDecimal.valueOf(3000))
                .rating(8);

        assertThatThrownBy(() -> builder.build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Name cannot be empty");
    }

    @Test
    void shouldThrowIllegalStateExceptionIfNameIsBlank() {
        Product.Builder builder = new Product.Builder()
                .id("1")
                .name("      ")
                .category(Category.ELECTRONICS)
                .price(BigDecimal.valueOf(3000))
                .rating(8);

        assertThatThrownBy(() -> builder.build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Name cannot be empty");
    }

    @Test
    void shouldReturnProductAsAString(){
        Product fridge = new Product.Builder()
                .id("1")
                .name("Fridge")
                .category(Category.ELECTRONICS)
                .price(BigDecimal.valueOf(3000))
                .rating(8)
                .build();

        assertThat(fridge.toString()).contains(
                "id='1'",
                "name='Fridge'",
                "category=ELECTRONICS",
                "price=3000",
                "rating=8"
        );
    }
}

