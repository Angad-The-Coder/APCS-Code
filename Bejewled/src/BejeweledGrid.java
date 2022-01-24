import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class BejeweledGrid {
    /**
     * The 2D array of jewels
     */
    private Jewel[][] jewels;

    /** Offsets for drawing the grid of Jewels.  The entire grid will
     * be shifted to the right OFFSET_X and down OFFSET_Y
    */
    public static final int OFFSET_X = 40, OFFSET_Y = 20;
    
    // This can play sounds!  I have loaded up the sounds below
    private SoundPlayer sp = new SoundPlayer();

    private static final int NUM_TYPES = 1; 
    private int numdraws=0;
    
    
    
    public BejeweledGrid() {
        jewels = new Jewel[5][5];// just for testing, you will change dimensions
        this.refill();// refill method fills empty spaces
        ArrayList<String>fileList = new ArrayList<String>();
        String root = "../sounds/";
        fileList.add(root+"badmove.wav");//0
        fileList.add(root+"bomb explode.wav");//1
        fileList.add(root+"carddeal.wav");//2
        fileList.add(root+"cold wind.wav");//3
        fileList.add(root+"earthquake.wav");//4
        fileList.add(root+"gem hit.wav");//5
        fileList.add(root+"ice warning.wav");//6
        fileList.add(root+"rewind.wav");//7
        sp.loadFiles(fileList);
        for(int i = 0; i<fileList.size(); i++){// play them all to see if working... cacophony!
            sp.play(i);
        }
    }

    /** directs each Jewel to draw itself.  The Jewel knows its row
     * and column and can ask the grid for the offset info
     * @param g Graphics context onto which the Jewels will draw themselves
     */
    public void draw(Graphics g) {
        numdraws++;
        g.setColor(Color.red);
        for(int r = 0; r < this.jewels.length; r++) {
            for(int c = 0; c < jewels[r].length;c++) {
                Jewel j = jewels[r][c];
                if(j != null)
                    j.draw(g,r,c);
            }
        }

    }

    /** swaps the Jewels at the specified locations.  Also must
     * tell the Jewels to set their rows and cols appropriately.
     * @param r1 row of Jewel 1
     * @param c1 col of Jewel 1
     * @param r2 row of Jewel 2
     * @param c2 col of Jewel 2
     */
    public void swap(int r1, int c1, int r2, int c2) {
        Jewel temp = jewels[r1][c1];
        // more of course tell the Jewels they are changing locations
    }

    /**
     * Creates an ArrayList<Jewel> of all Jewels Locations that are part of a
     * three-in-a-row.  The same Jewel Location may appear in the List more than
     * once.
     * @return
     */
    public ArrayList<Location> _3InARows() {
        ArrayList<Location> list = _3InARowHor();
        list.addAll(_3InARowVert());
        return list;
    }

    /**
     * 
     * @return returns an ArrayList of Jewels that make up three or more in 
     *         a row vertically or an empty list if fewer than 3 in a row exist
     */
    private ArrayList<Location> _3InARowVert() {

        return null;
    }
    /**  
     * @return returns an ArrayList of Jewels that make up three or more in 
     *         a row horizontally or an empty list if fewer than 3 in a row exist
     */
    private ArrayList<Location> _3InARowHor() {
        ArrayList<Location> list = new ArrayList<> ();
        

        return list;
    }
    /**
     * This method drops all Jewels that should drop...
     * Basically, any Jewel that has no Jewel below it needs to 
     * be in a higher row.  Lots of ways to approach this.
     * One possible algorithm:
     * 	1. Start at bottom row.  If nothing there (null) then copy the jewel above it 
     * 	   into this location and delete the jewel above it (set to null).
     *  2. Do this for every location in this row.  
     *  3. After this row is done, move to a higher (smaller indexed) row
     * 	4. If any jewels moved down (a non-null moved to a null location), then there 
     *     may be more jewels that need to be dropped (think about a 3-in-a-row vertical).
     *     So a good strategy might be count the number that moved, if that number is greater 
     * 	   than 0, then drop again (recursive).  This is costly, but some might find it easier than a
     * 	   nested loop that is 3 layers deep.
     */
    public void drop() {

    }

    /**
     * Fill in any empty positions in the grid with randomly selected Jewel
     */
    public void refill() {

        jewels[0][0] = randomJewel();
        jewels[2][4] = randomJewel();
        
    }

    /**
     * Generates a random Jewel that will have its starting location
     * at the specified row and col.
     * @param r row where the Jewel will be placed
     * @param c col where the Jewel will be placed
     * @return random type of Jewel constructed at r,c
     */
    private Jewel randomJewel() {

        int t = (int) (Math.random()*this.NUM_TYPES);
        if(t == 0)
            return new Emerald();
        else
            return null;// this should never happen 
    }
    /**
     * This method is called by the game when a click has been made 
     * on the panel.  Must determine if the click makes sense (is it 
     * a valid location, is there a Jewel at the location, can that 
     * Jewel be clicked).  If it is the first click, then note it and
     * the next click will attempt a move (maybe).
     * @param me
     */
    public void justClicked(MouseEvent me) {
        // System.out.println(me);
        // System.out.println((me.getX()-OFFSET_X)/Jewel.SQUARE_SIZE);
        // System.out.println((me.getY()-OFFSET_Y)/Jewel.SQUARE_SIZE);
        sp.play(5);
    }

}
