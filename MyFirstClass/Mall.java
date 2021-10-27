public class Mall {
  //Let's add some instance variables here!
  //Don't forget to create arrays to hold your objects!
  private String name;
  private String address;
  private double rating;
  private Store[] stores;
  private Restaurant[] foodCourt;
  public static void main(String[] args) {
    //Time to make some constructors. Comment about what they are for. You need three different ones!




    //create your objects here! You should have 2 - 3 objects for each type of constructor
  }
}

private class Store {
  private String name;
  private double rating;
  private Item[] items;
  public Store(String name, Item[] items) {
    this.name = name;
    this.items = items;
  }
  public Store(String name, Item[] items, double rating) {
    this.name = name;
    this.items = items;
    this.rating = rating;
  }
  
  // Getters:
  public String getName() {
    return this.name;
  }
  public double rating() {
    return this.rating;
  }
  public Item[] getItems() {
    return this.items;
  }

  // Setters:
  public void setRating(double newRating) {
    this.rating = newRating;
  }
  public void setItems(Item[] newItems) {
    this.items = newItems;
  }
  public void addItem(Item[] newItem) {
    
  }
}

private class Item {
  private String name;
  private double price;
  private int numberInStock;
  private double rating;

  // Constructors:
  public Item(String name, double price) {
    this.name = name;
    this.price = price;
    this.numberInStock = 20; // default to 20 items in stock
  }
  public Item(String name, double price, int numberInStock) {
    this.name = name;
    this.price = price;
    this.numberInStock = numberInStock;
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
  public void setRating(double newRating) {
    this.rating = newRating;
  }
}
//Make some getters and setters


//Write methods that will put your objects into appropriate arrays



//Write a second method that will do something with one of your objects and use the toString that you created


		
//Can you add a scanner that will ask you for a specific object and then return a toString with it's information



//Write a tostring method to get information about your object



  
}