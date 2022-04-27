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

        // Hide the game screen
        gui.mainTextPanel.setVisible(false);
        gui.choiceButtonPanel.setVisible(false);



    }

    public void searchResults(){

        gui.titleNamePanel.setVisible(false);
        gui.startButtonPanel.setVisible(false);

        gui.mainTextPanel.setVisible(true);
        gui.choiceButtonPanel.setVisible(true);

    }

}
