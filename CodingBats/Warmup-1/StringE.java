public class StringE {
    /**
     * https://codingbat.com/prob/p173784
     * 
     * Return true if the given string contains between 1 and 3 'e' chars.
     * 
     * stringE("Hello") → true
     * stringE("Heelle") → true
     * stringE("Heelele") → false
     */

    // Solution to prompt:
    public boolean stringE(String str) {
        int eCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i+1).equals("e")) {
                eCount++;
            }
        }
        return (eCount >= 1 && eCount <= 3);
    }
}
