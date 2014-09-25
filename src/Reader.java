import java.io.IOException;
import java.util.Scanner;

public class Reader {

    public void read(FSA fsa) throws IOException{
        Scanner scanner = new Scanner(System.in);
        Checker checker = new Checker();

        System.out.println("Please type \"quit\" if you want to finish ");
        while (true) {
            System.out.print("Your word: ");
            String word = scanner.nextLine();
            if (word.equals("quit")) break; // Exit condition
            checker.check(fsa, word);
        }
        System.exit(0);
    }
}