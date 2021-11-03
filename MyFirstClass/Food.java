class Food {
    /* Instance Variables */
    private String name;
    private double price;
    private boolean isVegetarian;
    private int calories;
    private int fiveStarRating;

    /* Constructors */
    public Food(String name, double price, boolean isVegetarian, int calories) {
        this.setName(name);
        this.setPrice(price);
        this.setIsVeg(isVegetarian);
        this.setCalories(calories);
        this.setFiveStarRating(5); // default fiveStarRating to 5
    }

    public Food(String name, double price, boolean isVegetarian, int calories, int fiveStarRating) {
        this.setName(name);
        this.setPrice(price);
        this.setIsVeg(isVegetarian);
        this.setCalories(calories);
        this.setFiveStarRating(fiveStarRating);
    }

    /* Getters */
    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean getIsVeg() {
        return this.isVegetarian;
    }

    public int getCalories() {
        return this.calories;
    }

    public int getFiveStarRating() {
        return this.fiveStarRating;
    }

    /* Setters */
    public void setName(String newName) {
        this.name = newName;
    }

    public void setPrice(double newPrice) {
        // price must be 2 decimal places:
        this.price = Math.round(newPrice * 100.0) / 100.0;
    }

    public void setIsVeg(boolean newVeg) {
        this.isVegetarian = newVeg;
    }

    public void setCalories(int newCalories) {
        this.calories = newCalories;
    }

    public void setFiveStarRating(int newRating) {
        // Rating should be between 0 and 5:
        if (newRating > 5) {
            this.fiveStarRating = 5;
        } else if (newRating < 0) {
            this.fiveStarRating = 0;
        } else {
            this.fiveStarRating = newRating;
        }
    }

    /* toString */
    public String toString() {
        // prepare all parameters as strings:
        String nameStr = this.getName();
        String isVegStr = this.getIsVeg() ? "Vegetarian" : "Non-Vegetarian";
        String priceStr = String.format("$%,.2f", this.getPrice());
        String ratingStr = "★".repeat(this.getFiveStarRating()) +
                           "☆".repeat(5 - this.getFiveStarRating());
        String caloriesStr = Integer.toString(this.getCalories());

        // find parameter with max length to print them all out in a fixed
        // width column:
        int maxLength = nameStr.length();
        if (isVegStr.length() > maxLength) maxLength = isVegStr.length();
        // each row with these parameters will have a 11-character long label:
        if (priceStr.length() + 11 > maxLength) maxLength = priceStr.length() + 11;
        if (ratingStr.length() + 11 > maxLength) maxLength = ratingStr.length() + 11;
        if (caloriesStr.length() + 11 > maxLength) maxLength = caloriesStr.length() + 11;

        String singleColFormat = "|%-" + maxLength + "s|";
        String doubleColFormat = "|%-10s %"+(maxLength-11)+"s|";

        return
            "-".repeat(maxLength + 2) + "\n" +
            String.format(singleColFormat, nameStr) + "\n" +
            String.format(singleColFormat, isVegStr) + "\n" +
            "|"+"-".repeat(maxLength) + "|\n" +
            String.format(doubleColFormat, "Price", priceStr) + "\n" +
            String.format(doubleColFormat, "Rating", ratingStr) + "\n" +
            String.format(doubleColFormat, "Calories", caloriesStr) + "\n" +
            "-".repeat(maxLength + 2) + "\n";
    }
}
