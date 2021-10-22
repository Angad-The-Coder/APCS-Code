import java.util.*;

public class Horse {
    private String name;
    private Date birth;
    private int weight;
    private Horse sire;
    private boolean canBeRidden;

    public Horse(String n, int w, Horse s) {
        this.name = n;
        // Random date of birth:
        long secondsAgo = (long) (Math.random() * Integer.MAX_VALUE + 365 * 3600 * 24);
        this.birth = new Date(System.currentTimeMillis() - secondsAgo);
        this.weight = w;
        this.sire = s;
        this.canBeRidden = Math.random() < .5;
    }

    // Getters:
    public String getName() {
        return this.name;
    }

    public Date getBirth() {
        return this.birth;
    }

    public int getWeight() {
        return this.weight;
    }

    public Horse getSire() {
        return this.sire;
    }

    public boolean getRideability() {
        return this.canBeRidden;
    }

    // Setters:
    public void setName(String newName) {
        this.name = newName;
    }

    public void setBirth(Date newBirth) {
        this.birth = newBirth;
    }

    public void setWeight(int newWeight) {
        this.weight = newWeight;
    }

    public void setSire(Horse newSire) {
        this.sire = newSire;
    }

    public void setRideability(boolean newRideability) {
        this.canBeRidden = newRideability;
    }

    // toString method:
    public String toString() {
        return this.name + " the horse";
    }
}
