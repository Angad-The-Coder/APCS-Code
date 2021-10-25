public class StartHi {
    /**
     * https://codingbat.com/prob/p191022
     * 
     * Given a string, return true if the string starts with "hi" and false otherwise.
     * 
     * startHi("hi there") → true
     * startHi("hi") → true
     * startHi("hello hi") → false
     */

    // Solution to prompt:
    public boolean startHi(String str) {
        // check str's length is >= 2 to prevent an out of bounds error:
        return (str.length() >= 2 && str.substring(0, 2).equals("hi"));
    }
}
