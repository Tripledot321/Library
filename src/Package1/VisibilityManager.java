package Package1;

public class VisibilityManager {

    GUI gui;

    public VisibilityManager(GUI userInterface) {
        gui = userInterface;

    }

    public void searchResults(){
        gui.searchBooksPanel.setVisible(true);
        gui.loginPanel.setVisible(false);
        gui.myAccountPanel.setVisible(false);
        gui.adminPanel.setVisible(false);
        gui.registerUserPanel.setVisible(false);
        gui.addBookPanel.setVisible(false);
        gui.addDvdPanel.setVisible(false);
        gui.editLoanReservationPanel.setVisible(false);

    }

    public void loginScreen(){
        gui.searchBooksPanel.setVisible(false);
        gui.loginPanel.setVisible(true);
        gui.myAccountPanel.setVisible(false);
        gui.adminPanel.setVisible(false);
        gui.registerUserPanel.setVisible(false);
        gui.addBookPanel.setVisible(false);
        gui.addDvdPanel.setVisible(false);
        gui.editLoanReservationPanel.setVisible(false);

    }

    public void myAccountScreen(){
        gui.searchBooksPanel.setVisible(false);
        gui.loginPanel.setVisible(false);
        gui.myAccountPanel.setVisible(true);
        gui.adminPanel.setVisible(false);
        gui.registerUserPanel.setVisible(false);
        gui.addBookPanel.setVisible(false);
        gui.addDvdPanel.setVisible(false);
        gui.editLoanReservationPanel.setVisible(false);

    }

    public void adminScreen(){
        gui.searchBooksPanel.setVisible(false);
        gui.loginPanel.setVisible(false);
        gui.myAccountPanel.setVisible(false);
        gui.adminPanel.setVisible(true);
        gui.registerUserPanel.setVisible(false);
        gui.addBookPanel.setVisible(false);
        gui.addDvdPanel.setVisible(false);
        gui.editLoanReservationPanel.setVisible(false);

    }

    public void registerUserScreen(){
        gui.searchBooksPanel.setVisible(false);
        gui.loginPanel.setVisible(false);
        gui.myAccountPanel.setVisible(false);
        gui.adminPanel.setVisible(false);
        gui.registerUserPanel.setVisible(true);
        gui.addBookPanel.setVisible(false);
        gui.addDvdPanel.setVisible(false);
        gui.editLoanReservationPanel.setVisible(false);

    }

    public void registerBookScreen(){
        gui.searchBooksPanel.setVisible(false);
        gui.loginPanel.setVisible(false);
        gui.myAccountPanel.setVisible(false);
        gui.adminPanel.setVisible(false);
        gui.registerUserPanel.setVisible(false);
        gui.addBookPanel.setVisible(true);
        gui.addDvdPanel.setVisible(false);
        gui.editLoanReservationPanel.setVisible(false);

    }

    public void registerDvdScreen(){
        gui.searchBooksPanel.setVisible(false);
        gui.loginPanel.setVisible(false);
        gui.myAccountPanel.setVisible(false);
        gui.adminPanel.setVisible(false);
        gui.registerUserPanel.setVisible(false);
        gui.addBookPanel.setVisible(false);
        gui.addDvdPanel.setVisible(true);
        gui.editLoanReservationPanel.setVisible(false);

    }

    public void editLoanReservationScreen(){
        gui.searchBooksPanel.setVisible(false);
        gui.loginPanel.setVisible(false);
        gui.myAccountPanel.setVisible(false);
        gui.adminPanel.setVisible(false);
        gui.registerUserPanel.setVisible(false);
        gui.addBookPanel.setVisible(false);
        gui.addDvdPanel.setVisible(false);
        gui.editLoanReservationPanel.setVisible(true);

    }


}
