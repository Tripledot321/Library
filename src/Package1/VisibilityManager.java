package Package1;

public class VisibilityManager {

    GUI gui;

    public VisibilityManager(GUI userInterface) {

        //Detta saknades
        gui = userInterface;
        gui.headerPanel.setVisible(true);
        gui.mainPanel.setVisible(true);

    }

    public void searchResults(){

        gui.searchBooksPanel.setVisible(true);
        gui.loginPanel.setVisible(false);

    }

    public void loginScreen(){

        //insåg nedan att det inte bara är panelerna vi kan styra utan även individuella knappar t.ex.
        gui.searchBooksPanel.setVisible(false);

        gui.loginPanel.setVisible(true);

    }

}
