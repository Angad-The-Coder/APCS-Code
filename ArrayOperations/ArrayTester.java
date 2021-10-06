import java.util.Arrays;
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

    }
    /**
     * Print the contents of nums in a pretty way
     */
    private void print() {

    }
    /**prompt the user for the number of elements, the min element and 
     * max element to create.  Then create an array with that number of 
     * elements randomly ranging from min to max value.  Assign that
     * array  to nums (private instance field)
     */
    private void makeRandoms() {
        System.out.println("Enter how many items you would like to have in nums:");

        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        input.close();

        nums = new int[length];
        for(int i=0; i<nums.length; i++){
            nums[i] = (int)(Math.random()*20+1);;
        }
    }
    /** find and return the minimum element in nums */
    private int findMin(){

        return 0;
    }
    /** find and return the maximum element in nums */
    private int findMax(){

        return 0;
    }
    /** find and return the mean of the elements in nums */
    private double findMean(){

        return 0;
    }
    /** find and return the mode(s) of the elements in nums 
     * Use the following algorith:
     * 1.  find the min and max elements
     * 2.  starting with the min, count how many times it occurred
     * 3.  if it is best so far, make it the mode
     * 4.  if it ties the best so far, "add" this element to the returned array
     * 5.  either way, go on to the next number until we pass up max
     * @return an array with the modes.  If there is only one mode, the
     * array will have length 1
    */
    private int[] findModes(){

        return null;
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

        return 0;
    }
    private int countOdds(){

        return 0;
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

        return 0;
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

        return 0;
    }
    

}
