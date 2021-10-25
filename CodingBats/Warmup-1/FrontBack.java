public class FrontBack {
    /**
     * https://codingbat.com/prob/p123384
     * 
     * Given a string, return a new string where the first and last chars have been exchanged.
     * 
     * frontBack("code") → "eodc"
     * frontBack("a") → "a"
     * frontBack("ab") → "ba"
     */

    // Solution to prompt:
    public String frontBack(String str) {
        // if the string only has one character (or less), just return it:
        if (str.length() <= 1) {
            return str;
        }
        String last = str.substring(str.length() - 1);
        String first = str.substring(0, 1);
        return last + str.substring(1, str.length() - 1) + first;
    }
}
