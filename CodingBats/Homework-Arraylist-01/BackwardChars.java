import java.util.List;
import java.util.ArrayList;

public class BackwardChars {
    /**
     * https://codingbat.com/prob/p247694
     * 
     * Given a string, return an array list that contains each character of the string in backwards
     * order.
     *
     * backwardChars("Career Center") → ["r", "e", "t", "n", "e", "C", " ", "r", "e", "e", "r", "a", "C"]
     * backwardChars("football") → ["l", "l", "a", "b", "t", "o", "o", "f"]
     * backwardChars("?") → ["?"]
     */

    // Solution to prompt:
    public List<String> backwardChars(String str) {
        ArrayList<String> reverseCharList = new ArrayList<>();
        for (int i = str.length(); i > 0; i--) {
            reverseCharList.add(str.substring(i - 1, i));
        }
        return reverseCharList;
    }
}
