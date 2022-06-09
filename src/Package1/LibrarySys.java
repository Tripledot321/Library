package Package1;

public class LibrarySys {

    NavigationChoiceHandler cHandler;
    GUI gui;
    VisibilityManager vm;

    // i denna startar vi upp själva systemet (även en instans av systemet)

    public static void main(String[] args){

        var librarySystem = new LibrarySys();

    }

    public LibrarySys() {
        cHandler = new NavigationChoiceHandler();
        var database = new DatabaseConn("localhost:3306","root", "1234");
        var searchService = new BookService(database);
        var userService = new UserService(database);
        gui = new GUI(searchService, userService);
        gui.createGUI(cHandler);


        vm = new VisibilityManager(gui, userService);
        cHandler.setVisibilityManager(vm);

        //första sidan som visas
        vm.searchResults();
    }
}
