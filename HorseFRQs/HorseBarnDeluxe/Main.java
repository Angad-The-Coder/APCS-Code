import java.io.*;
import java.util.*;

class Main {
    private static Scanner keyboard = new Scanner(System.in);
    private final static int MAX = 25, MIN = 5, // min and max number of stalls
            MIN_W = 500, MAX_W = 1900;// MIN AND MAX WEIGHT

    private final static double PCT_FULL = .75;// percent full
    private static String[] names;

    public static void main(String[] args) {
        loadNames();
        // testFindHorse();
        testConsolidate();
        // testAddAtEnd();
        // testRemoveOlderThan();
    }

    public static void testRemoveOlderThan() {
        System.out.println("TEST ADD AT END");
        HorseBarn hb = createRandomBarn();
        System.out.println(hb);
        Calendar cal = Calendar.getInstance();
        System.out.print("Enter year: ");
        int y = keyboard.nextInt();
        System.out.print("Enter month (0 for Jan): ");
        int m = keyboard.nextInt();
        System.out.print("Enter day: ");
        int d = keyboard.nextInt();
        cal.set(y, m, d);
        Date date = cal.getTime();
        System.out.println(date);
        hb.removeOlderThan(date);
        System.out.println(hb);
    }

    public static void testAddAtEnd() {
        System.out.println("TEST ADD AT END");
        HorseBarn hb = createRandomBarn();
        System.out.println(hb);
        System.out.print("Enter the index to erase: ");
        int ind = keyboard.nextInt();
        hb.setHorse(ind, null);// puts a null testFindHorse
        System.out.println(hb);
        Horse h = randomHorse(hb);
        hb.addAtEnd(h);
        System.out.println(hb);
    }

    public static void testConsolidate() {
        System.out.println("TEST CONSOLIDATE");
        HorseBarn hb = createRandomBarn();
        System.out.println(hb);

        hb.consolidate();
        System.out.println(hb);
    }

    public static void testFindHorse() {
        System.out.println("TEST FIND HORSE");
        HorseBarn hb = createRandomBarn();
        System.out.println(hb);
        String name = "";
        while (!name.equals("quit")) {
            System.out.print("Enter the name of Horse to find (quit to end): ");
            name = keyboard.nextLine();
            int x = hb.findHorseSpace(name);
            System.out.println(name + " was found at " + x);
        }
    }

    /**
     * loadNames assigns the names array to contain all the names in names.txt. Since arrays have a
     * fixed length and we don't know how many names we'd like to store in the names array, the
     * loadNames method uses a String, a data type with dynamic length, instead. This String is
     * called name, and it uses a ":" as its delimiter between names. This is done so that we can
     * later convert it to an array using the split method, passing in ":" as the parameter to split
     * name with.
     */
    public static void loadNames() {
        File f = new File("names.txt");
        try {
            Scanner input = new Scanner(f);
            String all = "";
            while (input.hasNext()) {
                String name = input.next();
                if (name.length() > 0) {
                    all += name + ":";
                }
            }
            input.close();
            names = all.split(":");
            System.out.println("Done with names");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static HorseBarn createRandomBarn() {
        int num = (int) (MIN + Math.random() * MAX);// random # of stalls
        HorseBarn temp = new HorseBarn(num);// makes HorseBarn with num stalls
        // int fillAmt =(int)( 1+Math.random()*(num-1));
        for (int ind = 0; ind < num; ind++) {
            if (Math.random() < PCT_FULL) {// randomly fills stalls
                temp.setHorse(ind, randomHorse(temp));
            }
        }
        return temp;
    }

    /**
     * Given a HorseBarn called hb, randomHorse continually grabs a random name from the names array
     * until that name isn't currently inside hb. Then, it creates a random weight for the horse
     * that is in between instance variables MIN_W and MAX_W. Afterwards, it creates a sire horse
     * for it, initially setting the sire to null. 60% of the time, this sire horse will be given
     * the same name as the original horse, except with the appension of "-daddy", its weight will
     * be the average between the original horse's weight, and the instance variable MAX_W, and it
     * will have no sire. The other 40% of the time, the sire horse is left as null. Lastly, all of
     * these elements (the random name, weight, and sire) are used to create a new Horse object
     * (using the Horse class's constructor) called h. This horse object is returned from the
     * method.
     * 
     * @param hb HorseBarn object that your random horse will be compared against to ensure you are
     *        not creating a horse whose name is already in hb, maintaining the precondition that
     *        all horses in a HorseBarn have distinct names
     * 
     * @return a random horse whose name is not in hb
     */
    public static Horse randomHorse(HorseBarn hb) {
        String name = names[(int) (Math.random() * names.length)];
        while (hb.findHorseSpace(name) != -1) {
            name = names[(int) (Math.random() * names.length)];
            System.out.println(name);
        }
        System.out.println(name);
        int weight = MIN_W + (int) (Math.random() * (MAX_W - MIN_W));
        Horse sire = null;
        if (Math.random() > .4) {
            sire = new Horse(name + "-daddy", (weight + MAX_W) / 2, null);
        }
        Horse h = new Horse(name, weight, sire);
        return h;
    }
}
