import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        userEnteredMall();
        // fileResponseMall(); // uncomment to make a mall from createMall.txt
    }

    public static void userEnteredMall() {
        Scanner input = new Scanner(System.in);

        System.out.println("What would you like to name the mall?");
        String mallName = input.nextLine();
        System.out.println("What should the mall's address be?");
        String mallAddress = input.nextLine();

        Mall userMall = new Mall(mallName, mallAddress);

        System.out.println("What should be the name of a store at the mall?");
        String storeName = input.nextLine();
        System.out
                .println("When should the store open?\n(enter times in military format (hh:mm)): ");
        LocalTime storeOpeningTime = LocalTime.parse(input.nextLine());
        System.out.println(
                "When should the store close?\n(enter times in military format (hh:mm)): ");
        LocalTime storeClosingTime = LocalTime.parse(input.nextLine());

        Store userStore = new Store(storeName, storeOpeningTime, storeClosingTime);

        System.out.println("What should be the name of an item sold at the store?");
        String itemName = input.nextLine();
        System.out.println("How much should the item cost in dollars?\n(enter a decimal): ");
        double itemPrice = input.nextDouble();
        input.nextLine();
        System.out.println("How much of the item is in stock?");
        int itemStock = input.nextInt();
        input.nextLine();
        System.out.println("What is the rating of the item from 0 to 5?\n(enter a whole number): ");
        int itemRating = input.nextInt();
        input.nextLine();

        Item userItem = new Item(itemName, itemPrice, itemStock, itemRating);

        userStore.addItem(userItem);
        userMall.addStore(userStore);

        input.close();

        System.out.println(userMall);
        System.out.println("\n" + userMall.storeInfo());
        System.out.println("\n" + userMall.getStores()[0].itemsInfo());
    }

    public static void fileResponseMall() {
        File responseFile;
        Scanner input;
        try {
            responseFile = new File("createMall.txt");
            input = new Scanner(responseFile);
            String mallName = input.nextLine();
            String mallAddress = input.nextLine();

            Mall userMall = new Mall(mallName, mallAddress);

            String storeName = input.nextLine();
            LocalTime storeOpeningTime = LocalTime.parse(input.nextLine());
            LocalTime storeClosingTime = LocalTime.parse(input.nextLine());

            Store userStore = new Store(storeName, storeOpeningTime, storeClosingTime);

            String itemName = input.nextLine();
            double itemPrice = input.nextDouble();
            input.nextLine();
            int itemStock = input.nextInt();
            input.nextLine();
            int itemRating = input.nextInt();

            Item userItem = new Item(itemName, itemPrice, itemStock, itemRating);

            userStore.addItem(userItem);
            userMall.addStore(userStore);

            input.close();

            System.out.println(userMall);
            System.out.println("\n" + userMall.storeInfo());
            System.out.println("\n" + userMall.getStores()[0].itemsInfo());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
