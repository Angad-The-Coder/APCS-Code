import java.time.LocalTime;

class Store {
  private String name;
  private Item[] items;
  private LocalTime openingTime;
  private LocalTime closingTime;

  public Store(String name, Item[] items) {
    this.name = name;
    this.items = items;
    // Default store is open from 10 AM to 7 PM:
    this.openingTime = LocalTime.parse("10:00");
    this.closingTime = LocalTime.parse("19:00");
  }
  public Store(String name, Item[] items, LocalTime openingTime, LocalTime closingTime) {
    this.name = name;
    this.items = items;
    this.openingTime = openingTime;
    this.closingTime = closingTime;
  }
  
  // Getters:
  public String getName() {
    return this.name;
  }
  public Item[] getItems() {
    return this.items;
  }
  public LocalTime getOpeningTime() {
    return this.openingTime;
  }
  public LocalTime getClosingTime() {
    return this.closingTime;
  }

  // Setters:
  public void setRating(double newRating) {
    this.rating = newRating;
  }
  public void setItems(Item[] newItems) {
    this.items = newItems;
  }
  // Makes more sense to add items one at a time:
  public void addItem(Item newItem) {
    Item[] temp = new Item[this.items.length + 1];
    for (int i = 0; i < this.items.length; i++) {
      temp[i] = this.items[i];
    }
    temp[temp.length - 1] = newItem;
    this.items = temp;
  }
  public void setOpeningTime(LocalTime newOpeningTime) {
    this.openingTime = newOpeningTime;
  }
  public void setClosingTime(LocalTime newClosingTime) {
    this.closingTime = newClosingTime;
  }

  //toString method:
  public String toString() {
    return 
      "The "+this.getName()+" Store:\n"+
      "** Open from "+this.openingTime.toString()+" to "+this.closingTime.toString()+" **";
  }
}