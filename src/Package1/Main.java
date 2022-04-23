package Package1;

import Package1.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

        ChoiceHandler cHandler = new ChoiceHandler();
        GUI gui = new GUI();

        public static void main(String[]args){

          new Main(); //Starts menu window

        }

        public  Main() {

            gui.createGUI(cHandler);
        }

        public class ChoiceHandler implements ActionListener {

           public void actionPerformed(ActionEvent event) {


           }

        }
}
