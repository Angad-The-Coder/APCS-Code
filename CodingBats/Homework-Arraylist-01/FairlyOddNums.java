import java.util.List;

public class FairlyOddNums {
    /**
     * https://codingbat.com/prob/p236129
     * 
     * Return the sum of the numbers in the array list that are odd and have an even index, or the
     * number is even and its index is odd.
     * 
     * fairlyOddNums([1, 2, 3, 4]) → 10
     * fairlyOddNums([8, 16, 10]) → 16
     * fairlyOddNums([5, 0, 13, 51]) → 18
     */

    // Solution to prompt:
    public int fairlyOddNums(List<Integer> numsList) {
        int sum = 0;
        for (int i = 0; i < numsList.size(); i++) {
            int n = numsList.get(i);
            if ((i % 2 == 0 && n % 2 == 1) || (i % 2 == 1 && n % 2 == 0)) {
                sum += n;
            }
        }
        return sum;
    }
}
