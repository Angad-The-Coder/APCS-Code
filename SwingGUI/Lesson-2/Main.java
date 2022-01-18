import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Main {
    public static void main(String[] args) {
        ImageIcon dogImage = new ImageIcon("images/dog.jpg");
        Border dogBorder = BorderFactory.createLineBorder(new Color(0x6A2F0F), 2);

        JLabel dogLabel = new JLabel();
        dogLabel.setText("This is a dog");
        dogLabel.setIcon(dogImage);
        dogLabel.setHorizontalTextPosition(JLabel.CENTER);
        dogLabel.setVerticalTextPosition(JLabel.TOP);
        dogLabel.setForeground(new Color(0x6A2F0F));
        dogLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        dogLabel.setBackground(new Color(0xFFCDB2));
        dogLabel.setOpaque(true);
        dogLabel.setBorder(dogBorder);
        dogLabel.setVerticalAlignment(JLabel.CENTER);
        dogLabel.setHorizontalAlignment(JLabel.CENTER);

        JFrame dogFrame = new JFrame();
        dogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dogFrame.setVisible(true);
        dogFrame.add(dogLabel);

        dogFrame.pack();
    }
}
