import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String word = prompt("Enter a word to be converted to Pig Latin:");
        while (word.length() < 1) {
            word = prompt("Enter a valid word:");
        }
        // Use word.substring to construct word in pig latin
        String pigLatin = word.substring(1) + word.substring(0, 1) + "ay";

        System.out.println(word + " in Pig Latin is " + pigLatin);
    }

    private static String prompt(String promptStr) {
        System.out.println(promptStr);
        String response = input.nextLine();
        return response;
    }
}
