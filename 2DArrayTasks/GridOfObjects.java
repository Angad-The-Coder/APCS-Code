import java.util.Arrays;

public class GridOfObjects {
    public static void main(String[] args) {
        Thing[][] one = new Thing[][] {{new Thing(1, 2), new Thing(2, 0), null, null},
                {null, new Thing(3, 2), new Thing(2, 2), null},
                {null, new Thing(2, 2), new Thing(4, 3), new Thing(1, 1)}};
        // Each object has a value, direction

        int total = GridOfObjects.sumFacing(one, 2);
        System.out.println("Sum of Things facing 2 (should be 8):" + total);
        total = GridOfObjects.sumFacing(one, 3);
        System.out.println("Sum of Things facing 3 (should be 4):" + total);

        System.out.println("\n---\n");

        GridOfObjects.assignNeighbors(one);
        Thing[] n = one[1][1].getNeighbors();
        System.out.println("Neighbors of Thing at row = 1, col = 1:");
        System.out.println(Arrays.toString(n));

        System.out.println("\n---\n");

        System.out.println("Moving the following 2D array North:");
        print(one);
        GridOfObjects.moveEverybody(one, 0);// moves all North
        System.out.println("Here is what it looks like after moving:");
        print(one);
    }

    /**
     * returns the sum of all the num values of every Thing Object whose direction matches the
     * specified dir.
     */
    public static int sumFacing(Thing[][] grid, int dir) {
        int facingDirNumSum = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] != null && grid[row][col].getDirection() == dir) {
                    facingDirNumSum += grid[row][col].getNum();
                }
            }
        }
        return facingDirNumSum;
    }

    /**
     * Visits each element of the 2D array of Thing Objects. Assigns the neighboring Things in the
     * 2Darray to the appropriate index of neighbors (found in the thing object). If a Thing is to
     * the North, then the Thing is placed in index 0 of the array. If there is no neighbor to the
     * North, then index 0 should be null. If there is no neighbor to the East, then index 1 is
     * null, etc.
     */

    // Neighbor array is in the thing class
    public static void assignNeighbors(Thing[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] != null) {
                    Thing[] neighbors = new Thing[4]; // 4 nulls
                    if (row > 0) {
                        // add a northern neighbor if it's not out of bounds:
                        neighbors[0] = grid[row - 1][col];
                    }
                    if (col < grid[row].length - 1) {
                        // add an eastern neighbor if it's not out of bounds:
                        neighbors[1] = grid[row][col + 1];
                    }
                    if (row < grid.length - 1) {
                        // add a southern neighbor if it's not out of bounds:
                        neighbors[2] = grid[row + 1][col];
                    }
                    if (col > 0) {
                        // add a western neighbor if it's not out of bounds:
                        neighbors[3] = grid[row][col - 1];
                    }
                    // update the Thing with this array of neighbors:
                    grid[row][col].setNeighbors(neighbors);
                }
            }
        }

    }

    /**
     * @param dir This is the direction that all Thing objects should be moved in the 2D array
     *        according to the following rules: if dir == 0, all Thing objects move to the North, if
     *        a Thing is in row 0, it is moved to the bottom. If dir == 1, all Thing objects are
     *        moved to the East. Things in the last col are moved to col 0. If dir == 2, all Things
     *        are moved to the South. Things in the bottom row are moved to the top. If dir == 3,
     *        all Things are moved to the West. Things in the left col are moved to the last column.
     */
    public static void moveEverybody(Thing[][] grid, int dir) {
        if (dir == 0) {
            // save the initial state of the top row as an array:
            Thing[] topRow = new Thing[grid[0].length];
            // notice we cannot do topRow = grid[0] as this simply *points* to whatever value is held
            // in grid[0] at the time topRow is evaluated:
            for (int col = 0; col < grid[0].length; col++) {
                topRow[col] = grid[0][col];
            }
            for (int row = 1; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {
                    // move all Things not in the topmost row up 1 row
                    grid[row - 1][col] = grid[row][col];
                }
            }
            // using topRow, move all Things that *were* in the top row to the bottom row:
            for (int col = 0; col < topRow.length; col++) {
                grid[grid.length - 1][col] = topRow[col];
            }
        }
        if (dir == 1) {
            // save the initial state of the right column as an array:
            Thing[] rightCol = new Thing[grid.length];
            for (int row = 0; row < grid.length; row++) {
                rightCol[row] = grid[row][grid[row].length - 1];
                for (int col = grid[row].length - 2; col >= 0; col--) {
                    // move all Things not in the rightmost column right 1 column:
                    grid[row][col + 1] = grid[row][col];
                }
            }
            // using rightCol, move all Things that *were* in the right column to the left column:
            for (int row = 0; row < rightCol.length; row++) {
                grid[row][0] = rightCol[row];
            }
        }
        if (dir == 2) {
            // save the initial state of the bottom row as an array:
            Thing[] botRow = new Thing[grid[grid.length - 1].length];
            // notice we cannot do botRow = grid[grid.length - 1] as this simply *points* to whatever
            // value is held in grid[grid.length - 1] at the time botRow's value is evaluated:
            for (int col = 0; col < grid[grid.length - 1].length; col++) {
                botRow[col] = grid[grid.length - 1][col];
            }
            for (int row = grid.length - 2; row >= 0; row--) {
                for (int col = 0; col < grid[row].length; col++) {
                    // move all Things not in the bottommost row down 1 row
                    grid[row + 1][col] = grid[row][col];
                }
            }
            // using botRow, move all Things that *were* in the bottom row to the rop row:
            for (int col = 0; col < botRow.length; col++) {
                grid[0][col] = botRow[col];
            }
        }
        if (dir == 3) {
            // save the initial state of the left column as an array:
            Thing[] leftCol = new Thing[grid.length];
            for (int row = 0; row < grid.length; row++) {
                leftCol[row] = grid[row][0];
                for (int col = 1; col < grid[row].length - 1; col++) {
                    // move all Things not in the leftmost column left 1 column:
                    grid[row][col - 1] = grid[row][col];
                }
            }
            // using leftCol, move all Things that *were* in the left column to the right column:
            for (int row = 0; row < leftCol.length; row++) {
                grid[row][grid.length - 1] = leftCol[row];
            }
        }
    }

    public static void print(Thing[][] grid) {
        for (Thing[] arr : grid) {
            for (Thing t : arr) {
                System.out.print(t + "  --  ");
            }
            System.out.println();
        }
    }
}
