import java.util.Arrays;

public class SumRowsAndCols {

    /**
     * This method returns the sum of the elements in the specified row of the specified 2D array.
     * If the 2D array is null, or if the row is out of bounds, you should return 0.
     */
    public static int sumRow(final int[][] grid, final int row) {
        int rowSum = 0;
        if (grid != null && row >= 0 && row < grid.length) {
            for (int col = 0; col < grid[row].length; col++) {
                rowSum += grid[row][col];
            }
        }
        return rowSum;
    }

    /**
     * This method returns the sum of the elements in the specified col of the specified 2D array.
     * If the 2D array is null, or if the col is out of bounds of any row, you should return 0.
     */
    public static int sumCol(final int[][] grid, final int col) {
        int colSum = 0;
        if (col < 0) {
            return 0;
        }
        if (grid != null) {
            for (int row = 0; row < grid.length; row++) {
                if (col < grid[row].length) {
                    colSum += grid[row][col];
                } else {
                    return 0;
                }
            }
        }
        return colSum;
    }

    /**
     * Given an int[] array "arr" and a int "num" to add to it, extend arr to include num at the
     * end. This is similar to the ArrayList.add() method except it works for primitive arrays.
     */
    public static void addIntToArray(int[] arr, int num) {
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[newArr.length - 1] = num;
    }

    /**
     * This method returns the index of the row with the maximum sum. If there is a tie for the
     * maximum, the index of any row with that maximum sum can be returned. Return null if the 2D
     * array is empty. In answering this, you MUST call sumRow from above.
     */
    public static int[] maxSumRow(final int[][] grid) {
        if (grid.length == 0) {
            // Return null if the 2D array is empty
            return null;
        }
        // initially, assume the first row has the largest sum:
        int[] maxRows = {0};
        int maxRowSum = sumRow(grid, 0);
        // go through the other rows in the array and find the real maximum:
        for (int row = 1; row < grid.length; row++) {
            int currRowSum = sumRow(grid, row);
            if (currRowSum > maxRowSum) {
                // if a new maximum row sum is found, recreate the maxRows array to solely include
                // this new row, and update maxRowSum with its sum.
                maxRows = new int[1];
                maxRows[0] = row;
                maxRowSum = currRowSum;
            } else if (currRowSum == maxRowSum) {
                // if a row ties with the maximum row sum, add it to the maxRows array as well:
                addIntToArray(maxRows, row);
            }
        }
        return maxRows;
    }

    /**
     * This method returns the index of the col with the maximum sum. If there is a tie for the
     * maximum, the index of any col with that maximum sum can be returned. Return null if the 2D
     * array is empty. In answering this, you MUST use the method sumCol from above
     */
    public static int[] maxSumCol(final int[][] grid) {
        if (grid.length == 0) {
            // Return null if the 2D array is empty
            return null;
        }
        int colWidth = grid[0].length;
        // initially, assume the first column has the largest sum:
        // (we do not need to confirm whether a column actually exists since the sumCol method does
        // that for us)
        int maxColSum = sumCol(grid, 0);
        int[] maxCols = {0};
        // go through the other columns in the array and find the real maximum:
        for (int col = 1; col < colWidth; col++) {
            int currColSum = sumCol(grid, col);
            if (currColSum > maxColSum) {
                // if a new maximum col sum is found, recreate the maxCols array to solely include
                // this new col, and update maxColSum with its sum.
                maxCols = new int[1];
                maxCols[0] = col;
                maxColSum = currColSum;
            } else if (currColSum == maxColSum) {
                // if a col ties with the maximum col sum, add it to the maxCols array as well:
                addIntToArray(maxCols, col);
            }
        }
        return maxCols;
    }

    public static void main(final String[] args) {
        int[][] one = new int[][] {{1, 2, 3}, {2, 3, 4}, {3, 4, 5}};
        int[][] two = new int[][] {{1, 2, 3, 0}, {2, 3, 4, 1}, {3, 4, 5, 2}};
        int[][] three = new int[][] {{1, 2, 3}, {14, 1, 4}, {3, 4, 5}};// make rectangular
        System.out.println("Checking sums of rows");
        int sum = SumRowsAndCols.sumRow(one, 0);
        System.out.println("Should be 6: " + sum);
        sum = SumRowsAndCols.sumRow(two, 1);
        System.out.println("Should be 10: " + sum);
        sum = SumRowsAndCols.sumRow(one, -1);
        System.out.println("Should be 0: " + sum);
        sum = SumRowsAndCols.sumRow(one, 4);
        System.out.println("Should be 0: " + sum);

        System.out.println("Checking sums of cols");
        sum = SumRowsAndCols.sumCol(two, 3);
        System.out.println("Should be 3: " + sum);
        sum = SumRowsAndCols.sumCol(one, -1);
        System.out.println("Should be 0: " + sum);
        // sum = SumRowsAndCols.sumCol(three, 2);
        // System.out.println("Should be 0: "+sum);
        sum = SumRowsAndCols.sumCol(three, 1);
        System.out.println("Should be 7: " + sum);

        System.out.println("Checking index of sums of rows and cols");
        int[] ind = SumRowsAndCols.maxSumRow(three);
        System.out.println("Should be [1]: " + Arrays.toString(ind));
        ind = SumRowsAndCols.maxSumRow(two);
        System.out.println("Should be [2]: " + Arrays.toString(ind));
        ind = SumRowsAndCols.maxSumCol(three);
        System.out.println("Should be [0]: " + Arrays.toString(ind));
        ind = SumRowsAndCols.maxSumCol(two);
        System.out.println("Should be [2]: " + Arrays.toString(ind));
    }
}
