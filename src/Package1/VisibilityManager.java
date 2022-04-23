package Package1;

public class VisibilityManager {

    GUI gui;

    public VisibilityManager(GUI userInterface) {

    }

    public void showTitleScreen() {

        // Show start screen
        gui.titleNamePanel.setVisible(true);
        gui.startButtonPanel.setVisible(true);

        // Hide the game screen
        gui.mainTextPanel.setVisible(false);
        gui.choiceButtonPanel.setVisible(false);
    }
}
