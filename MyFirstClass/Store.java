import java.time.LocalTime;

class Store {
    /* Instance Variables */
    private String name;
    private Item[] items;
    private LocalTime openingTime;
    private LocalTime closingTime;

    /* Constructors */
    public Store(String name, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        // initialize store with no items:
        this.items = new Item[0];
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public Store(String name, Item[] items, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.items = items;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    /* Getters */
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

    /* Setters */
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

    // toString method:
    public String toString() {
        String storeStr = this.getName() + "\n" +
            "** Open from "+ this.getOpeningTime().toString() + " to " + this.getClosingTime().toString() + " **\n" + 
            "\nItems:\n";
        for (int i = 0; i < this.getItems().length; i++) {
            storeStr += this.getItems()[i].toString();
        }
        return storeStr;
    }
}
