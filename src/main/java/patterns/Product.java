package patterns;

import java.time.LocalDate;

public class Product {
    private String id;
    private String name;
    private  Category category;
    private int rating;
    private LocalDate createdDate;
    private LocalDate modifiedDate;

    public static class Builder {
        private String id;
        private String name;
        private Category category;
        private int rating;
        private LocalDate createdDate;
        private LocalDate modifiedDate;
    }
}
