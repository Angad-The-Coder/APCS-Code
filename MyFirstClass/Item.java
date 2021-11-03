class Item {
    /* Instance Variables */
    private String name;
    private double price;
    private int numberInStock;
    private int fiveStarRating;

    /* Constructors */
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        this.numberInStock = 20; // default to 20 items in stock
        this.fiveStarRating = 5; // default to fiveStarRating of 5
    }

    public Item(String name, double price, int numberInStock) {
        this.name = name;
        this.price = price;
        this.numberInStock = numberInStock;
        this.fiveStarRating = 5; // default to fiveStarRating of 5
    }

    public Item(String name, double price, int numberInStock, int fiveStarRating) {
        this.name = name;
        this.price = price;
        this.numberInStock = numberInStock;
        this.fiveStarRating = fiveStarRating;
    }

    /* Getters */
    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getNumberInStock() {
        return this.numberInStock;
    }

    public int getFiveStarRating() {
        return this.fiveStarRating;
    }

    /* Setters */
    public void setPrice(double newPrice) {
        // price must be 2 decimal places:
        this.price = Math.round(newPrice * 100.0) / 100.0;
    }

    public void setNumberInStock(int newNumberInStock) {
        this.numberInStock = newNumberInStock;
    }

    // Makes more sense to add/subtract from item stock:
    public void addStock(int numToAdd) {
        this.numberInStock += numToAdd;
    }

    public void subtractStock(int numToSubtract) {
        if (this.numberInStock >= numToSubtract) {
            this.numberInStock -= numToSubtract;
        } else {
            System.out.println("Cannot subtract " + numToSubtract + " " + this.getName()
                    + "s from a total stock of " + this.getNumberInStock() + ".");
        }
    }

    public void setFiveStarRating(int newRating) {
        this.fiveStarRating = newRating;
    }

    /* toString */
    public String toString() {
        // prepare all parameters as strings:
        String nameStr = this.getName();
        String priceStr = String.format("$%,.2f", this.getPrice());
        String ratingStr = "★".repeat(this.getFiveStarRating()) +
                           "☆".repeat(5 - this.getFiveStarRating());
        String stockStr = Integer.toString(this.getNumberInStock());

        // find parameter with max length to print them all out in a fixed
        // width column:
        int maxLength = nameStr.length();
        // each row with these parameters will have a 11-character long label:
        if (priceStr.length() + 11 > maxLength) maxLength = priceStr.length() + 11;
        if (ratingStr.length() + 11 > maxLength) maxLength = ratingStr.length() + 11;
        if (stockStr.length() + 11 > maxLength) maxLength = stockStr.length() + 11;

        String singleColFormat = "|%-" + maxLength + "s|";
        String doubleColFormat = "|%-10s %"+(maxLength-11)+"s|";

        return
            "-".repeat(maxLength + 2) + "\n" +
            String.format(singleColFormat, nameStr) + "\n" +
            "|"+"-".repeat(maxLength) + "|\n" +
            String.format(doubleColFormat, "Price", priceStr) + "\n" +
            String.format(doubleColFormat, "Rating", ratingStr) + "\n" +
            String.format(doubleColFormat, "# in Stock", stockStr) + "\n" +
            "-".repeat(maxLength + 2) + "\n";
    }
}
