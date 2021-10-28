class Food {
    private String name;
    private double rating;
    private String typeOfFood;
    private boolean isVegetarian;
    private int calories;

    // Constructors:
    public Food(String name, double rating) {
        this.name = name;
        this.rating = rating;
        this.typeOfFood = "Miscellaneous"; // default type of food
        this.isVegetarian = false; // assume the food is non-veg
        this.calories = 200; // default amount of calories
    }
}