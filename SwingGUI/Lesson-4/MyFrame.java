import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements ActionListener {
    JButton button;
    JLabel label;

    MyFrame() {
        ImageIcon pointerIcon = new ImageIcon("images/pointer.png");
        ImageIcon smileyIcon = new ImageIcon("images/smiley.png");

        label = new JLabel();
        label.setText("Sample Label");
        label.setIcon(smileyIcon);
        label.setBounds(150, 250, 150, 150);
        label.setVisible(false);


        button = new JButton();
        button.setBounds(125, 100, 250, 100);
        button.addActionListener(this);
        button.setText("Sample Button");
        button.setFocusable(false);
        button.setIcon(pointerIcon);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Comic Sans", Font.BOLD, 25));
        button.setIconTextGap(-5);
        button.setForeground(Color.DARK_GRAY);
        button.setBackground(Color.LIGHT_GRAY);
        button.setBorder(BorderFactory.createEtchedBorder());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(button);
        this.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            label.setVisible(true);
        }
    }
}
