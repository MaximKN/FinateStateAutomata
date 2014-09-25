package uk.ac.standrews.fsainterpreter.builder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import uk.ac.standrews.fsainterpreter.representation.*;

/**
 * Creates finite state automate by reading finite state description file.
 * @author  cs2001 student
 */
public class FSAConstructor {

    /**
     * Main finite state automate
     */
    private FSA fsa = new FSA();

    /**
     * Main constructor
     * @param file name and a path to a finite state description file
     * @throws IOException
     */
    public FSAConstructor(String file) throws IOException{
        this.readFile(file);
    }

    /**
     * Reads from the given specified file
     * Creates edge and state line by line by calling buildFSA method
     * Ultimately build FSA
     * @param file name and a path to a finite state description file
     * @throws IOException
     */
    public void readFile(String file) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            this.buildFSA(line);
        }
        br.close();
    }

    /**
     * Adds state and edge to a state and ultimately builds a FSA
     * @param line line from the reader that contains: state source, char, state destination  and possibly * that indicates accepted state
     */
    public void buildFSA(String line){

        String[] input = line.split(" ");

        State state;

        int stateFrom = Integer.parseInt(input[0]);
        char transition = input[1].charAt(0);
        int stateTo = Integer.parseInt(input[2]);

        // If there is no source state, add it.
        if(!fsa.isStateExist(stateFrom)){
            state = new State(stateFrom, false);
            state.addEdge(new Edge(stateFrom, transition, stateTo));
            fsa.addState(state);
        }
        else{
            // If state is already exist, just add edge to it.
            state = fsa.getState(stateFrom);
            state.addEdge(new Edge(stateFrom, transition, stateTo));
        }

        // If there is no destination state, add it.
        if (!fsa.isStateExist(stateTo)){
            state = new State(stateTo, false);
            // If destination state is accepted add it by changing a boolean value
            if (input.length == 4 && input[3].equals("*")){
                state = new State(stateTo, true);
            }
            fsa.addState(state);
        }
    }

    /**
     * Getter for FSA
     * @return FSA
     */
    public FSA getFSA(){
        return this.fsa;
    }
}
