import java.time.LocalTime;

class Restaurant {
    private String name;
    private Food[] menu;
    private double rating;
    private LocalTime openingTime;
    private LocalTime closingTime;

    // Constructors:
    public Restaurant(String name, Food[] menu) {
        this.name = name;
        this.menu = menu;
        this.rating = 100; // default rating to 100;
        // default restaurant is open from 8 AM to 9 PM:
        this.openingTime = LocalTime.parse("08:00");
        this.closingTime = LocalTime.parse("21:00");
    }
    public Restaurant(String name, Food[] menu, double rating) {
        this.name = name;
        this.menu = menu;
        this.rating = rating;
        // default restaurant is open from 8 AM to 9 PM:
        this.openingTime = LocalTime.parse("08:00");
        this.closingTime = LocalTime.parse("21:00");
    }
    public Restaurant(String name, Food[] menu, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.menu = menu;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.rating = 100; // default rating to 100;
    }
    public Restaurant(String name, Food[] menu, LocalTime openingTime, LocalTime closingTime, double rating) {
        this.name = name;
        this.menu = menu;
        this.rating = rating;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    // Getters:
    public String getName() {
        return this.name;
    }
    public Food[] getMenu() {
        return this.menu;
    }
    public double getRating() {
        return this.rating;
    }
    public LocalTime getOpeningTime() {
        return this.openingTime;
    }
    public LocalTime getClosingTime() {
        return this.closingTime;
    }

    // Setters:
    public void setMenu(Food[] newMenu) {
        this.menu = newMenu;
    }
    // Makes more sense to add an individual food item to the menu:
    public void addToMenu(Food newFood) {
        Food[] temp = new Food[this.menu.length + 1];
        for (int i = 0; i < this.menu.length; i++) {
            temp[i] = this.menu[i];
        }
        temp[temp.length - 1] = newFood;
        this.menu = temp;
    }
    public void setRating(double newRating) {
        this.rating = newRating;
    }
    public void setOpeningTime(LocalTime newOpeningTime) {
        this.openingTime = newOpeningTime;
    }
    public void setClosingTime(LocalTime newClosingTime) {
        this.closingTime = newClosingTime;
    }
}