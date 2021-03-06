public class Diff21 {
    /**
     * https://codingbat.com/prob/p116624
     * 
     * Given an int n, return the absolute difference between n and 21, except return double the
     * absolute difference if n is over 21.
     * 
     * diff21(19) → 2
     * diff21(10) → 11
     * diff21(21) → 0
     */

    // Solution to prompt:
    public int diff21(int n) {
        if (n <= 21) {
            // since n <= 21, 21 - n will not be negative:
            return 21 - n;
        }
        return 2 * (n - 21);
    }
}
