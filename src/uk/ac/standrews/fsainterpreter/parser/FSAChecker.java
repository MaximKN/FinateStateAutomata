package uk.ac.standrews.fsainterpreter.parser;

import uk.ac.standrews.fsainterpreter.representation.*;

import java.util.EmptyStackException;

/**
 * This class is used to check that the word specified by user is in finite state automata
 * @author  cs2001 student
 */
public class FSAChecker {

    /**
     * Check that the given word is accepted by FSA
     * @param fsa Finite State Automate
     * @param word Word required to be processed
     * @return is word found or not
     */
    public boolean check(FSA fsa, String word){

        if (fsa == null || word == null)    throw new NullPointerException();
        if (fsa.getStates().size() == 0 || word.equals(""))    throw new EmptyStackException();

        int length = word.length();
        int charNumber = 0;
        int stateNumber = fsa.getInitialStateNumber();
        boolean isFound = false;

        Edge edge;
        State state = fsa.getState(stateNumber);

        // Check all characters in word
        while (charNumber != length) {
            edge = state.getEdge(word.charAt(charNumber));  // find edge of the given state based on character

            if (edge != null) {

                stateNumber = edge.getToStateNumber();  // assign pointed value from edge
                charNumber++; // next character
                state = fsa.getState(stateNumber); // assign next state based on number
                isFound = state.getIsAcceptedState(); // check is it accepting state
            }
            else {
                isFound = false; // if there is no such edge, fsa is in not accepting state
                break;
            }
        }

        return isFound;
    }
}
