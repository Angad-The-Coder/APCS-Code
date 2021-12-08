import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner keys = new Scanner(System.in);
        int choice = -1;
        while (choice != 4) {
            System.out.println("1. Test basics.");
            System.out.println("2. Test grid of Objects.");
            System.out.println("4. Quit");
            choice = keys.nextInt();
            if (choice == 1) {
                SumRowsAndCols.main(args);
            } else if (choice == 2) {
                GridOfObjects.main(args);
            }
        }
    }
}
