import java.io.*;

public class Reader {
    public static void main(String[] args) throws IOException{

        FSA fsa = new FSA();

        BufferedReader br = new BufferedReader(new FileReader("example.fsa"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] input = line.split(" ");

            State state;

            int stateFrom = Integer.parseInt(input[0]);
            String transition = input[1];
            int stateTo = Integer.parseInt(input[2]);

            if (!fsa.isStateExist(stateFrom)){
                // Do not add if repeated value
                state = new State(stateFrom);
                state.addEdge(new Edge(stateFrom, transition, stateTo));

                fsa.addState(state);
                System.out.println("ADDED");
            }

            else{
                // if state already exist, just add edge.
                state = fsa.getState(stateFrom);

                if (!fsa.isEdgeExist(state, transition)){
                    state.addEdge(new Edge(stateFrom, transition, stateTo));

                    System.out.println("State number "+ state.getNumber() + " is already exist, just added edge");
                }
                else {
                    System.out.println("State number " + state.getNumber() + " is already exist, edge as well");
                }
            }

            if (input.length == 4 && input[3].equals("*")){
                state = new AcceptedState(stateTo);
                fsa.addState(state);
                System.out.println("Added Accepted state TO " + stateTo);
            }
            else{
                fsa.addState(new State(stateTo));
                System.out.println("Added usual state TO " + stateTo);
            }
        }
        br.close();
    }
}
