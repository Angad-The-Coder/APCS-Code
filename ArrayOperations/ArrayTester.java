import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ArrayTester {
    private int[] nums;
    public static void main(String[] args){
        ArrayTester at = new ArrayTester();
        at.makeRandoms();
        at.print();
        int min = at.findMin();
        int max = at.findMax();
        System.out.println("The min is: "+min+ " and the max is: "+max);

        double mean = at.findMean();
        System.out.println("The mean is: "+mean);
        
        int[] modes = at.findModes();
        System.out.println("The modes are: "+Arrays.toString(modes));

        double median = at.findMedian();
        System.out.println("The median is: "+median);

        int odds = at.countOdds();
        System.out.println("The number of odd elements is: "+odds);

        double stdDev = at.calcStandardDev();
        System.out.println("The standard deviation is: "+stdDev);

        double pct = at.percentWithinStdDev(1);
        System.out.println("The percent within 1 standard deviation is: "+pct+"%");

    }
    /**
     * Print the contents of nums in a pretty way
     */
    private void print() {
        System.out.println("The array is:\n" + Arrays.toString(nums));
    }
    /**prompt the user for the number of elements, the min element and 
     * max element to create.  Then create an array with that number of 
     * elements randomly ranging from min to max value.  Assign that
     * array  to nums (private instance field)
     */
    private void makeRandoms() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter how many items you would like to have in nums:");
        int length = input.nextInt();
        System.out.println("Enter the smallest number you would like to have in nums:");
        int minNum = input.nextInt();
        System.out.println("Enter the largest number you would like to have in nums:");
        int maxNum = input.nextInt();

        input.close();

        nums = new int[length];
        for(int i=0; i<nums.length; i++){
            nums[i] = (int)(Math.random() * (maxNum - minNum) + minNum);
        }
    }
    /** find and return the minimum element in nums */
    private int findMin(){
        if (nums.length == 0) return 0;

        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) min = nums[i];
        }

        return min;
    }
    /** find and return the maximum element in nums */
    private int findMax(){
        if (nums.length == 0) return 0;

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
        }

        return max;
    }
    /** find and return the mean of the elements in nums */
    private double findMean(){
        if (nums.length == 0) return 0;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return (double) sum / nums.length;
    }
    /** find and return the mode(s) of the elements in nums 
     * @return an array with the modes.  If there is only one mode, the
     * array will have length 1
    */
    private int[] findModes(){
        // maps numbers to how many times they occur in nums:
        HashMap<Integer, Integer> numCount = new HashMap<>();
        
        // Find the highest count of any number(s) in nums (maxCount)
        // and how many numbers occur maxCount times (numOfModes):
        int maxCount = 0;
        int numOfModes = 0;
        for (int i = 0; i < nums.length; i++) {
            // Initialize the value of nums[i] with 0 if not
            // seen already; will be incremented soon:
            numCount.putIfAbsent(nums[i], 0);

            numCount.put(nums[i], numCount.get(nums[i]) + 1);
            if (numCount.get(nums[i]) > maxCount) {
                maxCount = numCount.get(nums[i]);
                numOfModes = 1;
            }
            else if (numCount.get(nums[i]) == maxCount) {
                numOfModes++;
            }
        }

        // Find entries in numCount that have a value of maxCount
        // and add them to a modes array
        int[] modes = new int[numOfModes];
        int modeIdx = 0;
        for (HashMap.Entry<Integer, Integer> entry : numCount.entrySet()) {
            if (entry.getValue() == maxCount) {
                modes[modeIdx] = entry.getKey();
                modeIdx++;
            }
        }

        // return the modes array:
        return modes;
    }
    /** find and return the median of the elements in nums 
     * Use the following algorithm:
     * 1.  starting with min, count how many times it occurs. 
     * 2.  If at any time you reach the halfway point of the array, you have    * 
     *     found the median (middle number)
     * 3.  In the case of an array with an even number of elements, then you 
     *     will return the mean of the two middle elements.
    */
    private double findMedian(){
        if (nums.length == 0) return 0;

        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        int midIdx = sortedNums.length / 2;

        if (sortedNums.length % 2 == 0) {
            return (double) (
                sortedNums[midIdx - 1] +
                sortedNums[midIdx]
            ) / 2;
        }

        return (double) sortedNums[midIdx];
    }
    private int countOdds(){
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                count++;
            }
        }

        return count;
    }
    /** Returns the standard deviation of the data set
     * Use the following algorithm:
     * 1. find the mean
     * 2. for each element - 
     *    a)  find the difference between the element 
     *        and the mean
     *    b)  square the difference
     *    c)  add the square to a running total
     * 3.  Take the running total of squares of differences 
     *     from the mean and divide by number of elements
     * 4.  Take the square root of that number, that is the 
     *     standard deviation.  So, return it!
    */
    private double calcStandardDev(){
        double mean = this.findMean();
        double stdDev = 0.0;
        for (int i = 0; i < nums.length; i++) {
            stdDev += Math.pow((nums[i] - mean), 2);
        }
        stdDev /= nums.length;

        return Math.sqrt(stdDev);
    }
    /** Returns the percent of data within the specified number
     * of standard deviations from the mean of the data set
     * Use the following algorithm:
     * 1. find the mean
     * 2. find the standard deviation
     * 3. calculate how far away an element has to be
     *    to be at least the specified number of standards
     *    of deviation
     * 4. for each element - 
     *    a)  check to see if it is within the specified number 
     *        of deviations.  If so, count it.
     * 
     * 5.  return the percent 
     *     (num within stds of dev / size of array * 100)
    */
    private double percentWithinStdDev(double devs){
        double mean = this.findMean();
        double stdDev = this.calcStandardDev();
        int numWithinStdDev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (
                nums[i] > (mean - devs * stdDev) &&
                nums[i] < (mean + devs * stdDev)
            ) numWithinStdDev++; 
        }

        return (double) numWithinStdDev / nums.length;
    }
}
