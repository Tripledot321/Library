package Package1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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


    public boolean validateUser(String username, String password) {
        return false;
    }

    public void addUser(String firstName, String lastName, String email, String personnummer, String phonenumber, String accountType) {

        try {

            Connection conn = getConnection();

            Statement stmt = conn.createStatement();

            String strInsert = "INSERT INTO user (Fname, Lname, Email, SSN, PhoneNumber, Status)" +
                    "VALUES ('"+firstName+"', '"+lastName+"', '"+email+"', '"+personnummer+"', '"+phonenumber+"', '1')";

            int rset = stmt.executeUpdate(strInsert);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateUser(String firstName, String lastName, String email, String personnummer, String phonenumber, String accountType) {

        try {

            Connection conn = getConnection();

            Statement stmt = conn.createStatement();

           String strUpdate = "UPDATE user SET Fname = '"+firstName+"', Lname = '"+lastName+"', Email = '"+email+"', PhoneNumber = '"+phonenumber+"' WHERE ssn = '"+personnummer+"'";

            int rset = stmt.executeUpdate(strUpdate);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

//    public boolean findUser(String personnummer) {
//
//        boolean userExists = false;
//
//        try {
//            Connection conn = getConnection();
//
//            Statement stmt = conn.createStatement();
//
//            String strUser = "SELECT ssn FROM user WHERE SSN='"+personnummer+"'";
//
//            ResultSet rset = stmt.executeQuery(strUser);
//
//            int rowCount = 0;
//
//            while (rset.next()) {
//
//                personnummer = rset.getString("ssn");
//
//                ++rowCount;
//            }
//
//            if(!personnummer.equalsIgnoreCase("")){
//                userExists = true;
//            }
//
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return userExists;
//    }

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
}
