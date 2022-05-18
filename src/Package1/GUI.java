package Package1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

//min kommentar
public class GUI {

    JFrame frame;
    JPanel searchBooksPanel, loginPanel, myAccountPanel, registerUserPanel, adminPanel, addBookPanel, addDvdPanel, editLoanReservationPanel;
    JButton goToMyAccountButton, goToAdminButton;
    Font bigFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font headerFont = new Font("SERIF", Font.BOLD, 26);
    Font normalFont = new Font("SERIF", Font.PLAIN, 26);
    Font smallFont = new Font("SERIF", Font.PLAIN, 16);
    Font buttonFont = new Font("SERIF", Font.PLAIN, 12);

    private BookService _bookService;
    private UserService _userService;
    //testar nedan
    //private List<String> bookResult;

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
        headerPanel.setBackground(Color.blue);
        headerPanel.setLayout(new FlowLayout());
        headerPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pane.add(headerPanel, BorderLayout.NORTH);
        headerPanel.setVisible(true);

        // Main Panel, den röda är alltid visible, denna är en container till allt innehåll
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.white);
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        //mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        pane.add(mainPanel, BorderLayout.CENTER);
        mainPanel.setVisible(true);


        populateHeaderPanel(cHandler, headerPanel);
        createLoginPanel(cHandler, mainPanel);
        createSearchPanel(cHandler, mainPanel);
        createMyAccountPanel(cHandler, mainPanel);
        createAdminPanel(cHandler, mainPanel);
        createRegisterUserPanel(cHandler, mainPanel);
        createAddBookPanel(cHandler, mainPanel);
        createAddDvdPanel(cHandler,mainPanel);
        createEditLoanReservationPanel(cHandler, mainPanel);

        frame.pack();

    }

    public void populateHeaderPanel(NavigationChoiceHandler cHandler, JPanel headerPanel) {


            //// Header Panel Content

            //lägg till saker i headerPanel
            JLabel titleNameLabel = new JLabel("LTU Library");
            titleNameLabel.setForeground(Color.white);
            titleNameLabel.setFont(bigFont);
            headerPanel.add(titleNameLabel);

            //navigate to login page button
            JButton goToLoginButton = new JButton("Login");
            goToLoginButton.setFont(normalFont);
            goToLoginButton.setBackground(Color.WHITE);
            goToLoginButton.setFocusPainted(false);
            goToLoginButton.addActionListener(cHandler);
            goToLoginButton.setActionCommand("login");
            headerPanel.add(goToLoginButton);

            //navigate to search page button
            JButton goToSearchButton = new JButton("Search");
            goToSearchButton.setFont(normalFont);
            goToSearchButton.setBackground(Color.WHITE);
            goToSearchButton.setFocusPainted(false);
            goToSearchButton.addActionListener(cHandler);
            goToSearchButton.setActionCommand("search");
            headerPanel.add(goToSearchButton);

            //navigate to my account page button
            goToMyAccountButton = new JButton("My account");
            goToMyAccountButton.setFont(normalFont);
            goToMyAccountButton.setBackground(Color.WHITE);
            goToMyAccountButton.setFocusPainted(false);
            goToMyAccountButton.setVisible(false);
            goToMyAccountButton.addActionListener(cHandler);
            goToMyAccountButton.setActionCommand("myAccount");
            headerPanel.add(goToMyAccountButton);

            //navigate to my admin page button
            goToAdminButton = new JButton("Admin");
            goToAdminButton.setFont(normalFont);
            goToAdminButton.setBackground(Color.WHITE);
            goToAdminButton.setVisible(false);
            goToAdminButton.setFocusPainted(false);
            goToAdminButton.addActionListener(cHandler);
            goToAdminButton.setActionCommand("admin");
            headerPanel.add(goToAdminButton);




    }

        //// HÄR STARTAR Main Panel Content, VARJE METOD ÄR EN 'SIDA' T.EX. LOGINSIDAN...

    public void createSearchPanel(NavigationChoiceHandler cHandler, JPanel panel) {

            //// Search Panel

            //Search button
            searchBooksPanel = new JPanel();
            searchBooksPanel.setBackground(Color.white);
            //searchBooksPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 5));
            searchBooksPanel.setLayout(new BorderLayout());
            panel.add(searchBooksPanel);

            JPanel resultsPanel = new JPanel();
            resultsPanel.setBackground(Color.white);
            resultsPanel.setLayout(new BoxLayout(resultsPanel, BoxLayout.Y_AXIS));
            panel.add(resultsPanel);
            //search fields with labels

            //search field
            JTextField searchField = new JTextField();
            searchField.setPreferredSize(new Dimension(550, 30));
            searchField.setBackground(Color.lightGray);
            searchBooksPanel.add(searchField, BorderLayout.CENTER);



            JButton searchButton = new JButton("Search");
            searchButton.setBackground(Color.black);
            searchButton.setForeground(Color.white);
            searchButton.setFont(normalFont);
            searchButton.setFocusPainted(false);
            searchBooksPanel.add(searchButton, BorderLayout.LINE_END);

                //egen actionListner för denna knapp
            searchButton.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent event){

                    var bookResult = _bookService.findBooks(searchField.getText());
                    String bookResultString = bookResult.toString();

                    JLabel bookResultsLabel = new JLabel();
                    JLabel noResults = new JLabel();

                    //searchbookspanel ska ha en annan panel i sig, och sen kan jag setvisible
                    //gör detta searchBooksPanel.removeAll(); i resultatspanelen som ligger i searchbookspanel
                    //en label som varierar beroende på resultatet

                    //fråga Tomas den blir crazy andra ggn när man söker och gör inte raderna nedan?
                    noResults.setVisible(false);
                    bookResultsLabel.setVisible(false);
                    searchBooksPanel.remove(noResults);
                    searchBooksPanel.remove(bookResultsLabel);
                    frame.pack();

                    if(!bookResult.isEmpty()) {
                        System.out.println("I found a result");
                        bookResultsLabel = new JLabel(bookResultString);
                        bookResultsLabel.setVisible(true);
                        bookResultsLabel.setFont(smallFont);
                        searchBooksPanel.add(bookResultsLabel, BorderLayout.PAGE_END);
                        System.out.println(bookResult);
                        frame.pack();
                    }
                    else{
                        System.out.println("No search results found in DataBase when button was clicked");
                        noResults = new JLabel("No search results found");
                        noResults.setVisible(true);
                        noResults.setForeground(Color.black);
                        noResults.setFont(normalFont);
                        searchBooksPanel.add(noResults, BorderLayout.PAGE_END);
                        frame.pack();
                    }
                }
            });

    }

    private void showBooksResult(JPanel searchBooksPanel, List<String> bookResult) {
        // Create table
        /// populate table
        // show table in searchbookPanel

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

            //här borde kommentaren dyka upp
            public void actionPerformed(ActionEvent event){
                _userService.signInUser(usernameField.getText(), new String(passwordField.getPassword()));
                //refresha knapparna
                cHandler.actionPerformed(event);
            }
        });
        loginPanel.add(loginButton);

        JLabel loginScreenLabel = new JLabel("Please enter your username and password");
        loginScreenLabel.setForeground(Color.black);
        loginScreenLabel.setFont(normalFont);
        loginScreenLabel.setVisible(false);
        loginPanel.add(loginScreenLabel);


    }

    //mina sidor

    public void createMyAccountPanel(NavigationChoiceHandler cHandler, JPanel panel) {

        myAccountPanel = new JPanel();
        myAccountPanel.setLayout(new BoxLayout(myAccountPanel, BoxLayout.Y_AXIS));
        panel.add(myAccountPanel);

        //username label
        JLabel usernameLabel = new JLabel("User:");
        usernameLabel.setForeground(Color.black);
        usernameLabel.setFont(headerFont);
        myAccountPanel.add(usernameLabel);

        //active loans label
        JLabel myLoansLabel = new JLabel("My active loans: ");
        myLoansLabel.setForeground(Color.black);
        myLoansLabel.setFont(headerFont);
        myAccountPanel.add(myLoansLabel);

    }

    public void createAdminPanel(NavigationChoiceHandler cHandler, JPanel panel){

        adminPanel = new JPanel();
        adminPanel.setLayout(new BoxLayout(adminPanel, BoxLayout.Y_AXIS));
        panel.add(adminPanel);

        JLabel adminLabel = new JLabel("Administrative functions");
        adminLabel.setForeground(Color.black);
        adminLabel.setFont(headerFont);
        adminPanel.add(adminLabel);

        //Knapp add/edit user
        JButton goToRegisterUserButton = new JButton("Add/Edit/Remove User");
        goToRegisterUserButton.setFont(normalFont);
        goToRegisterUserButton.setBackground(Color.WHITE);
        goToRegisterUserButton.setFocusPainted(false);
        goToRegisterUserButton.setPreferredSize(new Dimension(300,30));
        goToRegisterUserButton.addActionListener(cHandler);
        goToRegisterUserButton.setActionCommand("registerUser");
        adminPanel.add(goToRegisterUserButton);

        //Knapp add/edit/remove book
        JButton goToRegisterBookButton = new JButton("Add/Edit/Remove Books, Articles..");
        goToRegisterBookButton.setFont(normalFont);
        goToRegisterBookButton.setBackground(Color.WHITE);
        goToRegisterBookButton.setFocusPainted(false);
        goToRegisterBookButton.setPreferredSize(new Dimension(300,30));
        goToRegisterBookButton.addActionListener(cHandler);
        goToRegisterBookButton.setActionCommand("registerBook");
        adminPanel.add(goToRegisterBookButton);

        //Knapp add/edit object
        JButton goToRegisterDvdButton = new JButton("Add/Edit/Remove DVD");
        goToRegisterDvdButton.setFont(normalFont);
        goToRegisterDvdButton.setBackground(Color.WHITE);
        goToRegisterDvdButton.setFocusPainted(false);
        goToRegisterDvdButton.setPreferredSize(new Dimension(300,30));
        goToRegisterDvdButton.addActionListener(cHandler);
        goToRegisterDvdButton.setActionCommand("registerDvd");
        adminPanel.add(goToRegisterDvdButton);

        //Knapp add/edit object
        JButton goToEditLoanReservationButton = new JButton("Add/Edit/Remove Loan/Reservation");
        goToEditLoanReservationButton.setFont(normalFont);
        goToEditLoanReservationButton.setBackground(Color.WHITE);
        goToEditLoanReservationButton.setFocusPainted(false);
        goToEditLoanReservationButton.setPreferredSize(new Dimension(300,30));
        goToEditLoanReservationButton.addActionListener(cHandler);
        goToEditLoanReservationButton.setActionCommand("editLoanReservation");
        adminPanel.add(goToEditLoanReservationButton);
    }

    public void createRegisterUserPanel(NavigationChoiceHandler cHandler, JPanel panel) {

        //username text field
        registerUserPanel = new JPanel();
        registerUserPanel.setLayout(new GridLayout(12, 2, 10,5));
        panel.add(registerUserPanel);

        //header Add or Edit user
        JLabel header1Label = new JLabel("ADD/EDIT/REMOVE USER");
        header1Label.setForeground(Color.black);
        header1Label.setFont(normalFont);
        registerUserPanel.add(header1Label);
        JLabel header2Label = new JLabel("");
        header2Label.setForeground(Color.black);
        header2Label.setFont(normalFont);
        registerUserPanel.add(header2Label);

        //user firstname label and textfield
        JLabel firstnameLabel = new JLabel("First name: ");
        firstnameLabel.setForeground(Color.black);
        firstnameLabel.setFont(normalFont);
        registerUserPanel.add(firstnameLabel);
        JTextField firstNameTextField = new JTextField();
        firstNameTextField.setPreferredSize(new Dimension(400,30));
        firstNameTextField.setBackground(Color.lightGray);
        registerUserPanel.add(firstNameTextField);

        //user lastname label and textfield
        JLabel lastnameLabel = new JLabel("Last name: ");
        lastnameLabel.setForeground(Color.black);
        lastnameLabel.setFont(normalFont);
        registerUserPanel.add(lastnameLabel);
        JTextField lastnameTextField = new JTextField();
        lastnameTextField.setPreferredSize(new Dimension(400,30));
        lastnameTextField.setBackground(Color.lightGray);
        registerUserPanel.add(lastnameTextField);

        //user email label and textfield
        JLabel emailLabel = new JLabel("E-mail: ");
        emailLabel.setForeground(Color.black);
        emailLabel.setFont(normalFont);
        registerUserPanel.add(emailLabel);
        JTextField emailTextField = new JTextField();
        emailTextField.setPreferredSize(new Dimension(400,30));
        emailTextField.setBackground(Color.lightGray);
        registerUserPanel.add(emailTextField);

        //user personnummer label and textfield
        JLabel personnummerLabel = new JLabel("Personal number: ");
        personnummerLabel.setForeground(Color.black);
        personnummerLabel.setFont(normalFont);
        registerUserPanel.add(personnummerLabel);
        JTextField personnummerTextField = new JTextField();
        personnummerTextField.setPreferredSize(new Dimension(400,30));
        personnummerTextField.setBackground(Color.lightGray);
        registerUserPanel.add(personnummerTextField);

        //user phonenumber label and textfield
        JLabel phonenumberLabel = new JLabel("Phone number: ");
        phonenumberLabel.setForeground(Color.black);
        phonenumberLabel.setFont(normalFont);
        registerUserPanel.add(phonenumberLabel);
        JTextField phonenumberTextField = new JTextField();
        phonenumberTextField.setPreferredSize(new Dimension(400,30));
        phonenumberTextField.setBackground(Color.lightGray);
        registerUserPanel.add(phonenumberTextField);

        //user username label and textfield
        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setForeground(Color.black);
        usernameLabel.setFont(normalFont);
        registerUserPanel.add(usernameLabel);
        JTextField usernameTextField = new JTextField();
        usernameTextField.setPreferredSize(new Dimension(400,30));
        usernameTextField.setBackground(Color.lightGray);
        registerUserPanel.add(usernameTextField);

        //user password label and textfield
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setForeground(Color.black);
        passwordLabel.setFont(normalFont);
        registerUserPanel.add(passwordLabel);
        JTextField passwordTextField = new JTextField();
        passwordTextField.setPreferredSize(new Dimension(400,30));
        passwordTextField.setBackground(Color.lightGray);
        registerUserPanel.add(passwordTextField);

        //user account type label and dropdown menu
        JLabel accountTypeLabel = new JLabel("Account type: ");
        accountTypeLabel.setForeground(Color.black);
        accountTypeLabel.setFont(normalFont);
        registerUserPanel.add(accountTypeLabel);
        String[] accountTypeOptions = {"Standard", "Staff", "Admin"};
        JComboBox<String> accountTypeComboBox = new JComboBox<>(accountTypeOptions);
        registerUserPanel.add(accountTypeComboBox);

        JLabel removeUserLabel = new JLabel("CHECK BOX TO REMOVE USER");
        removeUserLabel.setForeground(Color.black);
        removeUserLabel.setFont(normalFont);
        registerUserPanel.add(removeUserLabel);
        JCheckBox removeUserCheckbox = new JCheckBox();
        registerUserPanel.add(removeUserCheckbox);

        JLabel editUserLabel = new JLabel("CHECK BOX TO EDIT USER");
        editUserLabel.setForeground(Color.black);
        editUserLabel.setFont(normalFont);
        registerUserPanel.add(editUserLabel);
        JCheckBox editUserCheckbox = new JCheckBox();
        registerUserPanel.add(editUserCheckbox);

        //SHOULD PROMPT ARE YOU SURE YOU WISH TO REMOVE USER

        //register user button
        JButton registerUserButton = new JButton("Register");
        registerUserButton.setFont(normalFont);
        registerUserButton.setBackground(Color.WHITE);
        registerUserButton.setPreferredSize(new Dimension(150,30));
        registerUserButton.setFocusPainted(false);
        registerUserButton.addActionListener(cHandler);
        registerUserButton.setActionCommand("registerUser");
        registerUserPanel.add(registerUserButton);
        //HÄR SKAPAR VI ATT KNAPPEN SKA INSERT ALLT I DATABASEN PÅ ANVÄNDARE...
        registerUserButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent event){

                String removeUser;
                    if(removeUserCheckbox.isSelected()){
                        removeUser = "remove";
                    }
                    else{
                        removeUser = "do not remove";
                    }
                String editUser;
                    if(editUserCheckbox.isSelected()){
                        editUser = "edit";
                    }
                    else{
                        editUser = "do not edit";
                    }
                _userService.updateUser(firstNameTextField.getText(), lastnameTextField.getText(), emailTextField.getText(), personnummerTextField.getText(), phonenumberTextField.getText(), accountTypeComboBox.getName(), usernameTextField.getText(), passwordTextField.getText(), removeUser, editUser);

                }
            });
    }

    public void createAddBookPanel(NavigationChoiceHandler cHandler, JPanel panel) {

        //username text field
        addBookPanel = new JPanel();
        addBookPanel.setLayout(new GridLayout(15, 2, 10,5));
        panel.add(addBookPanel);

        //header Add or Edit user
        JLabel header1Label = new JLabel("Add/Edit/Delete");
        header1Label.setForeground(Color.black);
        header1Label.setFont(normalFont);
        addBookPanel.add(header1Label);
        JLabel header2Label = new JLabel("Books/Articles..");
        header2Label.setForeground(Color.black);
        header2Label.setFont(normalFont);
        addBookPanel.add(header2Label);

        //title
        JLabel titleLabel = new JLabel("Title: ");
        titleLabel.setForeground(Color.black);
        titleLabel.setFont(normalFont);
        addBookPanel.add(titleLabel);
        JTextField titleTextField = new JTextField();
        titleTextField.setPreferredSize(new Dimension(400,30));
        titleTextField.setBackground(Color.lightGray);
        addBookPanel.add(titleTextField);

        //ISBN
        JLabel isbnLabel = new JLabel("ISBN: ");
        isbnLabel.setForeground(Color.black);
        isbnLabel.setFont(normalFont);
        addBookPanel.add(isbnLabel);
        JTextField isbnTextField = new JTextField();
        isbnTextField.setPreferredSize(new Dimension(400,30));
        isbnTextField.setBackground(Color.lightGray);
        addBookPanel.add(isbnTextField);

        //publisher
        JLabel publisherLabel = new JLabel("Publisher: ");
        publisherLabel.setForeground(Color.black);
        publisherLabel.setFont(normalFont);
        addBookPanel.add(publisherLabel);
        JTextField publisherTextField = new JTextField();
        publisherTextField.setPreferredSize(new Dimension(400,30));
        publisherTextField.setBackground(Color.lightGray);
        addBookPanel.add(publisherTextField);

        //Category
        JLabel categoryLabel = new JLabel("Category: ");
        categoryLabel.setForeground(Color.black);
        categoryLabel.setFont(normalFont);
        addBookPanel.add(categoryLabel);
        JTextField categoryTextField = new JTextField();
        categoryTextField.setPreferredSize(new Dimension(400,30));
        categoryTextField.setBackground(Color.lightGray);
        addBookPanel.add(categoryTextField);

        //year of publication
        JLabel yopLabel = new JLabel("Year of publication: ");
        yopLabel.setForeground(Color.black);
        yopLabel.setFont(normalFont);
        addBookPanel.add(yopLabel);
        JTextField yopTextField = new JTextField();
        yopTextField.setPreferredSize(new Dimension(400,30));
        yopTextField.setBackground(Color.lightGray);
        addBookPanel.add(yopTextField);

        //classification
        JLabel classificationLabel = new JLabel("Classification: ");
        classificationLabel.setForeground(Color.black);
        classificationLabel.setFont(normalFont);
        addBookPanel.add(classificationLabel);
        JTextField classificationTextField = new JTextField();
        classificationTextField.setPreferredSize(new Dimension(400,30));
        classificationTextField.setBackground(Color.lightGray);
        addBookPanel.add(classificationTextField);


        //edit book check box
        JLabel editBookLabel = new JLabel("CHECK BOX TO EDIT ITEM");
        editBookLabel.setForeground(Color.black);
        editBookLabel.setFont(normalFont);
        addBookPanel.add(editBookLabel);
        JCheckBox editBookCheckBox = new JCheckBox();
        addBookPanel.add(editBookCheckBox);


        //remove book check box
        JLabel removeBookLabel = new JLabel("CHECK BOX TO REMOVE ITEM");
        removeBookLabel.setForeground(Color.black);
        removeBookLabel.setFont(normalFont);
        addBookPanel.add(removeBookLabel);
        JCheckBox removeBookCheckBox = new JCheckBox();
        addBookPanel.add(removeBookCheckBox);


        //SHOULD PROMPT ARE YOU SURE YOU WISH TO REMOVE BOOK

        //register button
        JButton registerBookButton = new JButton("Register");
        registerBookButton.setFont(normalFont);
        registerBookButton.setBackground(Color.WHITE);
        registerBookButton.setPreferredSize(new Dimension(150,30));
        registerBookButton.setFocusPainted(false);
        registerBookButton.addActionListener(cHandler);
        registerBookButton.setActionCommand("registerBook");
        addBookPanel.add(registerBookButton);
        registerBookButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent event){

                String removeBook = "do not remove";

                if(removeBookCheckBox.isSelected()){
                    removeBook = "remove";
                }


                String editBook = "do not edit";
                if(editBookCheckBox.isSelected()){
                    editBook = "edit";
                }


                _bookService.updateBook(isbnTextField.getText(), publisherTextField.getText(), categoryTextField.getText(), titleTextField.getText(), yopTextField.getText(), classificationTextField.getText(), removeBook, editBook);

            }
        });

        //cancel register user button
        JButton cancelRegisterUserButton = new JButton("Cancel");
        cancelRegisterUserButton.setFont(normalFont);
        cancelRegisterUserButton.setBackground(Color.WHITE);
        cancelRegisterUserButton.setPreferredSize(new Dimension(150,30));
        cancelRegisterUserButton.setFocusPainted(false);
        cancelRegisterUserButton.addActionListener(cHandler);
        cancelRegisterUserButton.setActionCommand("cancelRegisterUser");
        addBookPanel.add(cancelRegisterUserButton);

    }

    public void createAddDvdPanel(NavigationChoiceHandler cHandler, JPanel panel) {

        //username text field
        addDvdPanel = new JPanel();
        addDvdPanel.setLayout(new GridLayout(15, 2, 10,5));
        panel.add(addDvdPanel);

        //header Add or Edit DVD
        JLabel header1Label = new JLabel("Add/Edit/Delete DVD");
        header1Label.setForeground(Color.black);
        header1Label.setFont(normalFont);
        addDvdPanel.add(header1Label);
        JLabel header2Label = new JLabel("");
        header2Label.setForeground(Color.black);
        header2Label.setFont(normalFont);
        addDvdPanel.add(header2Label);

        //title
        JLabel titleLabel = new JLabel("Title: ");
        titleLabel.setForeground(Color.black);
        titleLabel.setFont(normalFont);
        addDvdPanel.add(titleLabel);
        JTextField titleTextField = new JTextField();
        titleTextField.setPreferredSize(new Dimension(400,30));
        titleTextField.setBackground(Color.lightGray);
        addDvdPanel.add(titleTextField);

        //director
        JLabel directorLabel = new JLabel("Director: ");
        directorLabel.setForeground(Color.black);
        directorLabel.setFont(normalFont);
        addDvdPanel.add(directorLabel);
        JTextField directorTextField = new JTextField();
        directorTextField.setPreferredSize(new Dimension(400,30));
        directorTextField.setBackground(Color.lightGray);
        addDvdPanel.add(directorTextField);

        //producer
        JLabel producerLabel = new JLabel("Producer: ");
        producerLabel.setForeground(Color.black);
        producerLabel.setFont(normalFont);
        addDvdPanel.add(producerLabel);
        JTextField producerTextField = new JTextField();
        producerTextField.setPreferredSize(new Dimension(400,30));
        producerTextField.setBackground(Color.lightGray);
        addDvdPanel.add(producerTextField);

        //Category
        JLabel categoryLabel = new JLabel("Category: ");
        categoryLabel.setForeground(Color.black);
        categoryLabel.setFont(normalFont);
        addDvdPanel.add(categoryLabel);
        JTextField categoryTextField = new JTextField();
        categoryTextField.setPreferredSize(new Dimension(400,30));
        categoryTextField.setBackground(Color.lightGray);
        addDvdPanel.add(categoryTextField);

        //year of publication
        JLabel yopLabel = new JLabel("Classification: ");
        yopLabel.setForeground(Color.black);
        yopLabel.setFont(normalFont);
        addDvdPanel.add(yopLabel);
        JTextField yopTextField = new JTextField();
        yopTextField.setPreferredSize(new Dimension(400,30));
        yopTextField.setBackground(Color.lightGray);
        addDvdPanel.add(yopTextField);

        //classification
        JLabel classificationLabel = new JLabel("Year of publication: ");
        classificationLabel.setForeground(Color.black);
        classificationLabel.setFont(normalFont);
        addDvdPanel.add(classificationLabel);
        JTextField classificationTextField = new JTextField();
        classificationTextField.setPreferredSize(new Dimension(400,30));
        classificationTextField.setBackground(Color.lightGray);
        addDvdPanel.add(classificationTextField);

        //country
        JLabel countryLabel = new JLabel("Country: ");
        countryLabel.setForeground(Color.black);
        countryLabel.setFont(normalFont);
        addDvdPanel.add(countryLabel);
        JTextField countryTextField = new JTextField();
        countryTextField.setPreferredSize(new Dimension(400,30));
        countryTextField.setBackground(Color.lightGray);
        addDvdPanel.add(countryTextField);

        //edit dvd check box
        JLabel editDvdLabel = new JLabel("CHECK BOX TO EDIT ITEM");
        editDvdLabel.setForeground(Color.black);
        editDvdLabel.setFont(normalFont);
        addDvdPanel.add(editDvdLabel);
        JCheckBox editDvdCheckBox = new JCheckBox();
        addDvdPanel.add(editDvdCheckBox);

        //remove DVD check box
        JLabel removeDvdLabel = new JLabel("CHECK BOX TO REMOVE ITEM");
        removeDvdLabel.setForeground(Color.black);
        removeDvdLabel.setFont(normalFont);
        addDvdPanel.add(removeDvdLabel);
        JCheckBox removeDvdCheckBox = new JCheckBox();
        addDvdPanel.add(removeDvdCheckBox);

        //SHOULD PROMPT ARE YOU SURE YOU WISH TO REMOVE DVD

        //register dvd button
        JButton registerDvdButton = new JButton("Register");
        registerDvdButton.setFont(normalFont);
        registerDvdButton.setBackground(Color.WHITE);
        registerDvdButton.setPreferredSize(new Dimension(150,30));
        registerDvdButton.setFocusPainted(false);
        addDvdPanel.add(registerDvdButton);
        registerDvdButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent event){

                String removeDvd = "do not remove";

                if(removeDvdCheckBox.isSelected()){
                    removeDvd = "remove";
                }


                String editDvd = "do not edit";
                if(editDvdCheckBox.isSelected()){
                    editDvd = "edit";
                }


                _bookService.updateDvd(directorTextField.getText(), producerTextField.getText(), categoryTextField.getText(), classificationTextField.getText(), yopTextField.getText(), titleTextField.getText(), countryTextField.getText(), removeDvd, editDvd);

            }
        });

        //cancel register DVD button
        JButton cancelRegisterDvdButton = new JButton("Cancel");
        cancelRegisterDvdButton.setFont(normalFont);
        cancelRegisterDvdButton.setBackground(Color.WHITE);
        cancelRegisterDvdButton.setPreferredSize(new Dimension(150,30));
        cancelRegisterDvdButton.setFocusPainted(false);
        cancelRegisterDvdButton.addActionListener(cHandler);
        cancelRegisterDvdButton.setActionCommand("cancelRegisterUser");
        addDvdPanel.add(cancelRegisterDvdButton);

    }


    public void createEditLoanReservationPanel(NavigationChoiceHandler cHandler, JPanel panel) {

        //username text field
        editLoanReservationPanel = new JPanel();
        editLoanReservationPanel.setLayout(new GridLayout(15, 2, 10,5));
        panel.add(editLoanReservationPanel);

        //header Add or Edit user
        JLabel header1Label = new JLabel("Add/Delete");
        header1Label.setForeground(Color.black);
        header1Label.setFont(normalFont);
        editLoanReservationPanel.add(header1Label);
        JLabel header2Label = new JLabel("Loans/Reservations");
        header2Label.setForeground(Color.black);
        header2Label.setFont(normalFont);
        editLoanReservationPanel.add(header2Label);

        //Barcode
        JLabel barcodeLabel = new JLabel("Item barcode: ");
        barcodeLabel.setForeground(Color.black);
        barcodeLabel.setFont(normalFont);
        editLoanReservationPanel.add(barcodeLabel);
        JTextField barcodeTextField = new JTextField();
        barcodeTextField.setPreferredSize(new Dimension(400,30));
        barcodeTextField.setBackground(Color.lightGray);
        editLoanReservationPanel.add(barcodeTextField);

        //UserID
        JLabel userPersonnummerLabel = new JLabel("User personnummer: ");
        userPersonnummerLabel.setForeground(Color.black);
        userPersonnummerLabel.setFont(normalFont);
        editLoanReservationPanel.add(userPersonnummerLabel);
        JTextField userPersonnummerTextField = new JTextField();
        userPersonnummerTextField.setPreferredSize(new Dimension(400,30));
        userPersonnummerTextField.setBackground(Color.lightGray);
        editLoanReservationPanel.add(userPersonnummerTextField);

        //remove loan/reservation check box
        JLabel removeLoanReservationLabel = new JLabel("CHECK BOX TO REMOVE LOAN/RESERVATION");
        removeLoanReservationLabel.setForeground(Color.black);
        removeLoanReservationLabel.setFont(normalFont);
        editLoanReservationPanel.add(removeLoanReservationLabel);
        JCheckBox removeLoanReservationCheckBox = new JCheckBox();
        editLoanReservationPanel.add(removeLoanReservationCheckBox);

        //SHOULD PROMPT ARE YOU SURE YOU WISH TO REMOVE LOAN/RESERVATION

        //register user button
        JButton registerLoanButton = new JButton("Register");
        registerLoanButton.setFont(normalFont);
        registerLoanButton.setBackground(Color.WHITE);
        registerLoanButton.setPreferredSize(new Dimension(150,30));
        registerLoanButton.setFocusPainted(false);
        registerLoanButton.addActionListener(cHandler);
        registerLoanButton.setActionCommand("registerLoanReservation");
        editLoanReservationPanel.add(registerLoanButton);
        registerLoanButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent event){

                String removeLoan = "do not remove";

                if(removeLoanReservationCheckBox.isSelected()){
                    removeLoan = "remove";
                }

                _userService.editLoanUser(userPersonnummerTextField.getText(), barcodeTextField.getText(), removeLoan);

            }
        });



        //cancel register user button
        JButton cancelRegisterUserButton = new JButton("Cancel");
        cancelRegisterUserButton.setFont(normalFont);
        cancelRegisterUserButton.setBackground(Color.WHITE);
        cancelRegisterUserButton.setPreferredSize(new Dimension(150,30));
        cancelRegisterUserButton.setFocusPainted(false);
        cancelRegisterUserButton.addActionListener(cHandler);
        cancelRegisterUserButton.setActionCommand("cancelRegisterUser");
        editLoanReservationPanel.add(cancelRegisterUserButton);

    }

    //SKAPA FÖLJANDE SIDOR

    //LÅNA BOK/RESERVERA BOK






}
