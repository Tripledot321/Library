package Package1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

//min kommentar
public class GUI {

    JFrame frame;
    JPanel searchBooksPanel, loginPanel, myAccountPanel, registerUserPanel, adminPanel, addBookPanel, addDvdPanel, editLoanReservationPanel;
    Font bigFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font headerFont = new Font("SERIF", Font.BOLD, 26);
    Font normalFont = new Font("SERIF", Font.PLAIN, 26);
    Font smallFont = new Font("SERIF", Font.PLAIN, 16);
    Font buttonFont = new Font("SERIF", Font.PLAIN, 12);

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
        headerPanel.setBackground(Color.blue);
        headerPanel.setLayout(new FlowLayout());
        headerPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pane.add(headerPanel, BorderLayout.NORTH);
        headerPanel.setVisible(true);

        // Main Panel, den röda är alltid visible, denna är en container till allt innehåll
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.white);
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
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
            JButton goToMyAccountButton = new JButton("My account");
            goToMyAccountButton.setFont(normalFont);
            goToMyAccountButton.setBackground(Color.WHITE);
            goToMyAccountButton.setFocusPainted(false);
            goToMyAccountButton.addActionListener(cHandler);
            goToMyAccountButton.setActionCommand("myAccount");
            headerPanel.add(goToMyAccountButton);

            //navigate to my admin page button
            JButton goToAdminButton = new JButton("Admin");
            goToAdminButton.setFont(normalFont);
            goToAdminButton.setBackground(Color.WHITE);
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
                    var bookResult = _bookService.findBooks(searchField.getText());
                    showBooksResult( searchBooksPanel, bookResult);
                }
            });


            searchBooksPanel.add(searchButton);
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

            public void actionPerformed(ActionEvent event){
                _userService.signInUser(usernameField.getText(), new String(passwordField.getPassword()));
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
        registerUserPanel.setLayout(new GridLayout(10, 2, 10,5));
        panel.add(registerUserPanel);

        //header Add or Edit user
        JLabel header1Label = new JLabel("Add/Edit user");
        header1Label.setForeground(Color.black);
        header1Label.setFont(normalFont);
        registerUserPanel.add(header1Label);
        JLabel header2Label = new JLabel("(User will be edited if they exist)");
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

        //user lastname label and textfield
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
        JCheckBox removeUser = new JCheckBox();
        registerUserPanel.add(removeUser);

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

        //cancel register user button
        JButton cancelRegisterUserButton = new JButton("Cancel");
        cancelRegisterUserButton.setFont(normalFont);
        cancelRegisterUserButton.setBackground(Color.WHITE);
        cancelRegisterUserButton.setPreferredSize(new Dimension(150,30));
        cancelRegisterUserButton.setFocusPainted(false);
        cancelRegisterUserButton.addActionListener(cHandler);
        cancelRegisterUserButton.setActionCommand("cancelRegisterUser");
        registerUserPanel.add(cancelRegisterUserButton);

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

        //barcode
        JLabel barcodeLabel = new JLabel("Barcode: ");
        barcodeLabel.setForeground(Color.black);
        barcodeLabel.setFont(normalFont);
        addBookPanel.add(barcodeLabel);
        JTextField barcodeTextField = new JTextField();
        barcodeTextField.setPreferredSize(new Dimension(400,30));
        barcodeTextField.setBackground(Color.lightGray);
        addBookPanel.add(barcodeTextField);

        //physical location
        JLabel physicalLocationLabel = new JLabel("Physical location: ");
        physicalLocationLabel.setForeground(Color.black);
        physicalLocationLabel.setFont(normalFont);
        addBookPanel.add(physicalLocationLabel);
        JTextField physicalLocationTextField = new JTextField();
        physicalLocationTextField.setPreferredSize(new Dimension(400,30));
        physicalLocationTextField.setBackground(Color.lightGray);
        addBookPanel.add(physicalLocationTextField);

        //status
        JLabel statusLabel = new JLabel("Status: ");
        statusLabel.setForeground(Color.black);
        statusLabel.setFont(normalFont);
        addBookPanel.add(statusLabel);
        JTextField statusTextField = new JTextField();
        statusTextField.setPreferredSize(new Dimension(400,30));
        statusTextField.setBackground(Color.lightGray);
        addBookPanel.add(statusTextField);

        //remove book check box
        JLabel removeBookLabel = new JLabel("CHECK BOX TO REMOVE ITEM");
        removeBookLabel.setForeground(Color.black);
        removeBookLabel.setFont(normalFont);
        addBookPanel.add(removeBookLabel);
        JCheckBox removeBook = new JCheckBox();
        addBookPanel.add(removeBook);

        //SHOULD PROMPT ARE YOU SURE YOU WISH TO REMOVE BOOK

        //register user button
        JButton registerUserButton = new JButton("Register");
        registerUserButton.setFont(normalFont);
        registerUserButton.setBackground(Color.WHITE);
        registerUserButton.setPreferredSize(new Dimension(150,30));
        registerUserButton.setFocusPainted(false);
        registerUserButton.addActionListener(cHandler);
        registerUserButton.setActionCommand("registerBook");
        addBookPanel.add(registerUserButton);

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

        //header Add or Edit user
        JLabel header1Label = new JLabel("Add/Edit/Delete");
        header1Label.setForeground(Color.black);
        header1Label.setFont(normalFont);
        addDvdPanel.add(header1Label);
        JLabel header2Label = new JLabel("Books/Articles..");
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

        //ISBN
        JLabel isbnLabel = new JLabel("ISBN: ");
        isbnLabel.setForeground(Color.black);
        isbnLabel.setFont(normalFont);
        addDvdPanel.add(isbnLabel);
        JTextField isbnTextField = new JTextField();
        isbnTextField.setPreferredSize(new Dimension(400,30));
        isbnTextField.setBackground(Color.lightGray);
        addDvdPanel.add(isbnTextField);

        //publisher
        JLabel publisherLabel = new JLabel("Publisher: ");
        publisherLabel.setForeground(Color.black);
        publisherLabel.setFont(normalFont);
        addDvdPanel.add(publisherLabel);
        JTextField publisherTextField = new JTextField();
        publisherTextField.setPreferredSize(new Dimension(400,30));
        publisherTextField.setBackground(Color.lightGray);
        addDvdPanel.add(publisherTextField);

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
        JLabel yopLabel = new JLabel("Year of publication: ");
        yopLabel.setForeground(Color.black);
        yopLabel.setFont(normalFont);
        addDvdPanel.add(yopLabel);
        JTextField yopTextField = new JTextField();
        yopTextField.setPreferredSize(new Dimension(400,30));
        yopTextField.setBackground(Color.lightGray);
        addDvdPanel.add(yopTextField);

        //classification
        JLabel classificationLabel = new JLabel("Classification: ");
        classificationLabel.setForeground(Color.black);
        classificationLabel.setFont(normalFont);
        addDvdPanel.add(classificationLabel);
        JTextField classificationTextField = new JTextField();
        classificationTextField.setPreferredSize(new Dimension(400,30));
        classificationTextField.setBackground(Color.lightGray);
        addDvdPanel.add(classificationTextField);

        //barcode
        JLabel barcodeLabel = new JLabel("Barcode: ");
        barcodeLabel.setForeground(Color.black);
        barcodeLabel.setFont(normalFont);
        addDvdPanel.add(barcodeLabel);
        JTextField barcodeTextField = new JTextField();
        barcodeTextField.setPreferredSize(new Dimension(400,30));
        barcodeTextField.setBackground(Color.lightGray);
        addDvdPanel.add(barcodeTextField);

        //physical location
        JLabel physicalLocationLabel = new JLabel("Physical location: ");
        physicalLocationLabel.setForeground(Color.black);
        physicalLocationLabel.setFont(normalFont);
        addDvdPanel.add(physicalLocationLabel);
        JTextField physicalLocationTextField = new JTextField();
        physicalLocationTextField.setPreferredSize(new Dimension(400,30));
        physicalLocationTextField.setBackground(Color.lightGray);
        addDvdPanel.add(physicalLocationTextField);

        //status
        JLabel statusLabel = new JLabel("Status: ");
        statusLabel.setForeground(Color.black);
        statusLabel.setFont(normalFont);
        addDvdPanel.add(statusLabel);
        JTextField statusTextField = new JTextField();
        statusTextField.setPreferredSize(new Dimension(400,30));
        statusTextField.setBackground(Color.lightGray);
        addDvdPanel.add(statusTextField);

        //remove DVD check box
        JLabel removeDvdLabel = new JLabel("CHECK BOX TO REMOVE ITEM");
        removeDvdLabel.setForeground(Color.black);
        removeDvdLabel.setFont(normalFont);
        addDvdPanel.add(removeDvdLabel);
        JCheckBox removeDvd = new JCheckBox();
        addDvdPanel.add(removeDvd);

        //SHOULD PROMPT ARE YOU SURE YOU WISH TO REMOVE DVD

        //register user button
        JButton registerUserButton = new JButton("Register");
        registerUserButton.setFont(normalFont);
        registerUserButton.setBackground(Color.WHITE);
        registerUserButton.setPreferredSize(new Dimension(150,30));
        registerUserButton.setFocusPainted(false);
        registerUserButton.addActionListener(cHandler);
        registerUserButton.setActionCommand("registerBook");
        addDvdPanel.add(registerUserButton);

        //cancel register user button
        JButton cancelRegisterUserButton = new JButton("Cancel");
        cancelRegisterUserButton.setFont(normalFont);
        cancelRegisterUserButton.setBackground(Color.WHITE);
        cancelRegisterUserButton.setPreferredSize(new Dimension(150,30));
        cancelRegisterUserButton.setFocusPainted(false);
        cancelRegisterUserButton.addActionListener(cHandler);
        cancelRegisterUserButton.setActionCommand("cancelRegisterUser");
        addDvdPanel.add(cancelRegisterUserButton);

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
        JLabel userIdLabel = new JLabel("UserID: ");
        userIdLabel.setForeground(Color.black);
        userIdLabel.setFont(normalFont);
        editLoanReservationPanel.add(userIdLabel);
        JTextField userIdTextField = new JTextField();
        userIdTextField.setPreferredSize(new Dimension(400,30));
        userIdTextField.setBackground(Color.lightGray);
        editLoanReservationPanel.add(userIdTextField);


        //remove DVD check box
        JLabel removeLoanReservationLabel = new JLabel("CHECK BOX TO REMOVE LOAN/RESERVATION");
        removeLoanReservationLabel.setForeground(Color.black);
        removeLoanReservationLabel.setFont(normalFont);
        editLoanReservationPanel.add(removeLoanReservationLabel);
        JCheckBox removeLoanReservation = new JCheckBox();
        editLoanReservationPanel.add(removeLoanReservation);

        //SHOULD PROMPT ARE YOU SURE YOU WISH TO REMOVE LOAN/RESERVATION

        //register user button
        JButton registerUserButton = new JButton("Register");
        registerUserButton.setFont(normalFont);
        registerUserButton.setBackground(Color.WHITE);
        registerUserButton.setPreferredSize(new Dimension(150,30));
        registerUserButton.setFocusPainted(false);
        registerUserButton.addActionListener(cHandler);
        registerUserButton.setActionCommand("registerLoanReservation");
        editLoanReservationPanel.add(registerUserButton);

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
