import javax.swing.*;
import java.awt.*;

public class GUI {

    JFrame frame;
    JPanel titleNamePanel, startButtonPanel;
    JLabel titleNameLabel;
    JButton startButton;
    Font bigFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);

    public GUI() {

        // Window
        frame = new JFrame();
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.white);
        frame.setTitle("Library");
        frame.setLayout(null);

        // Title Screen
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 1000, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("LTU Library");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(bigFont);
        titleNamePanel.add(titleNameLabel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(500, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("ENTER");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButtonPanel.add(startButton);

        frame.add(titleNamePanel);
        frame.add(startButtonPanel);

        frame.setVisible(true);

    }

}
