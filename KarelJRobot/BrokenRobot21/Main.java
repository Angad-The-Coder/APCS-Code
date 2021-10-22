import javax.swing.*;
import java.awt.event.*;
import kareltherobot.*;

// This poor robot is broken! Work with your partner to fix his problems. Comment where you have
// made a change to the code and what the issue was.

// Note: there are two pop culture references made in this code: a Saturday Morning Cartoon and a
// Movie. Bonus: list those references here:

public class Main implements Directions {
    public static void main(String[] args) {
        Robot fred = new Robot(2, 2, East, 13);
        World.setVisible(true);
        World.setSize(15, 15);
        World.setDelay(5);

        for (int i = 0; i < 5; i++) {
            fred.move();
            fred.putBeeper();
        }

        makeVertical(fred);

        turnRight(fred);

        for (int i = 0; i < 4; i++) {
            fred.move();
            fred.putBeeper();
        }
    }

    public static void makeVertical(Robot fred) {
        fred.turnLeft();
        for (int i = 0; i < 4; i++) {
            fred.move();
            fred.putBeeper();
        }
    }

    public static void turnRight(Robot fred) {
        for (int i = 0; i < 3; i++) {
            fred.turnLeft();
        }
    }
}
