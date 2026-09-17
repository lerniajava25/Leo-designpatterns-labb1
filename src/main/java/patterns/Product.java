package patterns;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Product {
    private final String id;
    private final String name;
    private final Category category;
    private final BigDecimal price;
    private final int rating;
    private final LocalDate createdDate;
    private final LocalDate modifiedDate;

    private Product(
            String id,
            String name,
            Category category,
            BigDecimal price,
            int rating,
            LocalDate createdDate,
            LocalDate modifiedDate) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", rating=" + rating +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }

    public static class Builder {
        private String id;
        private String name;
        private Category category;
        private BigDecimal price;
        private int rating;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder category(Category category) {
            this.category = category;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder rating(int rating) {
            this.rating = rating;
            return this;
        }

        public Product build() {
            if (name == null || name.isBlank()) {
                throw new IllegalStateException(
                        "Name cannot be empty"
                );
            }

            return new Product(
                    id,
                    name,
                    category,
                    price,
                    rating,
                    LocalDate.now(),
                    LocalDate.now()
            );
        }
    }
}
