import java.util.List;

public class SumEvenIndexes {
    /**
     * https://codingbat.com/prob/p254470
     * 
     * Return the sum of all the numbers at even positions in the array list.
     * 
     * sumEvenIndexes([1, 2, 3, 4]) → 4
     * sumEvenIndexes([8, 16, 10]) → 18
     * sumEvenIndexes([5, 0, -10]) → -5
     */

    // Solution to prompt:
    public int sumEvenIndexes(List<Integer> numsList) {
        int sum = 0;
        for (int i = 0; i < numsList.size(); i += 2) {
            sum += numsList.get(i);
        }
        return sum;
    }
}
