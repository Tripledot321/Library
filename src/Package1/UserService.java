package Package1;

import javax.swing.*;
import java.sql.SQLException;

public class UserService {

    //här styr vi saker som har med användare att göra

    private DatabaseConn database;
    private boolean isLoggedIn;
    private boolean isAdminLoggedIn;
    public UserService(DatabaseConn database){
        this.database = database;
    }
    private User user;

    public boolean isAuthenticated(){

        if(user != null){
            return true;
        }

        return false;
    }

    public boolean isUserAdmin(){

        if(user == null){
            return false;
        }

        return user.isUserAdmin();
    }

    public void signOutUser (){
        user = null;
    }


    public void signInUser(String username, String password) throws SQLException {

        System.out.println("User service was requested to sign in username: '"+username+"' and user password: '"+password+"'");

        boolean result = database.validateUser(username, password);

        if(result == false){
            JFrame f2 = new JFrame();
            JOptionPane.showMessageDialog(f2, "You could not be signed in, please try again");
            return;
        }

        String userAccountType = database.getAccountType(username);

        user = new User(true, userAccountType);

        JFrame f = new JFrame();
        JOptionPane.showMessageDialog(f, "You are signed in, Welcome "+username);

    }


    public void updateUser(String firstName, String lastName, String email, String personnummer, String phonenumber, String accountType, String username, String password, String removeUser, String editUser){

        System.out.println("User service was requested to add user");

        //testa ifall checkboxen "remove user" är ikryssad
        if(removeUser.equalsIgnoreCase("remove")){
            database.removeUser(personnummer);
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "User "+personnummer+" was deleted from database");
        }
        else if(editUser.equalsIgnoreCase("edit")){
                database.updateUser(firstName, lastName, email, personnummer, phonenumber, accountType, username, password);
                JFrame f3 = new JFrame();
                JOptionPane.showMessageDialog(f3, "User "+personnummer+" was UPDATED in the database");
        }
        else {
                database.addUser(firstName, lastName, email, personnummer, phonenumber, accountType, username, password);
                JFrame f2 = new JFrame();
                JOptionPane.showMessageDialog(f2, "User was added to database");
        }
    }

    public void editLoanUser(String personnummer, String barcode, String removeLoanReservation){
        System.out.println("User service was requested to edit a loan for a user");

        if(removeLoanReservation.equalsIgnoreCase("remove")){
            database.removeLoan(barcode);
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Loan of book: "+barcode+" was removed for: "+personnummer);
        }
        else {
            database.addLoan(personnummer, barcode);
            JFrame f2 = new JFrame();
            JOptionPane.showMessageDialog(f2, "Loan of book: "+barcode+" was added for: "+personnummer);
        }

    }

    public void editReservationUser(String personnummer, String barcode, String removeReservation){
        System.out.println("User service was requested to edit a loan for a user");

        if(removeReservation.equalsIgnoreCase("remove")){
            database.removeReservation(barcode, personnummer);
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Reservation for book: "+barcode+" was removed for: "+personnummer);
        }
        else {
            database.addReservation(personnummer, barcode);
            JFrame f2 = new JFrame();
            JOptionPane.showMessageDialog(f2, "Reservation for book: "+barcode+" was added for: "+personnummer);
        }

    }
}
