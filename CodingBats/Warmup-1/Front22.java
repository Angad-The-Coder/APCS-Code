public class Front22 {
    /**
     * https://codingbat.com/prob/p183592
     * 
     * Given a string, take the first 2 chars and return the string with the 2 chars added at both
     * the front and back, so "kitten" yields"kikittenki". If the string length is less than 2, use
     * whatever chars are there.
     * 
     * front22("kitten") → "kikittenki"
     * front22("Ha") → "HaHaHa"
     * front22("abc") → "ababcab"
     */

    // Solution to prompt:
    public String front22(String str) {
        String frontTwo = str; // default value if str's length is <= 2
        if (str.length() > 2) {
            frontTwo = str.substring(0, 2);
        }
        return frontTwo + str + frontTwo;
    }
}
