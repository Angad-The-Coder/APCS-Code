public class IntMax {
    /**
     * https://codingbat.com/prob/p101887
     * 
     * Given three int values, a b c, return the largest.
     * 
     * intMax(1, 2, 3) → 3
     * intMax(1, 3, 2) → 3
     * intMax(3, 2, 1) → 3
     */

    // Solution to prompt:
    public int intMax(int a, int b, int c) {
        if (a > b) {
            if (a > c) {
                // a > b and a > c:
                return a;
            }
            // c > a > b:
            return c;
        }
        if (b > c) {
            // b > a and b > c:
            return b;
        }
        // c > b > a:
        return c;
    }
}
