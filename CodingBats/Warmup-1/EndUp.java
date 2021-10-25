public class EndUp {
    /**
     * https://codingbat.com/prob/p125268
     * 
     * Given a string, return a new string where the last 3 chars are now in upper case. If the
     * string has less than 3 chars, uppercase whatever is there. Note that str.toUpperCase()
     * returns the uppercase version of a string.
     * 
     * endUp("Hello") → "HeLLO"
     * endUp("hi there") → "hi thERE"
     * endUp("hi") → "HI"
     */

    // Solution to prompt:
    public String endUp(String str) {
        if (str.length() > 3) {
            // substring of the characters leading up to the last three:
            String beginning = str.substring(0, str.length() - 3);
            // substring of the last three characters:
            String lastThree = str.substring(str.length() - 3);
            return beginning + lastThree.toUpperCase();
        }
        // if the length of str is <= 3, just return its uppercase version:
        return str.toUpperCase();
    }
}
