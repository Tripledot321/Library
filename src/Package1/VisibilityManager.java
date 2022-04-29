package Package1;

import javax.swing.*;
import java.awt.*;

public class VisibilityManager {

    GUI gui;

    public VisibilityManager(GUI userInterface) {

        //Detta saknades
        gui = userInterface;

    }

    public void showTitleScreen() {

        // Show start screen
        gui.titleNamePanel.setVisible(true);
        gui.startButtonPanel.setVisible(true);
        gui.searchFieldPanel.setVisible(true);

        // Hide the game screen
        gui.mainTextPanel.setVisible(false);
        gui.choiceButtonPanel.setVisible(false);



    }

    public void searchResults(){

        gui.titleNamePanel.setVisible(true);
        gui.startButtonPanel.setVisible(false);
        gui.searchFieldPanel.setVisible(false);

        gui.mainTextPanel.setVisible(true);
        gui.choiceButtonPanel.setVisible(true);

    }

    public void displaySearchResults(){

        gui.titleNamePanel.setVisible(true);
        gui.startButtonPanel.setVisible(false);
        gui.searchFieldPanel.setVisible(false);

        gui.mainTextPanel.setVisible(true);
        gui.choiceButtonPanel.setVisible(true);

    }

    public void loginScreen(){

        gui.titleNamePanel.setVisible(true);
        //insåg nedan att det inte bara är panelerna vi kan styra utan även individuella knappar t.ex.
        gui.loginButton.setVisible(false);
        gui.startButtonPanel.setVisible(false);
        gui.searchFieldPanel.setVisible(false);

        gui.mainTextPanel.setVisible(true);
        gui.loginScreenLabel.setVisible(true);
        gui.choiceButtonPanel.setVisible(true);


    }

}
