public class MixStart {
    /**
     * https://codingbat.com/prob/p151713
     * 
     * Return true if the given string begins with "mix", except the 'm' can be anything, so "pix",
     * "9ix" .. all count.
     * 
     * mixStart("mix snacks") → true
     * mixStart("pix snacks") → true
     * mixStart("piz snacks") → false
     */

    // Solution to prompt:
    public boolean mixStart(String str) {
        // check str length's is >= 3 to prevent an out of bounds error:
        return (str.length() >= 3 && str.substring(1, 3).equals("ix"));
    }
}
