import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileProcessor {

    private ArrayList<Cereal> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new FileProcessor().exploreFile("Cereal.csv");

        processCereal(scan);

        exploreCereal();
    }

    private static void exploreCereal() {
        // for starters, find the Cereal with the most calories
        Cereal maxCal = findMaxCalories();
        System.out.println("The Cereal with the most calories per serving is: " + maxCal);

        // Now find other stuff like least calories, or highest fiber to protein ratio or lowest


        sortBySugar();
    }

    /**
     * Sort our list of cereal by sugar from least to most (or vice-versa)
     */
    private static void sortBySugar() {}

    /**
     * Find the Cereal with the most calories
     * 
     * @return the Cereal with the most calories
     */
    private static Cereal findMaxCalories() {
        return null;
    }

    /**
     * This method processes the Cereal objects that are represented in the file. Read the output to
     * see what info you will need to encapsulate in a Cereal object, then create an appropriate
     * Cereal class and then construct the Cereal objects represented by the cereals in the file and
     * place them into a list.
     * 
     * @param scan the Scanner that points to the file with the cereal info
     */
    private static void processCereal(Scanner scan) {
        if (scan == null) {
            System.out.println("I'm not falling for it.  Your file had a problem!!!");
            return;
        }
        while (scan.hasNext()) {
            String line = scan.nextLine();
            // System.out.println(line);

            Cereal c = new Cereal();
            // list.add(c);
            // rather than print it out, we want to make a new Cereal and then add it
            // to the list. Later we want to explore the List
        }
    }

    /**
     * This method returns a Scanner to the file with the specified name. BE SURE THE FILE is in a
     * relatively located place with the correct file name and type. In VS Code, the file should be
     * in a location relative to the folder you opened. If you didn't open a folder, start over by
     * opening a folder!!!!
     * 
     * @param the name of the file to open and scann
     * @return a Scanner that will scan the file with the specified name, or null if there was a
     *         problem
     */
    private Scanner exploreFile(String fname) {
        Scanner scan = null;
        try {
            File f = new File(fname);
            scan = new Scanner(f);

        } catch (Exception e) {
            System.err.println("Problem!!!");
            e.printStackTrace();
        }
        return scan;
    }

}
