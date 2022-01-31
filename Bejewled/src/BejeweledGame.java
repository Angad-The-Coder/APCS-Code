import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.TimerTask;
import java.util.Timer;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class BejeweledGame {

    private JFrame frame = new JFrame("Bejeweled");
    private JPanel panel;
    private final Dimension DIM = new Dimension(800, 700);
    private BejeweledGrid grid = new BejeweledGrid();
    private Image background;
    private Timer timer;
    private Timer animationTimer;
    private JLabel pointsLabel;
    private JLabel timeLabel;
    private double secondsLeft;
    private MouseAdapter adapter;
    private static final int ANIMATION_INTERVAL = 30;

    public static void main(String[] args) {
        new BejeweledGame().start();
    }

    private void animateJewel(Jewel jewel) {
        animationTimer = new Timer();
        animationTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (jewel.selected)
                    jewel.animationIterations++;
                else {
                    animationTimer.cancel();
                    jewel.animationIterations = 0;
                    this.cancel();
                }
                panel.repaint();
            }
        }, 0, ANIMATION_INTERVAL);
    }

    private void decrementTime() {
        if (secondsLeft <= 0) {
            timer.cancel();
            if (animationTimer != null)
                animationTimer.cancel();
            panel.removeMouseListener(adapter);
            timeLabel.setText("Game Over!");
        } else {
            secondsLeft--;
            timeLabel.setText("Seconds left: " + (int) secondsLeft);
        }
    }

    private void start() {
        try {
            File f = new File("../images/backgrounds/planet.jpg");
            background = ImageIO.read(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        secondsLeft = 60;
        timeLabel = new JLabel("Seconds left: " + (int) secondsLeft);
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setBackground(Color.BLACK);
        pointsLabel = new JLabel("Points: 0");
        pointsLabel.setForeground(Color.WHITE);
        pointsLabel.setForeground(Color.BLACK);
        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, null);
                grid.draw(g);
            }
        };
        panel.setBackground(Color.BLACK);
        adapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                clickedAt(me);
            }
        };
        panel.addMouseListener(adapter);
        panel.setPreferredSize(DIM);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        timeLabel.setOpaque(true);
        timeLabel.setLocation(40, 20 + 52 * BejeweledGrid.BOARD_WIDTH);
        timeLabel.setSize(52 * BejeweledGrid.BOARD_WIDTH, 30);
        pointsLabel.setOpaque(true);
        pointsLabel.setLocation(100, 20 + 52 * BejeweledGrid.BOARD_WIDTH);
        pointsLabel.setSize(52 * BejeweledGrid.BOARD_WIDTH - 100, 30);
        panel.add(timeLabel);
        panel.add(pointsLabel);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                decrementTime();
            }
        }, 1000, 1000);
    }

    protected void clickedAt(MouseEvent me) {
        double timeAdded = 0;
        int gemsCleared = grid.justClicked(me);
        if (gemsCleared != 0) {
            switch (gemsCleared) {
                case 3:
                    timeAdded = 0.5;
                    break;
                case 4:
                    timeAdded = 1;
                    break;
                default:
                    timeAdded = 3;
                    break;
            }
        } else {
            int row = (me.getY() - BejeweledGrid.OFFSET_Y) / Jewel.SQUARE_SIZE;
            int col = (me.getX() - BejeweledGrid.OFFSET_X) / Jewel.SQUARE_SIZE;
            animateJewel(grid.jewels[row][col]);
        }
        secondsLeft += timeAdded;
        panel.repaint();
    }
}
