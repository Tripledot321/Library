package Package1;

import javax.swing.*;
import java.awt.*;

//min kommentar
public class GUI {

    JFrame frame;
    JPanel headerPanel, searchBooksPanel, mainPanel, loginPanel;
    Font bigFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);

    public void createGUI(LibrarySys.ChoiceHandler cHandler) {

        // Window frame
        frame = new JFrame();
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.white);
        frame.setLayout(new BorderLayout());
        frame.setTitle("Library");
        frame.setVisible(true);


//        JPanel panel = new JPanel();
//        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
//        panel.setBackground(Color.RED);
//
//        Button button = new Button("Button");
//        panel.add(button);
//        panel.setVisible(true);
//
//        frame.add(panel, BorderLayout.NORTH);


        // headerPanel
        headerPanel = new JPanel();
//        headerPanel.setBounds(0, 0, 1200, 120);
        headerPanel.setBackground(Color.black);
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        frame.add(headerPanel, BorderLayout.NORTH);

//        JPanel panel = new JPanel();
//        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
//        panel.setBackground(Color.RED);
//
//        Button button = new Button("Button");
//        panel.add(button);
//        panel.setVisible(true);

//        headerPanel.add(panel);



        // Package1.Main Menu
        mainPanel = new JPanel();
//        mainPanel.setBounds(100, 130, 900, 600);
        mainPanel.setBackground(Color.red);
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        frame.add(mainPanel, BorderLayout.CENTER);

        //lägg till saker i headerPanel
        JLabel titleNameLabel = new JLabel("LTU Library");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(bigFont);
        headerPanel.add(titleNameLabel);

        JButton loginButton = new JButton("Login");
        //Det är nåt som inte blir bra när man försöker flytta saker, oavsett vilket x-värde så samma plats.. :'(
//        loginButton.setBounds(1200, 30,300, 50);
        //loginButton.setLocation(1100,30);
        loginButton.setFont(normalFont);
        loginButton.setBackground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(cHandler);
        loginButton.setActionCommand("login");
        headerPanel.add(loginButton);

        //
        JButton goToSearchButton = new JButton("Search");
        //Det är nåt som inte blir bra när man försöker flytta saker, oavsett vilket x-värde så samma plats.. :'(
//        goToSearchButton.setBounds(1200, 100,300, 50);
        goToSearchButton.setFont(normalFont);
        goToSearchButton.setBackground(Color.WHITE);
        goToSearchButton.setFocusPainted(false);
        goToSearchButton.addActionListener(cHandler);
        goToSearchButton.setActionCommand("search");
        headerPanel.add(goToSearchButton);


        //Search button
        searchBooksPanel = new JPanel();
//        searchBooksPanel.setBounds(500, 350, 1000, 100);
        searchBooksPanel.setPreferredSize(searchBooksPanel.getPreferredSize());
        searchBooksPanel.setBackground(Color.white);
        searchBooksPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 5));
        mainPanel.add(searchBooksPanel);

        //search fields with labels

        //search field
        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(550,30));
        searchField.setBackground(Color.lightGray);
        searchBooksPanel.add(searchField);

        JButton searchButton = new JButton("Search");
        searchButton.setBackground(Color.black);
        searchButton.setForeground(Color.white);
        searchButton.setFont(normalFont);
        searchButton.setFocusPainted(false);
        searchButton.addActionListener(cHandler);
        //ändrade denna från "ENTER" till "start" enligt videon, jag tror att ChoiceHandlern kallar på namnet i switchen så måste nog va samma?
        //jag fick ett nytt sorts felmeddelande och knappen ser lite funky ut nu när man klickar så verkar hända mer
        searchButton.setActionCommand("start");
        searchBooksPanel.add(searchButton);






        //Login screen username

        //username text field
        loginPanel = new JPanel();
        loginPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));

        mainPanel.add(loginPanel);

        //usernamePanel.setBounds(300, 300, 200, 30);
        //usernamePanel.setBackground(Color.white);
        JTextField usernameField = new JTextField();
        usernameField.setText("Please enter your username and password");
        //usernameField.setPreferredSize(new Dimension(200,30));
        usernameField.setBackground(Color.lightGray);
        loginPanel.add(usernameField);

        //username label
        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setForeground(Color.white);
        usernameLabel.setFont(normalFont);
        loginPanel.add(usernameLabel);

        //password field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200,30));
        passwordField.setBackground(Color.lightGray);
        loginPanel.add(passwordField);
        //password label
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setForeground(Color.black);
        passwordLabel.setFont(normalFont);
        loginPanel.add(passwordLabel);

        //Testar att lägga in en text som kan synas/inte synas beroende på VisibilityManager
        JLabel loginScreenLabel = new JLabel("Please enter your username and password");
        loginScreenLabel.setForeground(Color.black);
        loginScreenLabel.setFont(normalFont);
        //Tror det är såhär man kanske ska göra, alltså att sakerna är setVisible(false) som default och
        //sen när man vill att dom ska synas ändrar man i metoden i VisibilityManager
        loginScreenLabel.setVisible(false);
        loginPanel.add(loginScreenLabel);

    }


}
