package Package1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//min kommentar
public class GUI {

    JFrame frame;
    JPanel searchBooksPanel, loginPanel;
    Font bigFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
    private BookService _bookService;
    private UserService _userService;

    public GUI(BookService bookService, UserService userService) {
        this._bookService = bookService;
        this._userService = userService;
    }

    public void createGUI(NavigationChoiceHandler cHandler) {

        JPanel headerPanel, mainPanel;


        // Window frame
        frame = new JFrame();

        //Set up the content pane.
        var pane = frame.getContentPane();
        pane.setPreferredSize(new Dimension(1200, 600));

        //Display the window.

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.white);
        frame.setLayout(new BorderLayout());
        frame.setTitle("Library");
        frame.setVisible(true);

        // headerPanel
        headerPanel = new JPanel();
        headerPanel.setBackground(Color.black);
        headerPanel.setLayout(new FlowLayout());
        headerPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pane.add(headerPanel, BorderLayout.NORTH);
        headerPanel.setVisible(true);

        // Main Panel
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.red);
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        pane.add(mainPanel, BorderLayout.CENTER);
        mainPanel.setVisible(true);


        populateHeaderPanel(cHandler, headerPanel);
        createLoginPanel(cHandler, mainPanel);
        createSearchPanel(cHandler, mainPanel);

        frame.pack();

    }

        public void populateHeaderPanel(NavigationChoiceHandler cHandler, JPanel headerPanel) {

            //// Header Panel Content
            //lägg till saker i headerPanel
            JLabel titleNameLabel = new JLabel("LTU Library");
            titleNameLabel.setForeground(Color.white);
            titleNameLabel.setFont(bigFont);
            headerPanel.add(titleNameLabel);

            JButton goToLoginButton = new JButton("Login");
            goToLoginButton.setFont(normalFont);
            goToLoginButton.setBackground(Color.WHITE);
            goToLoginButton.setFocusPainted(false);
            goToLoginButton.addActionListener(cHandler);
            goToLoginButton.setActionCommand("login");
            headerPanel.add(goToLoginButton);

            //
            JButton goToSearchButton = new JButton("Search");
            goToSearchButton.setFont(normalFont);
            goToSearchButton.setBackground(Color.WHITE);
            goToSearchButton.setFocusPainted(false);
            goToSearchButton.addActionListener(cHandler);
            goToSearchButton.setActionCommand("search");
            headerPanel.add(goToSearchButton);

        }

        //// Main Panel Content
        public void createSearchPanel(NavigationChoiceHandler cHandler, JPanel panel) {

            //// Search Panel

            //Search button
            searchBooksPanel = new JPanel();
            searchBooksPanel.setBackground(Color.white);
            searchBooksPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 5));
            panel.add(searchBooksPanel);

            //search fields with labels

            //search field
            JTextField searchField = new JTextField();
            searchField.setPreferredSize(new Dimension(550, 30));
            searchField.setBackground(Color.lightGray);
            searchBooksPanel.add(searchField);

            JButton searchButton = new JButton("Search");
            searchButton.setBackground(Color.black);
            searchButton.setForeground(Color.white);
            searchButton.setFont(normalFont);
            searchButton.setFocusPainted(false);

            searchButton.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent event){
                    _bookService.findBooks(searchField.getText());
                }
            });
            searchBooksPanel.add(searchButton);
        }

        //// Login Panel / Screen

    public void createLoginPanel(NavigationChoiceHandler cHandler, JPanel panel) {

        //username text field
        loginPanel = new JPanel();
        loginPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panel.add(loginPanel);

        //username label
        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setForeground(Color.black);
        usernameLabel.setFont(normalFont);
        loginPanel.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(200,30));
        usernameField.setBackground(Color.lightGray);
        loginPanel.add(usernameField);

        //password label
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setForeground(Color.black);
        passwordLabel.setFont(normalFont);
        loginPanel.add(passwordLabel);

        //password field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200,30));
        passwordField.setBackground(Color.lightGray);
        loginPanel.add(passwordField);

        //login button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(normalFont);
        loginButton.setBackground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent event){
                _userService.signInUser(usernameField.getText(), new String(passwordField.getPassword()));
            }
        });
        loginPanel.add(loginButton);



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
