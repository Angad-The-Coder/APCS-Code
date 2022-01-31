import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;

public class BejeweledGrid {
    /**
     * The 2D array of jewels
     */
    public Jewel[][] jewels;

    /**
     * Offsets for drawing the grid of Jewels. The entire grid will be shifted to the right OFFSET_X
     * and down OFFSET_Y
     */
    public static final int OFFSET_X = 40, OFFSET_Y = 20, BOARD_WIDTH = 10, BOARD_HEIGHT = 10;
    private Location selectedLocation;
    private long lastClearMillis = 0;
    private int comboLength;
    private static final int COMBO_THRESHOLD_MILLIS = 1600;
    private SoundPlayer sp = new SoundPlayer();
    private static final int NUM_TYPES = 7;

    public BejeweledGrid() {
        jewels = new Jewel[BOARD_HEIGHT][BOARD_WIDTH];// just for testing, you will change
                                                      // dimensions
        this.refill();// refill method fills empty spaces
        ArrayList<String> fileList = new ArrayList<String>();
        String root = "../sounds/";
        fileList.add(root + "badmove.wav");// 0
        fileList.add(root + "bomb explode.wav");// 1
        fileList.add(root + "carddeal.wav");// 2
        fileList.add(root + "cold wind.wav");// 3
        fileList.add(root + "earthquake.wav");// 4
        fileList.add(root + "gem hit.wav");// 5
        fileList.add(root + "ice warning.wav");// 6
        fileList.add(root + "rewind.wav");// 7
        fileList.add(root + "combo 2.wav"); // 8
        fileList.add(root + "combo 3.wav"); // 9
        fileList.add(root + "combo 4.wav"); // 10
        fileList.add(root + "combo 5.wav"); // 11
        fileList.add(root + "combo 6.wav"); // 12
        fileList.add(root + "combo 7.wav"); // 13
        sp.loadFiles(fileList);
    }

    /**
     * directs each Jewel to draw itself. The Jewel knows its row and column and can ask the grid
     * for the offset info
     * 
     * @param g Graphics context onto which the Jewels will draw themselves
     */
    public void draw(Graphics g) {
        // numdraws++;
        g.setColor(Color.red);
        // g.drawString("TESTING! Remove this! Num of draws "+numdraws,30,200 );
        for (int r = 0; r < this.jewels.length; r++) {
            for (int c = 0; c < jewels[r].length; c++) {
                Jewel j = jewels[r][c];
                if (j == null)
                    continue;
                j.draw(g, r, c);
            }
        }

    }

    /**
     * swaps the Jewels at the specified locations. Also must tell the Jewels to set their rows and
     * cols appropriately.
     * 
     * @param r1 row of Jewel 1
     * @param c1 col of Jewel 1
     * @param r2 row of Jewel 2
     * @param c2 col of Jewel 2
     */
    public void swap(int r1, int c1, int r2, int c2) {
        Jewel temp = jewels[r1][c1];
        jewels[r1][c1] = jewels[r2][c2];
        jewels[r2][c2] = temp;
        // more of course tell the Jewels they are changing locations
    }

    /**
     * Creates an ArrayList<Jewel> of all Jewels Locations that are part of a three-in-a-row. The
     * same Jewel Location may appear in the List more than once.
     * 
     * @return
     */
    public ArrayList<Location> _3InARows() {
        ArrayList<Location> list = _3InARowHor();
        list.addAll(_3InARowVert());
        return list;
    }

    /**
     * 
     * @return returns an ArrayList of Jewels that make up three or more in a row vertically or an
     *         empty list if fewer than 3 in a row exist
     */
    private ArrayList<Location> _3InARowVert() {
        // using hashset to make sure there are no duplicates
        HashSet<Location> locations = new HashSet<Location>();
        for (int i = 0; i < jewels.length - 2; i++) {
            for (int x = 0; x < jewels[0].length; x++) {
                Jewel first = jewels[i][x];
                Jewel second = jewels[i + 1][x];
                Jewel third = jewels[i + 2][x];
                if (!first.equals(second) || !second.equals(third))
                    continue;
                for (int j = 0; j < 3; j++) {
                    Location currentLocation = new Location(i + j, x);
                    locations.add(currentLocation);
                }
            }
        }
        return new ArrayList<Location>(locations);
    }

    /**
     * @return returns an ArrayList of Jewels that make up three or more in a row horizontally or an
     *         empty list if fewer than 3 in a row exist
     */
    private ArrayList<Location> _3InARowHor() {
        // using hashset to make sure there are no duplicates
        HashSet<Location> locations = new HashSet<Location>();
        for (int i = 0; i < jewels.length; i++) {
            for (int x = 0; x < jewels[0].length - 2; x++) {
                Jewel first = jewels[i][x];
                Jewel second = jewels[i][x + 1];
                Jewel third = jewels[i][x + 2];
                if (!first.equals(second) || !second.equals(third))
                    continue;
                for (int j = 0; j < 3; j++) {
                    Location currentLocation = new Location(i, x + j);
                    locations.add(currentLocation);
                }
            }
        }
        return new ArrayList<Location>(locations);
    }

    /**
     * This method drops all Jewels that should drop... Basically, any Jewel that has no Jewel below
     * it needs to be in a higher row. Lots of ways to approach this. One possible algorithm: 1.
     * Start at bottom row. If nothing there (null) then copy the jewel above it into this location
     * and delete the jewel above it (set to null). 2. Do this for every location in this row. 3.
     * After this row is done, move to a higher (smaller indexed) row 4. If any jewels moved down (a
     * non-null moved to a null location), then there may be more jewels that need to be dropped
     * (think about a 3-in-a-row vertical). So a good strategy might be count the number that moved,
     * if that number is greater than 0, then drop again (recursive). This is costly, but some might
     * find it easier than a nested loop that is 3 layers deep.
     */
    public void drop() {
        for (int i = jewels.length - 1; i > 0; i--) {
            for (int x = 0; x < jewels[0].length; x++) {
                Jewel current = jewels[i][x];
                if (current != null)
                    continue;
                int replacedRow = i - 1;
                while (replacedRow > 0 && jewels[replacedRow][x] == null)
                    replacedRow--;
                swap(replacedRow, x, i, x);
            }
        }
    }

    /**
     * Fill in any empty positions in the grid with randomly selected Jewel
     */
    public void refill() {
        for (int i = 0; i < jewels.length; i++) {
            for (int x = 0; x < jewels[0].length; x++) {
                if (jewels[i][x] != null)
                    continue;
                Jewel filled = randomJewel();
                // TODO: make readable/better
                // all of this just makes sure the generated board
                // doesn't contain 3 in a rows when refilling
                if (x != 0) {
                    Jewel left = jewels[i][x - 1];
                    if (i == 0) {
                        while (filled.equals(left))
                            filled = randomJewel();
                    } else {
                        Jewel above = jewels[i - 1][x];
                        while (filled.equals(left) || filled.equals(above))
                            filled = randomJewel();
                    }
                } else {
                    if (i == 0)
                        filled = randomJewel();
                    else {
                        Jewel above = jewels[i - 1][x];
                        while (filled.equals(above))
                            filled = randomJewel();
                    }
                }
                jewels[i][x] = filled;
            }
        }
    }

    /**
     * Generates a random Jewel that will have its starting location at the specified row and col.
     * 
     * @param r row where the Jewel will be placed
     * @param c col where the Jewel will be placed
     * @return random type of Jewel constructed at r,c
     */
    private Jewel randomJewel() {
        int t = (int) (Math.random() * BejeweledGrid.NUM_TYPES);
        switch (t) {
            case 0:
                return new Yellow();
            case 1:
                return new White();
            case 2:
                return new Blue();
            case 3:
                return new Red();
            case 4:
                return new Purple();
            case 5:
                return new Orange();
            default:
                return new Emerald();
        }
    }

    /**
     * This method is called by the game when a click has been made on the panel. Must determine if
     * the click makes sense (is it a valid location, is there a Jewel at the location, can that
     * Jewel be clicked). If it is the first click, then note it and the next click will attempt a
     * move (maybe).
     * 
     * @param me
     */
    private void delete(ArrayList<Location> matches) {
        for (Location match : matches) {
            jewels[match.getRow()][match.getCol()] = null;
        }
    }

    private void playMatchSound() {
        if (lastClearMillis == 0) {
            sp.play(5);
            lastClearMillis = System.currentTimeMillis();
        } else {
            long currentTime = System.currentTimeMillis();
            long timeDifference = currentTime - lastClearMillis;
            lastClearMillis = currentTime;
            System.out.println(timeDifference);
            if (timeDifference <= BejeweledGrid.COMBO_THRESHOLD_MILLIS) {
                if (comboLength < 6)
                    sp.play(8 + (comboLength % 6));
                else
                    sp.play(14);
                comboLength++;
            } else {
                sp.play(5);
                comboLength = 0;
            }
        }
    }

    public int justClicked(MouseEvent me) {
        int gemsCleared = 0;
        int row = (me.getY() - OFFSET_Y) / Jewel.SQUARE_SIZE;
        int col = (me.getX() - OFFSET_X) / Jewel.SQUARE_SIZE;
        if (row < 0 || row >= BOARD_HEIGHT || col < 0 || col >= BOARD_WIDTH)
            return 0;
        if (selectedLocation == null) {
            selectedLocation = new Location(row, col);
            jewels[row][col].selected = true;
        } else {
            int selectedRow = selectedLocation.getRow();
            int selectedCol = selectedLocation.getCol();
            jewels[selectedRow][selectedCol].selected = false;
            if (Math.abs(selectedRow - row) == 1 ^ Math.abs(selectedCol - col) == 1) {
                swap(row, col, selectedRow, selectedCol);
                ArrayList<Location> matches = _3InARows();
                gemsCleared = matches.size();
                if (matches.size() == 0) {
                    swap(row, col, selectedRow, selectedCol);
                    sp.play(0);
                    return 0;
                }
                while (matches.size() != 0) {
                    delete(matches);
                    drop();
                    refill();
                    matches = _3InARows();
                }
                playMatchSound();
            }
            selectedLocation = null;
        }
        return gemsCleared;
    }
}
