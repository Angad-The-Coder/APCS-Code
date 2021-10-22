import javax.swing.*;
import java.awt.event.*;
import kareltherobot.*;

public class Main implements Directions {
    public static void main(String[] args) {
        Robot initialWriter = new Robot(1, 1, North, 1500);
        World.setVisible(true);
        World.setDelay(0);

        for (int i = 0; i < 6; i++) {
            initialWriter.move();
            initialWriter.putBeeper();
        }
        initialWriter.turnLeft();
        initialWriter.turnLeft();
        initialWriter.turnLeft();
        for (int i = 0; i < 3; i++) {
            initialWriter.putBeeper();
            initialWriter.move();
        }
        initialWriter.turnLeft();
        initialWriter.turnLeft();
        initialWriter.turnLeft();
        for (int i = 0; i < 6; i++) {
            initialWriter.putBeeper();
            initialWriter.move();
        }
        initialWriter.turnLeft();
        initialWriter.turnLeft();
        for (int i = 0; i < 4; i++) {
            initialWriter.move();
        }
        initialWriter.turnLeft();
        for (int i = 0; i < 3; i++) {
            initialWriter.putBeeper();
            initialWriter.move();
        }
        initialWriter.turnLeft();
        initialWriter.turnLeft();
        for (int i = 0; i < 5; i++) {
            initialWriter.move();
        }
        initialWriter.putBeeper();
        for (int i = 0; i < 2; i++) {
            initialWriter.move();
            initialWriter.putBeeper();
        }
        initialWriter.move();
        initialWriter.turnLeft();
        for (int i = 0; i < 2; i++) {
            initialWriter.move();
            initialWriter.putBeeper();
        }
        initialWriter.turnLeft();
        for (int i = 0; i < 3; i++) {
            initialWriter.move();
            initialWriter.putBeeper();
        }
        initialWriter.turnLeft();
        for (int i = 0; i < 5; i++) {
            initialWriter.move();
            initialWriter.putBeeper();
        }
        initialWriter.turnLeft();
        for (int i = 0; i < 3; i++) {
            initialWriter.move();
            initialWriter.putBeeper();
        }
        initialWriter.turnLeft();
        for (int i = 0; i < 2; i++) {
            initialWriter.move();
            initialWriter.putBeeper();
        }
    }
}
