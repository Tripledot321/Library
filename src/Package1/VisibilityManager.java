package Package1;


public class VisibilityManager {

    GUI gui;
    private UserService _userService;

    //här styr vi de respektive "screensen" eller det man ser som användare

    public VisibilityManager(GUI userInterface, UserService userService) {
        gui = userInterface;
        _userService = userService;
    }

    public void showUserOptions(){

        if(_userService.isAuthenticated()){
            gui.goToMyAccountButton.setVisible(true);
            gui.goToLoginButton.setVisible(false);
            gui.goToLogoutButton.setVisible(true);
        }
        else{
            gui.goToMyAccountButton.setVisible(false);
            //testar här
            gui.goToLogoutButton.setVisible(false);

            gui.goToLoginButton.setVisible(true);
        }

        if(_userService.isUserAdmin()){
            gui.goToAdminButton.setVisible(true);
//            gui.goToLoginButton.setVisible(false);
//            gui.goToLogoutButton.setVisible(true);
        }
        else{
            gui.goToAdminButton.setVisible(false);
//            gui.goToLogoutButton.setVisible(false);
//
//            gui.goToLoginButton.setVisible(true);

        }

    }

    public void searchResults(){
        gui.searchBooksPanel.setVisible(true);
        gui.loginPanel.setVisible(false);
        gui.myAccountPanel.setVisible(false);
        gui.adminPanel.setVisible(false);
        gui.registerUserPanel.setVisible(false);
        gui.addBookPanel.setVisible(false);
        gui.addDvdPanel.setVisible(false);
        gui.editLoanPanel.setVisible(false);
        gui.editReservationPanel.setVisible(false);
        gui.addItemCopyPanel.setVisible(false);
    }

    public void loginScreen(){
        gui.searchBooksPanel.setVisible(false);
        gui.loginPanel.setVisible(true);
        gui.myAccountPanel.setVisible(false);
        gui.adminPanel.setVisible(false);
        gui.registerUserPanel.setVisible(false);
        gui.addBookPanel.setVisible(false);
        gui.addDvdPanel.setVisible(false);
        gui.editLoanPanel.setVisible(false);
        gui.editReservationPanel.setVisible(false);
        gui.addItemCopyPanel.setVisible(false);
    }

    public void myAccountScreen(){
        gui.searchBooksPanel.setVisible(false);
        gui.loginPanel.setVisible(false);
        gui.myAccountPanel.setVisible(true);
        gui.adminPanel.setVisible(false);
        gui.registerUserPanel.setVisible(false);
        gui.addBookPanel.setVisible(false);
        gui.addDvdPanel.setVisible(false);
        gui.editLoanPanel.setVisible(false);
        gui.editReservationPanel.setVisible(false);
        gui.addItemCopyPanel.setVisible(false);
    }

    public void adminScreen(){
        gui.searchBooksPanel.setVisible(false);
        gui.loginPanel.setVisible(false);
        gui.myAccountPanel.setVisible(false);
        gui.adminPanel.setVisible(true);
        gui.registerUserPanel.setVisible(false);
        gui.addBookPanel.setVisible(false);
        gui.addDvdPanel.setVisible(false);
        gui.editLoanPanel.setVisible(false);
        gui.editReservationPanel.setVisible(false);
        gui.addItemCopyPanel.setVisible(false);
    }

    public void registerUserScreen(){
        gui.searchBooksPanel.setVisible(false);
        gui.loginPanel.setVisible(false);
        gui.myAccountPanel.setVisible(false);
        gui.adminPanel.setVisible(false);
        gui.registerUserPanel.setVisible(true);
        gui.addBookPanel.setVisible(false);
        gui.addDvdPanel.setVisible(false);
        gui.editLoanPanel.setVisible(false);
        gui.editReservationPanel.setVisible(false);
        gui.addItemCopyPanel.setVisible(false);
    }

    public void registerBookScreen(){
        gui.searchBooksPanel.setVisible(false);
        gui.loginPanel.setVisible(false);
        gui.myAccountPanel.setVisible(false);
        gui.adminPanel.setVisible(false);
        gui.registerUserPanel.setVisible(false);
        gui.addBookPanel.setVisible(true);
        gui.addDvdPanel.setVisible(false);
        gui.editLoanPanel.setVisible(false);
        gui.editReservationPanel.setVisible(false);
        gui.addItemCopyPanel.setVisible(false);
    }

    public void registerDvdScreen(){
        gui.searchBooksPanel.setVisible(false);
        gui.loginPanel.setVisible(false);
        gui.myAccountPanel.setVisible(false);
        gui.adminPanel.setVisible(false);
        gui.registerUserPanel.setVisible(false);
        gui.addBookPanel.setVisible(false);
        gui.addDvdPanel.setVisible(true);
        gui.editLoanPanel.setVisible(false);
        gui.editReservationPanel.setVisible(false);
        gui.addItemCopyPanel.setVisible(false);
    }

    public void editLoanScreen(){
        gui.searchBooksPanel.setVisible(false);
        gui.loginPanel.setVisible(false);
        gui.myAccountPanel.setVisible(false);
        gui.adminPanel.setVisible(false);
        gui.registerUserPanel.setVisible(false);
        gui.addBookPanel.setVisible(false);
        gui.addDvdPanel.setVisible(false);
        gui.editLoanPanel.setVisible(true);
        gui.editReservationPanel.setVisible(false);
        gui.addItemCopyPanel.setVisible(false);
    }

    public void editReservationScreen(){
        gui.searchBooksPanel.setVisible(false);
        gui.loginPanel.setVisible(false);
        gui.myAccountPanel.setVisible(false);
        gui.adminPanel.setVisible(false);
        gui.registerUserPanel.setVisible(false);
        gui.addBookPanel.setVisible(false);
        gui.addDvdPanel.setVisible(false);
        gui.editLoanPanel.setVisible(false);
        gui.editReservationPanel.setVisible(true);
        gui.addItemCopyPanel.setVisible(false);
    }

    public void editCopyScreen(){
        gui.searchBooksPanel.setVisible(false);
        gui.loginPanel.setVisible(false);
        gui.myAccountPanel.setVisible(false);
        gui.adminPanel.setVisible(false);
        gui.registerUserPanel.setVisible(false);
        gui.addBookPanel.setVisible(false);
        gui.addDvdPanel.setVisible(false);
        gui.editLoanPanel.setVisible(false);
        gui.editReservationPanel.setVisible(false);
        gui.addItemCopyPanel.setVisible(true);
    }


}
