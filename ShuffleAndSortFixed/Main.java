class Main {

    public static void main(String[] args) {
        new Main().start();
    }

    public void start() {
        int[] nums;
        nums = fillArray(25, 10, 30);// fills nums with 25 numbers from 10 to 30
        System.out.println("Original nums array:");
        print(nums);
        int min = findMin(nums);
        System.out.println("Minimum element: " + min);
        int maxIndex = findMax(nums);
        System.out.println("Index of maximum element: " + maxIndex);
        int[] sorted = sort(nums);
        System.out.println("Sorted nums array:");
        print(sorted);
        shuffle(sorted);
        System.out.println("Re-shuffled nums array:");
        print(sorted);

    }

    // print the contents of nums
    public void print(int[] nums) {
        String arrayStr = "[";
        for (int i = 0; i < nums.length; i++) {
            arrayStr += nums[i];
            if (i != nums.length - 1) {
                arrayStr += ", ";
            }
        }
        arrayStr += "]";

        System.out.println(arrayStr);
    }

    // creates an array with n ints ranging from low to high inclusive
    // must use Math.random
    private int[] fillArray(int n, int low, int high) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            // generate a random number between high and low, inclusive:
            int randomNum = low + (int) (Math.random() * (high - low) + 1);
            // add the number to arr:
            arr[i] = randomNum;
        }

        return arr;
    }

    // returns the min element
    private int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        return min;
    }

    // returns the INDEX of the max element
    private int findMax(int[] nums) {
        int maxInd = 0;// start off with max at front
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxInd]) {
                maxInd = i;
            }
        }
        return maxInd;
    }

    // returns an array that has the element at specified index
    // removed from arr.
    // Assume arr has length > 0 and index is valid
    // 1 create a new array that is 1 element shorter
    // 2. copy over from arr to temp in the same index if
    // that index is less than input index
    private int[] removeElement(int index, int[] arr) {
        int[] newArr = new int[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            if (i < index) {
                newArr[i] = arr[i];
            }
            if (i > index) {
                newArr[i - 1] = arr[i];
            }
        }

        return newArr;
    }

    // sorts nums using the following algorithm:
    // 1. make a new array with the same length as nums.
    // 2. while nums has elements
    // find the max
    // place the max at the "end" of the new array from step 1
    // remove the max from nums
    // 3. nums has length 0, the new array will have the sorted
    // elements, so point nums at the new array
    private int[] sort(int[] nums) {
        int[] newArr = new int[nums.length];

        while (nums.length > 0) {
            int maxInd = findMax(nums);
            int maxNum = nums[maxInd];
            nums = removeElement(maxInd, nums);

            newArr[nums.length] = maxNum;
        }

        return newArr;
    }

    // shuffle the array using the following algorithm:
    // 1. find two random indexes
    // 2. swap the elements
    // 3. repeat a bunch of times.
    public void shuffle(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int a = (int) (Math.random() * nums.length);
            int b = (int) (Math.random() * nums.length);
            if (a == b) {
                i--;
                // continue;
            } else {
                int save = nums[a];
                nums[a] = nums[b];
                nums[b] = save;
            }

        }

    }
}
