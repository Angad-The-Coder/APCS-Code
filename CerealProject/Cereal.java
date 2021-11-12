import java.util.ArrayList;

public class Cereal implements Comparable<Cereal> {

    /* Instance Variables */
    private String name;
    private boolean cold;
    private int calories;
    private int protein;
    private int fat;
    private int sodium;
    private double fiber;
    private double carbohydrates;
    private int sugar;
    private int potassium;
    private int vitamins;
    private int shelf;
    private double weight;
    private double cups;
    private double rating;

    /* Constructor */
    public Cereal(String name, boolean cold, int calories, int protein, int fat, int sodium,
            double fiber, double carbohydrates, int sugar, int potassium, int vitamins, int shelf,
            double weight, double cups, double rating) {
        this.name = name;
        this.cold = cold;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.fiber = fiber;
        this.carbohydrates = carbohydrates;
        this.sugar = sugar;
        this.potassium = potassium;
        this.vitamins = vitamins;
        this.shelf = shelf;
        this.weight = weight;
        this.cups = cups;
        this.rating = rating;
    }

    /* Getters */
    public String getName() {
        return this.name;
    }

    public boolean getCold() {
        return this.cold;
    }

    public int getCalories() {
        return this.calories;
    }

    public int getProtein() {
        return this.protein;
    }

    public int getFat() {
        return this.fat;
    }

    public int getSodium() {
        return this.sodium;
    }

    public double getFiber() {
        return this.fiber;
    }

    public double getCarbs() {
        return this.carbohydrates;
    }

    public int getSugar() {
        return this.sugar;
    }

    public int getPotassium() {
        return this.potassium;
    }

    public int getVitamins() {
        return this.vitamins;
    }

    public int getShelf() {
        return this.shelf;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getCups() {
        return this.cups;
    }

    public double getRating() {
        return this.rating;
    }

    // fiber to protein ratio
    public double getFPRatio() {
        return this.fiber / this.protein;
    }

    /**
     * This method receives a String containing comma-separated values representing a Cereal
     * object's attributes and it returns a Cereal object that matches these attributes, using the
     * csvToList() method to access each individual attribute.
     * 
     * @param s a String containing comma-separated attributes for a Cereal object.
     * @return a Cereal object with the attributes described in s
     */
    public static Cereal parseCereal(String s) {
        ArrayList<String> attrList = csvToList(s);

        Cereal c = new Cereal(attrList.get(0), // name
                (attrList.get(1).equals("C")), // cold
                Integer.parseInt(attrList.get(2)), // calories
                Integer.parseInt(attrList.get(3)), // protein
                Integer.parseInt(attrList.get(4)), // fat
                Integer.parseInt(attrList.get(5)), // sodium
                Double.parseDouble((attrList.get(6))), // fiber
                Double.parseDouble(attrList.get(7)), // carbohydrates
                Integer.parseInt(attrList.get(8)), // sugar
                Integer.parseInt(attrList.get(9)), // potassium
                Integer.parseInt(attrList.get(10)), // vitamins
                Integer.parseInt(attrList.get(11)), // shelf
                Double.parseDouble(attrList.get(12)), // weight
                Double.parseDouble(attrList.get(13)), // cups
                Double.parseDouble((attrList.get(14))) // rating
        );

        return c;
    }

    /**
     * Given a string with comma-separated values, return an ArrayList<String> that contains each
     * comma-separated value individually at its own index.
     * 
     * @param csvStr
     * @return the ArrayList<String> that contains all the items held in csvStrs
     */
    private static ArrayList<String> csvToList(String csvStr) {
        ArrayList<String> rowList = new ArrayList<>();
        while (csvStr.indexOf(",") != -1) {
            rowList.add(csvStr.substring(0, csvStr.indexOf(",")));
            csvStr = csvStr.substring(csvStr.indexOf(",") + 1);
        }
        rowList.add(csvStr);
        return rowList;
    }

    @Override
    /**
     * Return a String showcasing the cereal's name, calories, fiber, and protein as a pretty table
     * using String.format()
     */
    public String toString() {
        // prepare all parameters as strings:
        String nameStr = this.getName();
        if (this.getCold()) {
            nameStr += " ❆";
        } else {
            nameStr += " ♨";
        }
        String caloriesStr = Integer.toString(this.getCalories());
        String fiberStr = String.format("%.0f", this.getFiber());
        String proteinStr = String.format("%d", this.getProtein());

        // now, print out these parameters as a table:
        int leftWidth = 30; // width of the left column in our table

        // find which line in our table has the greatest length (will be used to contain all
        // attributes in a fixed width column)
        int maxLength = nameStr.length();
        // add leftWidth when evaluating the following values since they will be preceded with
        // the left column in our final table:
        if (caloriesStr.length() + leftWidth > maxLength)
            maxLength = caloriesStr.length() + leftWidth;
        if (fiberStr.length() + leftWidth > maxLength)
            maxLength = fiberStr.length() + leftWidth;
        if (proteinStr.length() + leftWidth > maxLength)
            maxLength = proteinStr.length() + leftWidth;

        String singleColFormat = "|%-" + maxLength + "s|";
        String doubleColFormat = "|%-" + (leftWidth - 1) + "s %" + (maxLength - leftWidth) + "s|";


        return "-".repeat(maxLength + 2) + "\n" + String.format(singleColFormat, nameStr) + "\n"
                + "|" + "-".repeat(maxLength) + "|\n"
                + String.format(doubleColFormat, "Calories", caloriesStr) + "\n"
                + String.format(doubleColFormat, "Fiber", fiberStr) + "\n"
                + String.format(doubleColFormat, "Protein", proteinStr) + "\n"
                + "-".repeat(maxLength + 2);
    }

    @Override
    /*
     * Since the Cereal class inherits the Comparable interface, by overriding its compareTo method
     * to compare the sugar amounts of two cerals, the sortBySugar method in the FileProcessor class
     * can just call Collections.sort() on its ArrayList (list) of Cereal objects.
     */
    public int compareTo(Cereal c) {
        if (this.getSugar() > c.getSugar()) {
            return 1;
        } else if (this.getSugar() < c.getSugar()) {
            return -1;
        } else {
            return 0;
        }
    }
}
