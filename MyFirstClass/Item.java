class Item {
  private String name;
  private double price;
  private int numberInStock;
  private double rating;

  // Constructors:
  public Item(String name, double price) {
    this.name = name;
    this.price = price;
    this.numberInStock = 20; // default to 20 items in stock
    this.rating = 100; // default to rating of 100
  }
  public Item(String name, double price, int numberInStock) {
    this.name = name;
    this.price = price;
    this.numberInStock = numberInStock;
    this.rating = 100;  // default to rating of 100
  }
  public Item(String name, double price, int numberInStock, double rating) {
    this.name = name;
    this.price = price;
    this.numberInStock = numberInStock;
    this.rating = rating;
  }

  // Getters:
  public String getName() {
    return this.name;
  }
  public double getPrice() {
    return this.price;
  }
  public int getNumberInStock() {
    return this.numberInStock;
  }
  public double getRating() {
    return this.rating;
  }

  // Setters:
  public void setPrice(int newPrice) {
    this.price = newPrice;
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
      System.out.println(
        "Cannot subtract "+numToSubtract+" "+this.getName()+"s from a total stock of "+this.getNumberInStock()+"."
      )
    }
  }
  public void setRating(double newRating) {
    this.rating = newRating;
  }
}
