package uk.ac.standrews.fsainterpreter.representation;

/**
 * Representation of the edge.
 * It contains source state, transition character, destination state.
 * @author  cs2001 student
 */
public class Edge {
    private char transition;
    private int fromStateNumber;
    private int toStateNumber;

    /**
     * Main edge constructor
     * @param fromStateNumber source state
     * @param transition transition character
     * @param toStateNumber destination state
     */
    public Edge(int fromStateNumber, char transition, int toStateNumber){
        this.fromStateNumber = fromStateNumber;
        this.transition = transition;
        this.toStateNumber = toStateNumber;
    }

    /**
     * Setter for the source state number
     * @param fromStateNumber source state number
     */
    public void setFromStateNumber(int fromStateNumber){
        this.fromStateNumber = fromStateNumber;
    }

    /**
     * Setter for the destination state number
     * @param toStateNumber destination state number
     */
    public void setToStateNumber(int toStateNumber){
        this.toStateNumber = toStateNumber;
    }
    /**
     * Getter for transition
     * @return transition
     */
    public char getTransition(){ return this.transition; }

    /**
     * Getter for the destination state number
     * @return destination state number
     */
    public int getToStateNumber(){ return this.toStateNumber; }

    /**
     * Getter for the source state number
     * @return source state number
     */
    public int getFromStateNumber(){ return this.fromStateNumber;}
}
