import java.util.ArrayList;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        ArrayList<String> spaces1 = new ArrayList<>(Arrays.asList(
            "Trigger", null, "Silver", "Lady", null, "Patches", "Duke"
        ));

        consolidate(spaces1);

        System.out.println(spaces1);
    }

    /**
     * Consolidates the barn by moving horses so that the horses are in adjacent spaces, starting at
     * index 0, with no empty space between any two horses. Postcondition: The order of the horses
     * is the same as before the consolidation.
     */
    public static void consolidate(ArrayList<String> spaces) {
        int consolidatedHorses = 0;
        for (int i = 0; i < spaces.size(); i++) {
            if (spaces.get(i) != null) {
                if (i != consolidatedHorses) {
                    spaces.set(consolidatedHorses, spaces.get(i));
                    spaces.set(i, null);
                }
                consolidatedHorses++;
            }
        }
    }
}
