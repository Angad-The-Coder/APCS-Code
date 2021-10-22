import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        String[] spaces1 = {"Trigger", null, "Silver", "Lady", null, "Patches", "Duke"};

        consolidate(spaces1);

        System.out.println(Arrays.toString(spaces1));
    }

    /**
     * Consolidates the barn by moving horses so that the horses are in adjacent spaces, starting at
     * index 0, with no empty space between any two horses. Postcondition: The order of the horses
     * is the same as before the consolidation.
     */
    public static void consolidate(String[] spaces) {
        int consolidatedHorses = 0;
        for (int i = 0; i < spaces.length; i++) {
            if (spaces[i] != null) {
                if (i != consolidatedHorses) {
                    spaces[consolidatedHorses] = spaces[i];
                    spaces[i] = null;
                }
                consolidatedHorses++;
            }
        }
    }
}
