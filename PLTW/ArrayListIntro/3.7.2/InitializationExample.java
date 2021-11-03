import java.util.ArrayList;
import java.util.Arrays;

public class InitializationExample {
    public static void main(String[] args) {
        // initialize using Arrays.asList:
        ArrayList<String> animals = new ArrayList<>(
            Arrays.asList("Pig", "Cow", "Chicken")
        );
    
        System.out.println(animals);
    }
}
