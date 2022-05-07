package Package1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConn {

    public static List<String> selectUsers(String searchParameter) {


        List<String> searchResults = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/libraryx?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    "root", "1234");

            Statement stmt = conn.createStatement();

            String strSelect = "select * from user where firstName='" + searchParameter + "'";

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


}
