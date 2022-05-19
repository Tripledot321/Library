package Package1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationChoiceHandler implements ActionListener {

    private VisibilityManager visibilityManager;

    //i denna reglerar vi knapparna som inte har med något annat än navigering att göra

    public void setVisibilityManager(VisibilityManager vm) {
        visibilityManager = vm;
    }

    public void actionPerformed(ActionEvent event) {

        String yourChoice = event.getActionCommand();

        visibilityManager.showUserOptions();

        switch(yourChoice) {
            case "start":
            case "search":
                //osäker på denna nedanför, ska ju i princip starta om systemet
            case "logOut":
                visibilityManager.searchResults(); break;
            case "login": visibilityManager.loginScreen(); break;
            case "myAccount": visibilityManager.myAccountScreen(); break;
            case "admin":
            case "cancelRegisterUser":
            case "cancelRegisterBook":
            case "cancelRegisterDvd":
                visibilityManager.adminScreen(); break;
            case "registerUser": visibilityManager.registerUserScreen(); break;
            case "registerBook": visibilityManager.registerBookScreen(); break;
            case "registerDvd": visibilityManager.registerDvdScreen(); break;
            case "editLoanReservation": visibilityManager.editLoanScreen(); break;
            case "editReservation": visibilityManager.editReservationScreen(); break;
            case "editCopy": visibilityManager.editCopyScreen(); break;

        }


    }

}