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

    public List<String> getBooks(String searchTerm ) {
        return new ArrayList<>();
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


    public boolean validateUser(String username, String password) {
        return false;
    }
}
