public class SleepIn {
    /**
     * https://codingbat.com/prob/p187868
     * 
     * The parameter weekday is true if it is a weekday, and the parameter vacation is true if we
     * are on vacation. We sleep in if it is not a weekday or we're on vacation. Return true if we
     * sleep in.
     * 
     * sleepIn(false, false) --> true
     * sleepIn(true, false) --> false
     * sleepIn(false, true) --> true
     */

    // Solution to prompt:
    public boolean sleepIn(boolean weekday, boolean vacation) {
        return (!weekday || vacation);
    }

    // Method to test our solution on CodingBat's test cases:
    public void test() {
        System.out.println("sleepIn(false, false) --> " + sleepIn(false, false));
        System.out.println("sleepIn(true, false) --> " + sleepIn(true, false));
        System.out.println("sleepIn(false, true) --> " + sleepIn(false, false));
    }
}
