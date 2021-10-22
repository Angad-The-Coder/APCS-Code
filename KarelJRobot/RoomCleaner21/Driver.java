import java.util.Scanner;

// import javax.swing.JOptionPane;

import kareltherobot.*;

public class Driver implements Directions {
    // declared here so it is visible in all the methods!!
    // It will be assigned a value in the getInfo method
    Robot roomba;

    // Initialize instance variables:
    int roomWidth = 1;
    int roomHeight = 1;
    int beeperCount = 0;
    int pileCount = 0;
    int largestPile = 0;
    String largestPileLocation = "";

    public static void main(String[] args) {
        // LEAVE THIS ALONE!!!!!!
        Driver d = new Driver();
        d.getInfo();
        d.cleanRoom();
        d.displayResults();
    }

    /**
     * This method gets info from the user in the following order: 1. Ask the user which world file
     * they wish to process. Right now, that world file name is hardcoded in. 2. Ask the user for
     * the starting location and direction of the Robot. A new Robot should be constructed and
     * assigned to the global (instance) variable named roomba that is declared on line 10.
     * 
     * An inelegant way to interact with the user is via the console, using System.out.println and a
     * Scanner that scans System.in (input from the console). A more elegant way to get user input
     * might include using a JOptionPane.
     */
    private void getInfo() {

        Scanner input = new Scanner(System.in);

        System.out.println("What direction do you want Karel to face?");
        System.out
                .println("(Enter 'N' for north, 'S' for south, 'E' for east, and 'W' for west): ");

        Direction dir = Directions.West;
        boolean receivedDirection = false;
        while (!receivedDirection) {
            String directionToFace = input.nextLine();
            receivedDirection = true;
            if (directionToFace.equals("N")) {
                dir = Directions.North;
            } else if (directionToFace.equals("S")) {
                dir = Directions.South;
            } else if (directionToFace.equals("E")) {
                dir = Directions.East;
            } else if (directionToFace.equals("W")) {
                dir = Directions.West;
            } else {
                System.out.println("Try again: ");
            }
        }

        String wrldName = "basicRoom.wld";

        World.readWorld(wrldName);
        World.setVisible(true);
        World.setDelay(5);

        System.out.println("At which avenue should Karel start at?");
        System.out.println("(Enter a avenue between 7 and 11)");
        int ave = 7;
        boolean receivedAve = false;
        while (!receivedAve) {
            ave = input.nextInt();
            input.nextLine();
            if (ave >= 7 && ave <= 11) {
                receivedAve = true;
            } else {
                System.out.println("Try again: ");
            }
        }
        System.out.println("At which street should Karel start at?");
        System.out.println("(Enter an street between 6 and 13)");
        int street = 6;
        boolean receivedStreet = false;
        while (!receivedStreet) {
            street = input.nextInt();
            input.nextLine();
            if (street >= 6 && street <= 13) {
                receivedStreet = true;
            } else {
                System.out.println("Try again: ");
            }
        }
        input.close();

        roomba = new Robot(ave, street, dir, 0);
    }

    /**
     * This method will have all the logic that takes the Robot to every location and cleans up all
     * piles of beepers. Think about ways you can break this large, complex task into smaller,
     * easier to solve problems.
     */
    private void cleanRoom() {
        moveToStart();
        // Count the room's width on first traversal:
        traverseStreet();
        while (roomba.frontIsClear()) {
            roomHeight++;
            roomba.move();
            traverseStreet();
        }
    }

    /**
     * This method moves the roomba to the top left of the room and has it orient towards the right
     * of the room. This will serve as the starting position for the roomba before it starts
     * cleaning
     */
    private void moveToStart() {
        while (!roomba.facingNorth()) {
            roomba.turnLeft();
        }
        while (roomba.frontIsClear()) {
            roomba.move();
        }
        roomba.turnLeft();
        while (roomba.frontIsClear()) {
            roomba.move();
        }

        // Face towards the right of the room:
        roomba.turnLeft();
        roomba.turnLeft();
    }

    /**
     * This method assumes the robot is either at the leftmost or the rightmost avenue in the room;
     * it then points towards the opposing end of the room. It will traverse along the street until
     * it reaches a wall, and record all necessary details in the instance variables
     */
    private void traverseStreet() {
        // Change orientation to point towards opposing end of room:
        while (!roomba.frontIsClear() || roomba.facingNorth() || roomba.facingSouth()) {
            roomba.turnLeft();
        }

        // Reset width to 1 before counting:
        roomWidth = 1;

        // Traverse through street:
        while (roomba.frontIsClear()) {
            roomba.move();
            // Increment width with each successful movement:
            roomWidth++;
            if (roomba.nextToABeeper()) {
                // Pick beepers until pile is gone, recording info to instance variables
                pileCount++;
                int beepersInPile = 1;
                roomba.pickBeeper();
                while (roomba.nextToABeeper()) {
                    beepersInPile++;
                    roomba.pickBeeper();
                }
                if (beepersInPile > largestPile) {
                    largestPile = beepersInPile;
                    largestPileLocation = "{\n" + "  Relative avenues: " + roomWidth + ",\n"
                            + "  Relative streets: " + roomHeight + "\n" + "}";
                }
                beeperCount += beepersInPile;
            }
        }

        // At the end, face south (see cleanRoom method to see why)
        while (!roomba.facingSouth()) {
            roomba.turnLeft();
        }
    }

    /**
     * This method displays the results of cleaning the room. All of the info in the pdf that
     * describes the problem need to be displayed. You can present this info in the console (boring)
     * or you can present using JOptionPane (cool!)
     */
    private void displayResults() {
        int roomArea = roomWidth * roomHeight;
        System.out.println("Area of the room: " + (roomArea));
        System.out.println("Number of piles: " + pileCount);
        System.out.println("Total number of beepers: " + beeperCount);
        System.out.println("Largest pile of beepers: " + largestPile);
        System.out.println("Relative location of largest pile: " + largestPileLocation);
        System.out.println("Average pile size: " + (double) beeperCount / pileCount);
        System.out.println("Percent dirty: " + (double) pileCount / roomArea * 100 + "%");
    }

}
