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

}
