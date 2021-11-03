class Mall {
    /* Instance Variables: */
    private String name;
    private String address;
    private Store[] stores;
    private Restaurant[] foodCourt;

    /* Constructors: */
    public Mall(String name, String address) {
        this.name = name;
        this.address = address;
        // initialize mall with no stores or restaurants:
        this.setStores(new Store[0]);
        this.setFoodCourt(new Restaurant[0]);
    }

    public Mall(String name, String address, Store[] stores, Restaurant[] foodCourt) {
        this.name = name;
        this.address = address;
        this.setStores(stores);
        this.setFoodCourt(foodCourt);
    }

    /* Getters: */
    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public Store[] getStores() {
        return this.stores;
    }

    public Restaurant[] getFoodCourt() {
        return this.foodCourt;
    }

    /* Setters: */

    public void setStores(Store[] newStores) {
        this.stores = newStores;
    }

    // Makes more sense to add stores one at a time:
    public void addStore(Store newStore) {
        Store[] temp = new Store[this.getStores().length + 1];
        for (int i = 0; i < this.getStores().length; i++) {
            temp[i] = this.getStores()[i];
        }
        temp[temp.length - 1] = newStore;
        this.setStores(temp);
    }

    public void setFoodCourt(Restaurant[] newFoodCourt) {
        this.foodCourt = newFoodCourt;
    }

    // Makes more sense to add restaurants one at a time:
    public void addRestaurant(Restaurant newRestaurant) {
        Restaurant[] temp = new Restaurant[this.getFoodCourt().length + 1];
        for (int i = 0; i < this.getFoodCourt().length; i++) {
            temp[i] = this.getFoodCourt()[i];
        }
        temp[temp.length - 1] = newRestaurant;
        this.setFoodCourt(temp);
    }

    /* toString */
    public String toString() {
        return this.getName() + "\n" + "** Located at " + this.getAddress() + " **";
    }

    public String storeInfo() {
        String storesStr = "The stores at " + this.getName() + ":\n";
        for (int i = 0; i < this.getStores().length; i++) {
            storesStr += this.getStores()[i].toString();
        }
        return storesStr;
    }

    public String foodCourtInfo() {
        String foodCourtStr = "The food court at the " + this.getName() + ":\n";
        for (int i = 0; i < this.getFoodCourt().length; i++) {
            foodCourtStr += this.getFoodCourt()[i].toString();
        }
        return foodCourtStr;
    }
}
