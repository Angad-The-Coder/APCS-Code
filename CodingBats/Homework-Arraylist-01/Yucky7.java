import java.util.List;

public class Yucky7 {
    /**
     * https://codingbat.com/prob/p233744
     * 
     * Return the sum of the numbers in the array list. Except the number 7 is yucky, so it does not
     * count and numbers that come immediately after a 7 also do not count.
     * 
     * yucky7([1, 4]) → 5
     * yucky7([1, 2, 7, 3]) → 3
     * yucky7([1, 7, 8, 5, 7]) → 6
     */

    // Solution to prompt:
    public int yucky7(List<Integer> numsList) {
        int sum = 0;
        for (int i = 0; i < numsList.size(); i++) {
            if (numsList.get(i) != 7 && (i == 0 || numsList.get(i - 1) != 7)) {
                sum += numsList.get(i);
            }
        }
        return sum;
    }
}
