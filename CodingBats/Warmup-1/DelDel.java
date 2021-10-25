public class DelDel {
    /**
     * https://codingbat.com/prob/p100905
     * 
     * Given a string, if the string "del" appears starting at index 1, return a string where that
     * "del" has been deleted. Otherwise, return the string unchanged.
     * 
     * delDel("adelbc") → "abc"
     * delDel("adelHello") → "aHello"
     * delDel("adedbc") → "adedbc"
     */

    // Solution to prompt:
    public String delDel(String str) {
        // the string's length must be >= 4 to prevent an out of bounds error when looking at the
        // substring between the first and fourth character:
        if (str.length() >= 4 && str.substring(1, 4).equals("del")) {
            return str.substring(0, 1) + str.substring(4);
        }
        return str;
    }
}
