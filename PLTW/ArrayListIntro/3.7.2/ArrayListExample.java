/*
 * Activity 3.7.2
 */
import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String args[]) {
        ArrayList<String> animalList = new ArrayList<String>();
        animalList.add("Dog");
        animalList.add("Cat");
        animalList.add("Rabbit");
        animalList.add("Frog");
        animalList.add("Horse");
        animalList.add("Cow");

        // displaying elements
        System.out.println(animalList);

        // Step 5: Create your own add statement to add a "bird" to the list. Notice where in the
        // list the bird is added.
        animalList.add("bird");
        // Step 6: Create an add statement that will add a "snake" in the fourth position in the
        // list. Remember that arrays and ArrayLists start indexing at 0.
        animalList.add(3, "snake");
        // Step 7: Add code to retrieve and print the second, third, and fifth items in the list.
        System.out.println(animalList.get(1));
        System.out.println(animalList.get(2));
        System.out.println(animalList.get(4));
        // Step 8: Add code to remove the "Frog" from the list.
        animalList.remove(4);
        // Step 9: Add code to print the size of the list.
        System.out.println("animalList length: " + animalList.size());

        // display elements
        System.out.println(animalList);
    }
}
