import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import kareltherobot.*;

public class Main implements Directions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("How many beepers do you want on each side of the diamond?");
        int side = in.nextInt();

        Robot bob = new Robot(1, side + 1, North, side * 4);
        World.setSize(side * 2 + 2, side * 2 + 2);
        World.setVisible(true);
        World.setDelay(10);

        for (int i = 0; i < 4; i++) {
            bob.putBeeper();
            for (int j = 0; j < side - 1; j++) {
                bob.move();
                bob.turnLeft();
                bob.move();
                turnRight(bob);
                bob.putBeeper();
            }
            turnRight(bob);
        }
    }

    public static void turnRight(Robot bob) {
        bob.turnLeft();
        bob.turnLeft();
        bob.turnLeft();
    }
}
