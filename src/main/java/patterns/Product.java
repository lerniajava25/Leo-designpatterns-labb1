package patterns;

import java.time.LocalDate;

public class Product {
    private String id;
    private String name;
    private Category category;
    private int rating;
    private LocalDate createdDate;
    private LocalDate modifiedDate;

    private Product(
            String id,
            String name,
            Category category,
            int rating,
            LocalDate createdDate,
            LocalDate modifiedDate) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;

    }

    public static class Builder {
        private String id;
        private String name;
        private Category category;
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

        public Builder rating(int rating) {
            this.rating = rating;
            return this;
        }

        public Product build() {
            return new Product(
                    id,
                    name,
                    category,
                    rating,
                    LocalDate.now(),
                    LocalDate.now()
            );
        }
    }
}
