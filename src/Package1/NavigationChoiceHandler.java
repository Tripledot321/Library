package Package1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationChoiceHandler implements ActionListener {

    private VisibilityManager visibilityManager;

    public void setVisibilityManager(VisibilityManager vm) {
        visibilityManager = vm;
    }

    public void actionPerformed(ActionEvent event) {

        String yourChoice = event.getActionCommand();

        switch(yourChoice) {
            case "start":
            case "search": visibilityManager.searchResults(); break;
            case "login": visibilityManager.loginScreen(); break;
        }


    }

}