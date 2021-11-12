import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class FileProcessor {

    private static ArrayList<Cereal> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new FileProcessor().exploreFile("Cereal.csv");

        processCereal(scan);

        exploreCereal();
    }

    private static void exploreCereal() {
        // find the cereal with the most calories
        ArrayList<Cereal> maxCalCereals = findMaxCalories();
        System.out.println("The cereal(s) with the most calories per serving:");
        for (Cereal c : maxCalCereals) {
            System.out.println(c);
        }

        // find the cereal with the least calories
        ArrayList<Cereal> minCalCereals = findMinCalories();
        System.out.println("The cereal(s) with the least calories per serving:");
        for (Cereal c : minCalCereals) {
            System.out.println(c);
        }

        // find highest fiber to protein ratio
        ArrayList<Cereal> maxFPRatioCereals = findMaxFPRatio();
        System.out.println("The cereal(s) with the highest fiber to protein ratios:");
        for (Cereal c : maxFPRatioCereals) {
            System.out.println(c);
        }

        // print out the cereals sorted by amount of sugar per serving:
        sortBySugar();
        System.out.println("The cereals sorted by their amount of sugar per serving:");
        // print a single line list (using the Cereal toString() method for each cereal would
        // clutter the console):
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            Cereal c = list.get(i);
            if (i != list.size() - 1) {
                // print a trailing comma for each "middle" item in the list:
                System.out.print(c.getName() + " (" + c.getSugar() + "g), ");
            } else {
                // print a trailing closing bracket for the last item in the list:
                System.out.print(c.getName() + " (" + c.getSugar() + "g)]");
            }
        }
    }

    /**
     * Sort our list of cereal by sugar from least to most. Since the compareTo() method of the
     * Cereal class, which inherits from the Comparable interface, has been overrided to compare the
     * sugar amounts of two cereals, sorting by sugar can easily be achieved via Collections.sort().
     */
    private static void sortBySugar() {
        Collections.sort(list);
    }

    /**
     * Find the Cereals with the most calories as an ArrayList.
     * 
     * @return the Cereal with the most calories as an ArrayList.
     */
    private static ArrayList<Cereal> findMaxCalories() {
        // initialize maxCal as the number of calories of the first cereal and initialize
        // maxCalCereals with the first cereal:
        int maxCal = list.get(0).getCalories();
        ArrayList<Cereal> maxCalCereals = new ArrayList<>(Arrays.asList(list.get(0)));

        for (int i = 1; i < list.size(); i++) {
            // if a cereal is found with more calories than maxCal, update maxCal accordingly
            // and reset maxCalCereals to be an ArrayList only containing this new cereal:
            if (list.get(i).getCalories() > maxCal) {
                maxCal = list.get(i).getCalories();
                maxCalCereals = new ArrayList<>(Arrays.asList(list.get(i)));
            }
            // if a cereal matches the amount of calories as maxCal, simply add it to maxCalCereals
            else if (list.get(i).getCalories() == maxCal) {
                maxCalCereals.add(list.get(i));
            }
        }

        return maxCalCereals;
    }

    /**
     * Find the Cereals with the least calories and returns them as an ArrayList.
     * 
     * @return the Cereal with the least calories as an ArrayList.
     */
    private static ArrayList<Cereal> findMinCalories() {
        // initialize minCal as the number of calories of the first cereal and initialize
        // minCalCereals with the first cereal:
        int minCal = list.get(0).getCalories();
        ArrayList<Cereal> minCalCereals = new ArrayList<>(Arrays.asList(list.get(0)));

        for (int i = 1; i < list.size(); i++) {
            // if a cereal is found with less calories than minCal, update minCal accordingly
            // and reset minCalCereals to be an ArrayList only containing this new cereal:
            if (list.get(i).getCalories() < minCal) {
                minCal = list.get(i).getCalories();
                minCalCereals = new ArrayList<>(Arrays.asList(list.get(i)));
            }
            // if a cereal matches the amount of calories as minCal, simply add it to minCalCereals
            else if (list.get(i).getCalories() == minCal) {
                minCalCereals.add(list.get(i));
            }
        }

        return minCalCereals;
    }

    /**
     * Find the Cereals with the highest fiber to protein ratios and returns them as an ArrayList.
     * 
     * @return the Cereal with the highest fiber to protein ratios calories as an ArrayList.
     */
    private static ArrayList<Cereal> findMaxFPRatio() {
        // initialize maxFPRatio as the FPRatio of the first cereal and initialize maxFPRatioCereals
        // with this first cereal:
        double maxFPRatio = list.get(0).getFPRatio();
        ArrayList<Cereal> maxFPRatioCereals = new ArrayList<>(Arrays.asList(list.get(0)));

        for (int i = 1; i < list.size(); i++) {
            // if a cereal is found with a higher FPRatio than maxFPRatio, update maxFPRatio
            // accordingly and reset maxFPRatioCereals to be an ArrayList only containing this new
            // cereal:
            if (list.get(i).getFPRatio() > maxFPRatio) {
                maxFPRatio = list.get(i).getFPRatio();
                maxFPRatioCereals = new ArrayList<>(Arrays.asList(list.get(i)));
            }
            // if a cereal's FPRatio matches maxFPRatio, simply add it to maxFPRatioCereals:
            else if (list.get(i).getFPRatio() == maxFPRatio) {
                maxFPRatioCereals.add(list.get(i));
            }
        }

        return maxFPRatioCereals;
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
        scan.nextLine(); // skip the first line (contains headers)
        while (scan.hasNext()) {
            String line = scan.nextLine();

            list.add(Cereal.parseCereal(line));
        }
    }

    /**
     * This method returns a Scanner to the file with the specified name. BE SURE THE FILE is in a
     * relatively located place with the correct file name and type. In VS Code, the file should be
     * in a location relative to the folder you opened. If you didn't open a folder, start over by
     * opening a folder!!!!
     * 
     * @param fname the name of the file to open and scann
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
