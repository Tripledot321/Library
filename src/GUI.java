import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    JFrame frame;
    JPanel panel;
    JPanel titleNamePanel;
    JLabel label;
    Container container;
    Font normalfont = new Font("Times New Roman", Font.plain, 26);

    public GUI() {

        frame = new JFrame();

        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("LTU Library");
        frame.setVisible(true);
        frame.setLayout(null);
        container = frame.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 1000, 150);
        titleNamePanel.setBackground(Color.black);

        container.add(titleNamePanel);

    }

}
