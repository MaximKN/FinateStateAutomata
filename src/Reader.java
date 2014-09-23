import java.io.*;
import java.util.*;

public class Reader {
    public static void main(String[] args) throws IOException{

        FSA fsa = new FSA();

        BufferedReader br = new BufferedReader(new FileReader("example.fsa"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] input = line.split(" ");

            State state;

            int stateFrom = Integer.parseInt(input[0]);
            char transition = input[1].charAt(0);
            int stateTo = Integer.parseInt(input[2]);

            if(!fsa.isStateExist(stateFrom)){
                // if source state is not there
                state = new State(stateFrom, false);
                state.addEdge(new Edge(stateFrom, transition, stateTo));
                fsa.addState(state);

               // System.out.println("Added usual state " + stateFrom);
            }
            else{
                // if state already exist, just add edge.
                state = fsa.getState(stateFrom);
                state.addEdge(new Edge(stateFrom, transition, stateTo));

                //System.out.println("Just added edge " + stateFrom + " "+ state.getEdge(transition).getTransition());
            }

            if (!fsa.isStateExist(stateTo)){
                // always add next state TO

                state = new State(stateTo, false);

                if (input.length == 4 && input[3].equals("*")){
                    state = new State(stateTo, true);
                }
                fsa.addState(state);

                //System.out.println("Added state TO " + stateTo);
            }
        }


        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

            int length = word.length();
            int charNumber = 0;
            int stateNumber = 1;
            boolean isFound = false;
            Edge edge;
            State state = fsa.getState(stateNumber);

            while (charNumber != length) {

                //System.out.println("\tComparing " + word.charAt(charNumber));

                edge = state.getEdge(word.charAt(charNumber));

                //System.out.println("There are " + state.getNumberOfEdges() +  " number of edged from state " + stateNumber );

                if (edge != null) {

                    //System.out.println("State number: " + stateNumber + " Go to: " + edge.getToStateNumber());
                    stateNumber = edge.getToStateNumber();
                    charNumber++;

                    state = fsa.getState(stateNumber);

                    isFound = state.getIsAcceptedState();
                }
                else{
                    break;
                }
            }

            if (isFound){
                System.out.println("Accepted");
            }
            else{
                System.out.println("Not accepted");
            }
        br.close();
    }
}
