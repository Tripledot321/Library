package Package1;

import javax.swing.*;

public class UserService {

    private DatabaseConn database;
    private boolean isLoggedIn;
    private boolean isAdminLoggedIn;
    public UserService(DatabaseConn database){
        this.database = database;
    }

    public boolean isAuthenticated(){
        return isLoggedIn;
    }

    public boolean isUserAdmin(){
        return isAdminLoggedIn;
    }

    public void signOutUser (){
        isLoggedIn = false;
        isAdminLoggedIn = false;
    }


    public void signInUser(String username, String password){

        System.out.println("User service was requested to sign in username: '"+username+"' and user password: '"+password+"'");

        boolean result = database.validateUser(username, password);
        boolean isAdmin = false;

        if(result == true){
            isAdmin = database.getAccountType(username);
        }

        //If result is false return false
        //If result is true then get user details
        //save user details in this class
        isLoggedIn = result;
        isAdminLoggedIn = isAdmin;

        //isAdminLoggedIn = result;
            //
            if(result == true){
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "You are signed in, Welcome "+username);
            }
            else{
                JFrame f2 = new JFrame();
                JOptionPane.showMessageDialog(f2, "You could not be signed in, please try again");
            }
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
