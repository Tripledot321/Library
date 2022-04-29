package Package1;

import javax.swing.*;
import java.awt.*;

//min kommentar
public class GUI {

    JFrame frame;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, searchFieldPanel;
    JLabel titleNameLabel, loginScreenLabel;
    JButton startButton, choice1, choice2, choice3, choice4, loginButton;
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
        loginButton = new JButton("Login");
        //Det är nåt som inte blir bra när man försöker flytta saker, oavsett vilket x-värde så samma plats.. :'(
        loginButton.setBounds(1200, 30,300, 50);
        //loginButton.setLocation(1100,30);
        loginButton.setFont(normalFont);
        loginButton.setBackground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(cHandler);
        loginButton.setActionCommand("login");
        titleNamePanel.add(loginButton);




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
        mainTextPanel.setBounds(100, 130, 900, 600);
        mainTextPanel.setBackground(Color.white);

        mainTextArea = new JTextArea("This is the main text Area");
        mainTextArea.setBounds(400, 350, 1000, 300);
        mainTextArea.setBackground(Color.LIGHT_GRAY);
        mainTextArea.setForeground(Color.black);
        mainTextArea.setPreferredSize(new Dimension(900,300));
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextArea.setVisible(false);
        mainTextPanel.add(mainTextArea);

        //Testar att lägga in en text som kan synas/inte synas beroende på VisibilityManager
        loginScreenLabel = new JLabel("Please enter your username and password");
        loginScreenLabel.setForeground(Color.black);
        loginScreenLabel.setFont(normalFont);
        //Tror det är såhär man kanske ska göra, alltså att sakerna är setVisible(false) som default och
        //sen när man vill att dom ska synas ändrar man i metoden i VisibilityManager
        loginScreenLabel.setVisible(false);
        mainTextPanel.add(loginScreenLabel);



        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 600, 475, 150);


        //Tror dessa är överflödiga, det är knappar som vi inte lagt någonstans, men såg att dom var med i videon
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
