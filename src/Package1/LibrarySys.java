package Package1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarySys {

    ChoiceHandler cHandler;
    GUI gui;
    VisibilityManager vm;

    public static void main(String[] args){

        var librarySystem = new LibrarySys();

    }

    public LibrarySys() {
        cHandler = new ChoiceHandler();

        gui = new GUI();
        gui.createGUI(cHandler);

        vm = new VisibilityManager(gui);
    }

    public class ChoiceHandler implements ActionListener {

           public void actionPerformed(ActionEvent event) {

               String yourChoice = event.getActionCommand();

               switch(yourChoice) {
                   case "start":
                   case "search": vm.searchResults(); break;
                   case "login": vm.loginScreen(); break;
                   case "c2": break;
                   case "c3": break;
                   case "c4": break;

               }


           }

    }
}
