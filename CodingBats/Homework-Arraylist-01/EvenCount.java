import java.util.List;

public class EvenCount {
    /**
     * https://codingbat.com/prob/p255993
     * 
     * Return the count of all the even numbers in the array list. Hint: The % operator may be
     * useful.
     * 
     * evenCount([1, 2, 3, 4]) → 2
     * evenCount([8, 16, 10]) → 3
     * evenCount([5, 0, 22]) → 2
     */

    // Solution to prompt:
    public int evenCount(List<Integer> numsList) {
        int count = 0;
        for (int i = 0; i < numsList.size(); i++) {
            if (numsList.get(i) % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
