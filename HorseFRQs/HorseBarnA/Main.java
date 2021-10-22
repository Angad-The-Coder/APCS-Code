class Main {
    public static void main(String[] args) {
        String[] spaces = {"Trigger", null, "Silver", "Lady", null, "Patches", "Duke"};

        // Should be 2.
        System.out
                .println("Silver appears in stall index " + findHorseSpace(spaces, "Silver") + ".");

        // Should be 0.
        System.out.println(
                "Trigger appears in stall index " + findHorseSpace(spaces, "Trigger") + ".");

        // Should be -1.
        System.out.println("Bubba appears in stall index " + findHorseSpace(spaces, "Bubba") + ".");
    }

    /**
     * Returns the index of the space that contains the horse with the specified name. *
     * Precondition: No two horses in the barn have the same name.
     * 
     * @param name the name of the horse to find
     * @return the index of the space containing the horse with the specified name; -1 if no horse
     *         with the specified name is in the barn.
     */
    public static int findHorseSpace(String[] spaces, String name) {
        for (int i = 0; i < spaces.length; i++) {
            if (spaces[i] != null && spaces[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
