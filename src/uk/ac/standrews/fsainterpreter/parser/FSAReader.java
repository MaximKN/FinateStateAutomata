package uk.ac.standrews.fsainterpreter.parser;

import java.util.Scanner;
import uk.ac.standrews.fsainterpreter.representation.*;
/**
 * This class used to read from the console
 * @author  cs2001 student
 */
public class FSAReader {

    /**
     * This method reads from console input words and checks is given word in FSA
     * It prints accepted if the fsa stopped in accepted state. Otherwise, print ot accepted
     * @param fsa given FSA
     */
    public void read(FSA fsa) {
        Scanner scanner = new Scanner(System.in);
        FSAChecker checker = new FSAChecker();

        System.out.println("Please type \"quit\" if you want to finish ");
        while (true) {
            System.out.print("Your word: ");
            String word = scanner.nextLine();
            if (word.equals("quit")) break; // Exit condition
            if (checker.check(fsa, word)){
                System.out.println("accepted");
            } else {
                System.out.println("not accepted");
            }
        }
        System.exit(0);
    }
}