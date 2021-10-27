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
  private 
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
}
//Make some getters and setters


//Write methods that will put your objects into appropriate arrays



//Write a second method that will do something with one of your objects and use the toString that you created


		
//Can you add a scanner that will ask you for a specific object and then return a toString with it's information



//Write a tostring method to get information about your object



  
}