/*
 * Activity 3.7.1
 */
import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList newList = new ArrayList();
        newList.add(1);
        newList.add(5);
        newList.add(3);
        newList.add(8);

        // newList.add("name") works if newList is declared with no type,
        // it results in an error if newList is an ArrayList<Integer>

        // display elements
        System.out.println(newList);

    }
}
