package Package1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarySys {

    ChoiceHandler cHandler = new ChoiceHandler();
    GUI gui = new GUI();
    VisibilityManager vm = new VisibilityManager(gui);

    public static void main(String[] args){

        new LibrarySys();

    }

    public LibrarySys() {

        gui.createGUI(cHandler);
        vm.showTitleScreen();

    }

    public class ChoiceHandler implements ActionListener {

           public void actionPerformed(ActionEvent event) {

               String yourChoice = event.getActionCommand();

               switch(yourChoice) {
                   case "start": vm.searchResults(); break;
                   case "c1": break;
                   case "c2": break;
                   case "c3": break;
                   case "c4": break;

               }


           }

    }
}