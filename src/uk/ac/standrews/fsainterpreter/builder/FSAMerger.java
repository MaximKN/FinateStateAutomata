package uk.ac.standrews.fsainterpreter.builder;

import java.io.IOException;
import java.util.LinkedList;
import uk.ac.standrews.fsainterpreter.representation.*;

/**
 * This class is used to merge two finite state automates.
 * @author  cs2001 student
 */
public class FSAMerger {

    private FSA finalFSA;

    /**
     * Main constructor
     * @param path path to files
     * @throws IOException
     */
    public FSAMerger(String path) throws IOException{
        constructFSA(path);
    }

    /**
     * Build two given finite state automates
     * @param path path to files
     * @throws IOException
     */
    public void constructFSA(String path) throws IOException{
        String[] paths = path.split(" ");

        FSAConstructor fsaConstructor = new FSAConstructor(paths[0]);
        FSA firstFSA = fsaConstructor.getFSA();

        fsaConstructor = new FSAConstructor(paths[1]);
        FSA secondFSA = fsaConstructor.getFSA();

        // Before merging two FSA, increase number of states of the second FSA
        secondFSA.incNumOfStates(firstFSA.findMaxState());

        // Add edge from all accepting states of the first FSA to the initial states of the second FSA
        LinkedList<State> accStates = firstFSA.findAccStates();
        int initStateSecondFSA = secondFSA.getInitialStateNumber();
        for (State state : accStates) {
            state.addEdge(new Edge(state.getNumber(), ' ', initStateSecondFSA));
        }
        this.merge(firstFSA, secondFSA);
    }

    /**
     * Merges two FSA and puts into finalFSA;
     * @param firstFSA first FSA
     * @param secondFSA second FSA
     */
    public void merge(FSA firstFSA, FSA secondFSA){
        LinkedList<State> states = secondFSA.getStates();
        for (State state : states){
            firstFSA.addState(state);
        }
        finalFSA = firstFSA;
    }

    /**
     * Getter for the final FSA
     * @return final FSA
     */
    public FSA getFinalFSA(){
        return finalFSA;
    }
}
