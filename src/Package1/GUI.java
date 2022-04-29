package Package1;

import javax.swing.*;
import java.awt.*;

//min kommentar
public class GUI {

    JFrame frame;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, searchFieldPanel;
    JLabel titleNameLabel;
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextField searchField;
    JTextArea mainTextArea;
    Font bigFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);

    public void createGUI(LibrarySys.ChoiceHandler cHandler) {

        // Window frame
        frame = new JFrame();
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.white);
        frame.setTitle("Library");
        frame.setLayout(null);

        // Title screen
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(0, 0, 1200, 120);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("LTU Library");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(bigFont);
        titleNamePanel.add(titleNameLabel);

        //Search button
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(500, 350, 200, 100);
        startButtonPanel.setBackground(Color.white);
        startButton = new JButton("Search");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(cHandler);
        //ändrade denna från "ENTER" till "start" enligt videon, jag tror att ChoiceHandlern kallar på namnet i switchen så måste nog va samma?
        //jag fick ett nytt sorts felmeddelande och knappen ser lite funky ut nu när man klickar så verkar hända mer
        startButton.setActionCommand("start");
        startButtonPanel.add(startButton);


        //search field
        searchFieldPanel = new JPanel();
        searchFieldPanel.setBounds(300, 300, 600, 30);
        searchFieldPanel.setBackground(Color.white);
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(550,30));
        searchField.setBackground(Color.lightGray);
        searchFieldPanel.add(searchField);

        // Package1.Main Menu
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.white);

        mainTextArea = new JTextArea("This is the main text Area");
        mainTextArea.setBounds(250, 350, 300, 150);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 600, 475, 150);

        choice1 = new JButton("choice1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("choice2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("choice3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("choice4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(cHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        frame.add(titleNamePanel);
        frame.add(startButtonPanel);
        frame.add(mainTextPanel);
        frame.add(searchFieldPanel);

        frame.setVisible(true);

    }


}
