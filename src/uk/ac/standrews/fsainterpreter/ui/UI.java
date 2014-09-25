package uk.ac.standrews.fsainterpreter.ui;

import java.io.IOException;
import java.util.Scanner;

import uk.ac.standrews.fsainterpreter.representation.*;
import uk.ac.standrews.fsainterpreter.builder.*;
import uk.ac.standrews.fsainterpreter.parser.*;

/**
 * Contains a main method which provides the user interface to the system.
 * @author  cs2001 student
 */
class UI {

    public static void main(String[] args) throws IOException, InterruptedException{
        Scanner scanner = new Scanner(System.in);
        FSAReader reader = new FSAReader();
        FSA fsa;

        System.out.println("Please type:");
        System.out.println("\t 1: If you want to create one FSA");
        System.out.println("\t 2: If you want to create two FSA and then merge them together?");
        System.out.print("Your choice: ");
        while (!scanner.hasNextInt()) scanner.next(); // Find integer

        boolean isCorrectNumber = false;
        // Make sure that is either 1 or 2
        while ( !isCorrectNumber ) {
            int inputNumber = scanner.nextInt();
            switch (inputNumber) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Specify the path to the file. For instance: fsa_descriptions/example.fsa");
                    System.out.print("Your path:");
                        while (!scanner.hasNextLine()) scanner.next();

                    FSAConstructor fsaConstructor = new FSAConstructor(scanner.nextLine());
                    fsa = fsaConstructor.getFSA();
                    fsa.findAccStates();
                    reader.read(fsa);

                    isCorrectNumber = true;
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Please type your path to the file of two FSA. For instance: fsa_descriptions/example1.fsa fsa_descriptions/example2.fsa");
                    System.out.print("Your path:");
                        while (!scanner.hasNextLine()) scanner.next();

                    FSAMerger fsaMerger = new FSAMerger(scanner.nextLine());
                    fsa = fsaMerger.getFinalFSA();
                    reader.read(fsa);

                    isCorrectNumber = true;
                    break;
                default:
                    System.err.println("I do not know what " + inputNumber + " is. Please try again...");
                    break;
            }
        }
    }
}
