import java.util.List;
import java.util.ArrayList;

public class Catty {
    /**
     * https://codingbat.com/prob/p278865
     * 
     * An array list contains a list of animals. If the animal is a cat (i.e. the animal's
     * description contains the word "cat" or "Cat"), then add it to a new array list. Return the
     * new array list of cats.
     * 
     * catty(["buffalo", "dog"]) → []
     * catty(["bobcat", "siamese cat", "catbird"]) → ["bobcat", "siamese cat", "catbird"]
     * catty(["Cat", "frog", "mouse"]) → ["Cat"]
     */

    // Solution to prompt:
    public List<String> catty(List<String> animalsList) {
        ArrayList<String> catList = new ArrayList<>();
        for (String animal : animalsList) {
            if (animal.indexOf("cat") != -1 || animal.indexOf("Cat") != -1) {
                catList.add(animal);
            }
        }
        return catList;
    }
}
