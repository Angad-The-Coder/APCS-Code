public class Max1020 {
    /**
     * https://codingbat.com/prob/p177372
     * 
     * Given 2 positive int values, return the larger value that is in the range 10..20 inclusive,
     * or return 0 if neither is in that range.
     * 
     * max1020(11, 19) → 19
     * max1020(19, 11) → 19
     * max1020(11, 9) → 11
     */

    // Solution to prompt:
    public int max1020(int a, int b) {
        // make a the bigger value:
        if (b > a) {
            // swap b and a if b is bigger:
            int temp = a;
            a = b;
            b = temp;
        }
        // return whichever number is in the range, checking a first
        if (a >= 10 && a <= 20) {
            return a;
        }
        if (b >= 10 && b <= 20) {
            return b;
        }
        // return 0 if neither are in the range:
        return 0;
    }
}
