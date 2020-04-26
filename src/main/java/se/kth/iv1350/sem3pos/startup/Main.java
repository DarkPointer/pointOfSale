package se.kth.iv1350.sem3pos.startup;

import se.kth.iv1350.sem3pos.controller.Controller;
import se.kth.iv1350.sem3pos.integration.Printer;
import se.kth.iv1350.sem3pos.integration.SystemCreator;
import se.kth.iv1350.sem3pos.view.View;

/**
 * The main class which is responsible upon initializing the program.
 */
public class Main {
        /**
         * Starts the program and performs a sample sale process.
         * @param args No command-line parameters are expected.
         */
        public static void main(String[] args) {
                SystemCreator systemCreator = new SystemCreator();
                Printer printer = new Printer();
                Controller cont = new Controller(systemCreator, printer);
                View view = new View(cont);
                view.simulateSaleProcess();
        }
}
