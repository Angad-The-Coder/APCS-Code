import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Restaurant {
    /* Instance Variables */
    // (Just the Menu)
    private ArrayList<String> menu = new ArrayList<>(
            // start the menu off with a few food items:
            Arrays.asList("Pizza", "Hamburger", "Ice Cream"));

    /* Main method */
    // (Sole public method, used in ArrayListProject)
    public void addToMenu() {
        Scanner input = new Scanner(System.in);
        do {
            String userInput = showMenuPrompt(input);
            if (userInput.equals("a")) {
                this.menu.add(promptFood(input));
            } else if (userInput.equals("i")) {
                String insertFood = promptFood(input);
                int insertPosition = promptPosition(input);
                this.menu.add(insertPosition, insertFood);
            } else if (userInput.equals("r")) {
                this.menu.remove(promptPosition(input));
            } else if (userInput.equals("p")) {
                String replaceStr = promptFood(input);
                int replacePos = promptPosition(input);
                // replace by removing and inserting in the same index:
                this.menu.remove(replacePos);
                this.menu.add(replacePos, replaceStr);
            } else if (userInput.equals("q")) {
                input.close();
                return;
            } else {
                System.out.println("Invalid instruction, try again!");
            }
        } while (input.hasNextLine());
    }

    /* Helper Methods */
    // Used in addToMenu to abstract away some I/O boilerplate and input validation:
    private String showMenuPrompt(Scanner inputScanner) {
        System.out.println("The menu: " + this.menu);
        System.out.println(
            "Would you like to (a)dd, (i)nsert, (r)emove, Re(p)lace or (q)uit?"
        );

        // use .next() instead of .nextLine() so that .hasNextLine() is
        // still true (important for the loop in the addToMenu method):
        return inputScanner.next();
    }

    private String promptFood(Scanner inputScanner) {
        System.out.println("Enter a food:");
        return inputScanner.next();
    }

    private int promptPosition(Scanner inputScanner) {
        System.out.println("Enter a position:");
        int userPos = inputScanner.nextInt();
        // check whether the position is valid, ask the user for another position if not:
        while (userPos < 1 || userPos > this.menu.size()) {
            System.out.println("Bad position! Try again:");
            inputScanner.nextLine(); // advance the cursor
            userPos = inputScanner.nextInt();
        }

        // subtract one since user's position is not zero-indexed:
        return userPos - 1;
    }
}
