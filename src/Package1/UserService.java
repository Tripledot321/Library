package Package1;

import javax.swing.*;

public class UserService {

    private DatabaseConn database;
    public UserService(DatabaseConn database){
        this.database = database;
    }

    public void signInUser(String username, String password){

        System.out.println("User service was requested to sign in username: '"+username+"' and user password: '"+password+"'");

        boolean result = database.validateUser(username, password);
    }


    public void updateUser(String firstName, String lastName, String email, String personnummer, String phonenumber, String accountType, String removeUser, String editUser){

        System.out.println("User service was requested to add user");

        //testa ifall checkboxen "remove user" är ikryssad
        if(removeUser.equalsIgnoreCase("remove")){
            database.removeUser(personnummer);
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "User "+personnummer+" was deleted from database");
        }
        else if(editUser.equalsIgnoreCase("edit")){
                database.updateUser(firstName, lastName, email, personnummer, phonenumber, accountType);
                JFrame f3 = new JFrame();
                JOptionPane.showMessageDialog(f3, "User "+personnummer+" was UPDATED in the database");
        }
        else {
                database.addUser(firstName, lastName, email, personnummer, phonenumber, accountType);
                JFrame f2 = new JFrame();
                JOptionPane.showMessageDialog(f2, "User was added to database");
        }
    }
}
