package Package1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarySys {

    NavigationChoiceHandler cHandler;
    GUI gui;
    VisibilityManager vm;

    public static void main(String[] args){

        var librarySystem = new LibrarySys();

    }

    public LibrarySys() {
        cHandler = new NavigationChoiceHandler();

        var searchService = new SearchService();
//        var searchHandler = new SearchHandler(searchService);
        gui = new GUI(searchService);
        gui.createGUI(cHandler);

        vm = new VisibilityManager(gui);
        cHandler.setVisibilityManager(vm);

        vm.searchResults();
    }
}
