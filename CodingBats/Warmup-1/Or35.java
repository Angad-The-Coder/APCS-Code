public class Or35 {
    /**
     * https://codingbat.com/prob/p112564
     * 
     * Return true if the given non-negative number is a multiple of 3 or a multiple of 5. Use the %
     * "mod" operator -- see [Introduction to
     * Mod](https://codingbat.com/doc/practice/mod-introduction.html)
     * 
     * or35(3) → true
     * or35(10) → true
     * or35(8) → false
     */

    // Solution to prompt:
    public boolean or35(int n) {
        return (n % 3 == 0 || n % 5 == 0);
    }
}
