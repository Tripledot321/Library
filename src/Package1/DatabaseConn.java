package Package1;

import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

public class DatabaseConn {

    private Connection databaseConnection;
    private String url;
    private String username;
    private String password;

    public DatabaseConn(String Url, String user, String password) {
        this.url = Url;
        this.username = user;
        this.password = password;
    }

    private Connection getConnection(){
        try {

            if(databaseConnection != null && !databaseConnection.isClosed()) {
                return databaseConnection;
            }

            //testar enligt videon med koden nedan
            //Class.forName("com.mysql.jdbc.Driver");

            databaseConnection = DriverManager.getConnection(
                    "jdbc:mysql://"+url+"/libraryx?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    username, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return databaseConnection;
    }

    public List<String> getBooks(String searchTerm) {
        return new ArrayList<>();
    }

    public String insertUser(String userInfo){
        return userInfo;
    }

    public  List<String> selectUsers(String searchParameter) {


        List<String> searchResults = new ArrayList<>();

        try {


            Connection conn = getConnection();

            Statement stmt = conn.createStatement();

            String strSelect = "SELECT * from user WHERE FName='" + searchParameter + "'";



            ResultSet rset = stmt.executeQuery(strSelect);
            int rowCount = 0;

            while (rset.next()) {
                String firstName = rset.getString("Fname");
                String lastName = rset.getString("Lname");
                String email = rset.getString("Email");
                String personnummer = rset.getString("SSN");
                String phonenumber = rset.getString("PhoneNumber");
                int status = rset.getInt("Status");
                String AccountType = rset.getString("AccountType");


                String allInformation = firstName + " " + lastName + ", " + email + ", " + personnummer + ", " + phonenumber + ", Status: " + status + ", " + AccountType;

                searchResults.add(allInformation);
                ++rowCount;
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return searchResults;
    }

    public  List<String> selectBooks(String searchParameter) {

        List<String> searchResults = new ArrayList<>();

        try {


            Connection conn = getConnection();

            Statement stmt = conn.createStatement();

            String strSelect = "SELECT * from books WHERE title='"+searchParameter+"'";

            ResultSet rset = stmt.executeQuery(strSelect);
            int rowCount = 0;

            while (rset.next()) {

                String title = rset.getString("title");
                String ISBN = rset.getString("ISBN");
                String BookPublisher = rset.getString("BookPublisher");
                String BookCategory = rset.getString("BookCategory");
                String YearOfPublication = rset.getString("YearOfPublication");
                String Classification = rset.getString("Classification");

                String allInformation = title + ", " + ISBN + ", " + BookPublisher + ", " + BookCategory + ", " + YearOfPublication + ", " + Classification;

                searchResults.add(allInformation);
                ++rowCount;
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return searchResults;
    }

    public boolean validateUser (String username, String password) {

        boolean approvedUser = false;
        List<String> searchResults = new ArrayList<>();

        try {

            Connection conn = getConnection();

            Statement stmt = conn.createStatement();

            String strSelect = "SELECT Password FROM user WHERE Username = '"+username+"'";

            ResultSet rset = stmt.executeQuery(strSelect);

            int rowCount = 0;

            while (rset.next()) {

                String passwordFromDB = rset.getString("Password");

                    if(passwordFromDB.equals(password)){
                        approvedUser = true;
                    }
                ++rowCount;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return approvedUser;
    }


    public void addUser(String firstName, String lastName, String email, String personnummer, String phonenumber, String accountType, String username, String password) {

        try {

            Connection conn = getConnection();

            Statement stmt = conn.createStatement();

            String strInsert = "INSERT INTO user (Fname, Lname, Email, SSN, PhoneNumber, Status, Username, Password)" +
                    "VALUES ('"+firstName+"', '"+lastName+"', '"+email+"', '"+personnummer+"', '"+phonenumber+"', '1', '"+username+"', '"+password+"')";

            int rset = stmt.executeUpdate(strInsert);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateUser(String firstName, String lastName, String email, String personnummer, String phonenumber, String accountType, String username, String password) {

        try {

            Connection conn = getConnection();

            Statement stmt = conn.createStatement();

           String strUpdate = "UPDATE user SET Fname = '"+firstName+"', Lname = '"+lastName+"', Email = '"+email+"', PhoneNumber = '"+phonenumber+"', Username = '"+username+"', Password = '"+password+" WHERE ssn = '"+personnummer+"'";

            int rset = stmt.executeUpdate(strUpdate);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void removeUser(String personnummer) {
        try {
            Connection conn = getConnection();

            Statement stmt = conn.createStatement();

            String strDelete = "DELETE FROM user WHERE SSN='"+personnummer+"'";

            int rset = stmt.executeUpdate(strDelete);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addBook(String isbn, String bookPublisher, String bookCategory, String title, String yearOfPublication, String classification) {

        try {

            Connection conn = getConnection();

            Statement stmt = conn.createStatement();

            String strInsert = "INSERT INTO books (ISBN, BookPublisher, BookCategory, title, YearOfPublication, Classification)" +
                    "VALUES ('"+isbn+"', '"+bookPublisher+"', '"+bookCategory+"', '"+title+"', '"+yearOfPublication+"', '"+classification+"')";

            int rset = stmt.executeUpdate(strInsert);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateBook(String isbn, String bookPublisher, String bookCategory, String title, String yearOfPublication, String classification) {

        try {

            Connection conn = getConnection();

            Statement stmt = conn.createStatement();

            String strUpdate = "UPDATE books SET BookPublisher = '"+bookPublisher+"', BookCategory = '"+bookCategory+"', title = '"+title+"', YearOfPublication = '"+yearOfPublication+"' WHERE ISBN = '"+isbn+"'";

            int rset = stmt.executeUpdate(strUpdate);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void removeBook(String isbn) {
        try {
            Connection conn = getConnection();

            Statement stmt = conn.createStatement();

            String strDelete = "DELETE FROM books WHERE ISBN = '"+isbn+"'";

            int rset = stmt.executeUpdate(strDelete);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addDvd(String director, String producer, String dvdCategory, String classification, String yearOfPublication, String title, String country) {

        try {

            Connection conn = getConnection();

            Statement stmt = conn.createStatement();

            String strInsert = "INSERT INTO dvd (Director, Producer, DVDCategory, Classification, YearOfPublication, title, ProductionCountry)" +
                    "VALUES ('"+director+"', '"+producer+"', '"+dvdCategory+"', '"+classification+"', '"+yearOfPublication+"', '"+title+"', '"+country+"')";

            int rset = stmt.executeUpdate(strInsert);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateDvd(String director, String producer, String dvdCategory, String classification, String yearOfPublication, String title, String country) {

        try {

            Connection conn = getConnection();

            Statement stmt = conn.createStatement();

            String strUpdate = "UPDATE dvd SET Director = '"+director+"', Producer = '"+producer+"', DVDCategory = '"+dvdCategory+"', Classification = '"+classification+"', YearOfPublication = '"+yearOfPublication+"', ProductionCountry = '"+country+"' WHERE title = '"+title+"'";

            int rset = stmt.executeUpdate(strUpdate);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void removeDvd(String title) {
        try {
            Connection conn = getConnection();

            Statement stmt = conn.createStatement();

            String strDelete = "DELETE FROM dvd WHERE title = '"+title+"'";

            int rset = stmt.executeUpdate(strDelete);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addLoan(String personnummer, String barCode) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date todayDate = new Date();
        String todayDateString = dateFormat.format(todayDate);
        System.out.println("Start date: "+dateFormat.format(todayDate));


        // convert date to calendar
        Calendar cal = Calendar.getInstance();
        cal.setTime(todayDate);
        cal.add(Calendar.DATE, 21);

        // convert calendar to date
        Date endDate = cal.getTime();
        String endDateString = dateFormat.format(endDate);
        System.out.println("End date: "+dateFormat.format(endDate));

        String userIdFromDb = null;

        try {

            Connection conn = getConnection();

            Statement stmt = conn.createStatement();


            String strUserId = "SELECT UserID FROM user WHERE ssn = '"+personnummer+"'";

            ResultSet rset = stmt.executeQuery(strUserId);

            int rowCount = 0;

            while (rset.next()) {

                userIdFromDb = rset.getString("UserID");

                ++rowCount;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {

            Connection conn = getConnection();

            Statement stmt = conn.createStatement();

            String strInsert = "INSERT INTO loan (Startdate, Enddate, Barcode, UserId)" +
                    "VALUES ('"+todayDateString+"', '"+endDateString+"', '"+barCode+"', '"+userIdFromDb+"')";

            int rset = stmt.executeUpdate(strInsert);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void removeLoan(String barcode) {

        //Denna metod kanske egentligen borde uppdatera fältet Status, snarare än att ta bort lånet
        //men vi tänker att vi i databasen eventuellt kommer ha en tabell med 'lånhistorik' dit ett gammalt
        //lån flyttas

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date returnDate = new Date();
        String returnDateString = dateFormat.format(returnDate);
        System.out.println("Return date: "+dateFormat.format(returnDate));

        try {
            Connection conn = getConnection();

            Statement stmt = conn.createStatement();

            String strDelete = "DELETE FROM loan WHERE Barcode = '"+barcode+"'";

            int rset = stmt.executeUpdate(strDelete);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void removeReservation(String barcode, String personnummer) {

        //Denna metod kanske egentligen borde uppdatera fältet Status, snarare än att ta bort reservationen
        //men vi tänker att vi i databasen eventuellt kommer ha en tabell med 'reservationshistorik' dit en gammal
        //reservation flyttas

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date returnDate = new Date();
        String returnDateString = dateFormat.format(returnDate);
        System.out.println("Return date: "+dateFormat.format(returnDate));
        String userIdFromDb = null;

        //hämta ut userID baserat på personnummer
        try {

            Connection conn = getConnection();

            Statement stmt = conn.createStatement();


            String strUserId = "SELECT UserID FROM user WHERE ssn = '"+personnummer+"'";

            ResultSet rset = stmt.executeQuery(strUserId);

            int rowCount = 0;

            while (rset.next()) {

                userIdFromDb = rset.getString("UserID");

                ++rowCount;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            Connection conn = getConnection();

            Statement stmt = conn.createStatement();

            String strDelete = "DELETE FROM reservation WHERE Barcode = '"+barcode+"' AND UserID = '"+userIdFromDb+"'";

            int rset = stmt.executeUpdate(strDelete);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addReservation(String personnummer, String barcode) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date todayDate = new Date();
        String todayDateString = dateFormat.format(todayDate);
        System.out.println("Start date: "+dateFormat.format(todayDate));

        String userIdFromDb = null;

        try {

        Connection conn = getConnection();
        Statement stmt = conn.createStatement();

        String strUserId = "SELECT UserID FROM user WHERE ssn = '"+personnummer+"'";

        ResultSet rset = stmt.executeQuery(strUserId);

        int rowCount = 0;

            while (rset.next()) {

                userIdFromDb = rset.getString("UserID");

                ++rowCount;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {

            Connection conn = getConnection();

            Statement stmt = conn.createStatement();

            String strInsert = "INSERT INTO reservation (Startdate, ResStatus, UserID, Barcode)" +
                    "VALUES ('"+todayDateString+"', 'active', '"+userIdFromDb+"', '"+barcode+"')";

            int rset = stmt.executeUpdate(strInsert);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addBookCopy(String barcode, String physicalLocation, String isbn, String status) {

        String isbnDB = null;

        try {

            Connection conn = getConnection();
            Statement stmt = conn.createStatement();

            String strIsbn = "SELECT ISBN FROM books WHERE ISBN = '"+isbn+"'";

            ResultSet rset = stmt.executeQuery(strIsbn);

            int rowCount = 0;

            while (rset.next()) {

                isbnDB = rset.getString("ISBN");

                ++rowCount;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        JFrame f = new JFrame();

        if(!(isbnDB == null)) {

            JOptionPane.showMessageDialog(f, "Copy was successfully added");

            try {

                Connection conn = getConnection();

                Statement stmt = conn.createStatement();

                String strInsert = "INSERT INTO copy (Barcode, PhysicalLocation, Status, ISBN)" +
                        "VALUES ('" + barcode + "', '" + physicalLocation + "', '" + status + "', '" + isbn + "')";

                int rset = stmt.executeUpdate(strInsert);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else{
            JOptionPane.showMessageDialog(f, "Could not add copy, make sure ISBN exist by adding the book");
        }
    }

    public void removeBookCopy(String barcode) {

        JFrame f2 = new JFrame();
        JOptionPane.showMessageDialog(f2, "Item "+barcode+" was deleted from database");

        try {
            Connection conn = getConnection();

            Statement stmt = conn.createStatement();

            String strDelete = "DELETE FROM copy WHERE Barcode = '"+barcode+"'";

            int rset = stmt.executeUpdate(strDelete);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addDvdCopy(String barcode, String physicalLocation, String status, String movieId) {

        String movieDB = null;

        try {

            Connection conn = getConnection();
            Statement stmt = conn.createStatement();

            String strMovieId = "SELECT MovieID FROM dvd WHERE MovieID = '"+movieId+"'";

            ResultSet rset = stmt.executeQuery(strMovieId);

            int rowCount = 0;

            while (rset.next()) {

                movieDB = rset.getString("MovieID");

                ++rowCount;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        JFrame f = new JFrame();

        if(!(movieDB == null)) {

            JOptionPane.showMessageDialog(f, "Copy was successfully added");

            try {

                Connection conn = getConnection();

                Statement stmt = conn.createStatement();

                String strInsert = "INSERT INTO copy (Barcode, PhysicalLocation, Status, MovieID)" +
                        "VALUES ('" + barcode + "', '" + physicalLocation + "', '" + status + "', '" + movieId + "')";

                int rset = stmt.executeUpdate(strInsert);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else{
            JOptionPane.showMessageDialog(f, "Could not add copy, make sure MovieID exist by adding the dvd");
        }
    }

    public void removeDvdCopy(String barcode) {

        JFrame f = new JFrame();
        JOptionPane.showMessageDialog(f, "Could not add copy, make sure MovieID exist by adding the dvd");

        try {
            Connection conn = getConnection();

            Statement stmt = conn.createStatement();

            String strDelete = "DELETE FROM copy WHERE Barcode = '"+barcode+"'";

            int rset = stmt.executeUpdate(strDelete);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean getAccountType(String username) {

        boolean isAdmin = false;

        List<String> searchResults = new ArrayList<>();

        try {

            Connection conn = getConnection();

            Statement stmt = conn.createStatement();

            String strSelect = "SELECT AccountType FROM user WHERE Username = '"+username+"'";

            ResultSet rset = stmt.executeQuery(strSelect);

            int rowCount = 0;

            while (rset.next()) {

                String accountTypeFromDB = rset.getString("AccountType");

                if(accountTypeFromDB.equalsIgnoreCase("admin")){
                    isAdmin = true;
                }
                ++rowCount;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return isAdmin;
    }
}
