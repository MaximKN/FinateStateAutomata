/**
 * Representation of the edge.
 * It contains source state, transition character, destination state.
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


    public void setFromStateNumber(int fromStateNumber){
        this.fromStateNumber = fromStateNumber;
    }


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
