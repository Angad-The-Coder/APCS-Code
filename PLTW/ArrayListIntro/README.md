## 3.7.1

1. **What are you allowed to store in an ArrayList?**

   You are allowed to store objects in an ArrayList, which excludes primitive types like `int`, `double`, or `boolean`.

2. **What is a wrapper class and why are they important for ArrayLists?**

   Wrapper classes are classes that correspond to Java’s primitive data types (e.g. `int` → `Integer`, `bool` → `Boolean`, etc.), allowing one to use primitive data types like objects.

3. **Screenshot of your Person class, the main class and the run output from steps 6 - 9. You might need 3 different screenshots to do this.**

    <table>
    <tr><td>Person class (Person.java)</td></tr>
    <tr><td>

   ```java
   public class Person {
       /* Instance Variables */
       private String name;
       private int age;
       private boolean wearsGlasses;

       /* Constructor */
       public Person(String name, int age, boolean wearsGlasses) {
           this.name = name;
           this.age = age;
           this.wearsGlasses = wearsGlasses;
       }

       /* toString */
       public String toString() {
           String personStr = "";
           // give person an face based on whether they wear glasses or not:
           if (this.wearsGlasses) {
               personStr += "(■_■) ";
           } else {
               personStr += "(o_o) ";
           }
           // include the person's age and name (ex. "37 year old Mark Zuckerberg")
           personStr += this.age + " year old " + this.name;

           return personStr;
       }
   }

   ```

   \* getters/setters are unnecessary for this use case
   </td></tr>
   </table>
   <table>
   <tr><td>Main class (Main.java)</td></tr>
   <tr><td>

   ```java
   import java.util.ArrayList;

   public class Main {
       public static void main(String[] args) {
           ArrayList<Person> people = new ArrayList<>();

           people.add(new Person("Bill Gates", 66, true));
           people.add(new Person("Mark Zuckerberg", 37, false));
           people.add(new Person("Sundar Pichai", 49, true));

           System.out.println(people);
       }
   }

   ```

   </td></tr>
   </table>
   <table>
   <tr><td>Output from Main class</td></tr>
   <tr><td>

   ```
   [(■_■) 66 year old Bill Gates, (o_o) 37 year old Mark Zuckerberg, (■_■) 49 year old Sundar Pichai]
   ```

   </td></tr>
   </table>

## 3.7.2

1. **With an array you can initialize it with values (ex. `int[] nums = {1,3,4,6,7};`). Research how you can initialize an ArrayList with values and type an example of code below.**

   An `ArrayList` can be initialized with values by passing in `Arrays.asList(`{comma-separated values here}`)` into the constructor of the `ArrayList`. The resulting `ArrayList` will be populated with the comma-separated values you place into the `Arrays.asList()` method.

   <table>
   <tr><td>Example code segment</td></tr>
   <tr><td>

   ```java
   import java.util.ArrayList;
   import java.util.Arrays;

   public class InitializationExample {
       public static void main(String[] args) {
           // initialize using Arrays.asList:
           ArrayList<String> animals = new ArrayList<>(
               Arrays.asList("Pig", "Cow", "Chicken")
           );

           System.out.println(animals);
       }
   }

   ```

   </td></tr>
   </table>
   <table>
   <tr><td>Output from code segment</td></tr>
   <tr><td>

   ```
   [Pig, Cow, Chicken]
   ```

   </td></tr>
   </table>

2. **Screenshots of your code and run output for It’s Your Turn section step 11. Again, you might need multiple screenshots.**

   <table>
   <tr><td>“Your Turn” project code (Restaurant.java)</td></tr>
   <tr><td>

   ```java
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
            // check whether the position is valid, ask the user for another position
            while (userPos < 1 || userPos > this.menu.size()) {
                System.out.println("Bad position! Try again:");
                inputScanner.nextLine(); // advance the cursor
                userPos = inputScanner.nextInt();
            }

            // subtract one since user's position is not zero-indexed:
            return userPos - 1;
        }
    }

   ```

   </td></tr>
   </table>

   <table>
   <tr><td>“Your Turn” project code (Main.java)</td></tr>
   <tr><td>

   ```java
   public class Main {
       public static void main(String[] args) {
           Restaurant userRestaurant = new Restaurant();
           userRestaurant.addToMenu();
       }
   }

   ```

    </td></tr>
    </table>

    <table>
    <tr><td>“Your Turn” project output (main method in Main.java)</td></tr>
    <tr><td>

   ```
   The menu: [Pizza, Hamburger, Ice Cream]
   Would you like to (a)dd, (i)nsert, (r)emove, Re(p)lace or (q)uit?
   > a
   Enter a food:
   > Steak
   The menu: [Pizza, Hamburger, Ice Cream, Steak]
   Would you like to (a)dd, (i)nsert, (r)emove, Re(p)lace or (q)uit?
   > i
   Enter a food:
   > Spaghetti
   Enter a position:
   > 12
   Bad position! Try again:
   > 1
   The menu: [Spaghetti, Pizza, Hamburger, Ice Cream, Steak]
   Would you like to (a)dd, (i)nsert, (r)emove, Re(p)lace or (q)uit?
   > r
   Enter a position:
   > 5
   The menu: [Spaghetti, Pizza, Hamburger, Ice Cream]
   Would you like to (a)dd, (i)nsert, (r)emove, Re(p)lace or (q)uit?
   > p
   Enter a food:
   > Taco
   Enter a position:
   > 3
   The menu: [Spaghetti, Pizza, Taco, Ice Cream]
   Would you like to (a)dd, (i)nsert, (r)emove, Re(p)lace or (q)uit?
   > q
   ```

   \* text like `> this` indicates a user input

    </td></tr>
    </table>
