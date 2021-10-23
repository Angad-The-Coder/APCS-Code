public class MonkeyTrouble {
    /**
     * https://codingbat.com/prob/p181646
     * 
     * We have two monkeys, a and b, and the parameters aSmile and bSmile indicate if each is
     * smiling. We are in trouble if they are both smiling or if neither of them is smiling. Return
     * true if we are in trouble.
     * 
     * monkeyTrouble(true, true) → true
     * monkeyTrouble(false, false) → true
     * monkeyTrouble(true, false) → false
     */

    // Solution to prompt:
    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        return true;
    }    

    // Method to test our solution on CodingBat's test cases:
    public void test() {
        System.out.println("monkeyTrouble(true, true) → " + monkeyTrouble(true, true));
        System.out.println("monkeyTrouble(false, false) → " + monkeyTrouble(false, false));
        System.out.println("monkeyTrouble(true, false) → " + monkeyTrouble(true, false));
    }
}
