public class NotString {
    /**
     * https://codingbat.com/prob/p191914
     * 
     * Given a string, return a new string where "not " has been added to the front. However, if the
     * string already begins with "not", return the string unchanged. Note: use .equals() to compare
     * 2 strings.
     * 
     * notString("candy") → "not candy"
     * notString("x") → "not x"
     * notString("not bad") → "not bad"
     */

    // Solution to prompt:
    public String notString(String str) {
        // check str's length is >= 3 to prevent an out of bounds error:
        if (str.length() >= 3 && str.substring(0, 3).equals("not")) {
            return str;
        }
        return "not " + str;
    }
}
