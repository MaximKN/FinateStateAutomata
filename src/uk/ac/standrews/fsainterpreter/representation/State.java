package uk.ac.standrews.fsainterpreter.representation;

import java.util.LinkedList;

/**
 * Contains list of edges from one state to another. Accepted state is represented by a boolean value.
 * @author  cs2001 student
 */
public class State {

    private LinkedList<Edge> edges = new LinkedList<Edge>();
    private int number;
    private boolean isAcceptedState;

    /**
     * Main constructor
     * @param number state number
     * @param isAcceptedState boolean is it accepted state
     */
    public State(int number, boolean isAcceptedState){
        this.number = number;
        this.isAcceptedState = isAcceptedState;
    }

    /**
     * Edge number incrementer. It needs to be done for merge procedure
     * @param number number of accepting state from the first FSA
     */
    public void incNumOfEdges(int number){
        for (Edge edge : edges){
            edge.setFromStateNumber(edge.getFromStateNumber() + number);
            edge.setToStateNumber(edge.getToStateNumber() + number);
        }
    }
    /**
     * Number setter
     * @param number number of a state
     */
    public void setNumber(int number){
        this.number = number;
    }
    /**
     * Getter for a state number
     * @return state number
     */
    public int getNumber(){
        return number;
    }

    /**
     * Adds edge to a list
     * @param edge given edge
     */
    public void addEdge(Edge edge){
        this.edges.add(edge);
    }

    /**
     * Returns edge object based on transition character
     * @param c given transition character
     * @return edge object
     */
    public Edge getEdge(char c){
        for (Edge edge : edges) {
            if(edge.getTransition() == c) return edge;
        }
        return null;
    }

    /**
     * Getter for is it accepted state
     * @return boolean is it accepted
     */
    public boolean getIsAcceptedState(){
        return this.isAcceptedState;
    }
}