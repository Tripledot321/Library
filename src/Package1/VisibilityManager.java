package Package1;

public class VisibilityManager {

    GUI gui;

    public VisibilityManager(GUI userInterface) {
        gui = userInterface;
    }

    public void searchResults(){
        gui.searchBooksPanel.setVisible(true);
        gui.loginPanel.setVisible(false);
    }

    public void loginScreen(){
        gui.searchBooksPanel.setVisible(false);
        gui.loginPanel.setVisible(true);
    }

}
