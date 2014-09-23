
public class Edge {
    private char transition;
    private int fromStateNumber;
    private int toStateNumber;

    public Edge(int fromStateNumber, char transition, int toStateNumber){
        this.fromStateNumber = fromStateNumber;
        this.transition = transition;
        this.toStateNumber = toStateNumber;
    }

    public char getTransition(){
        return this.transition;
    }
    public int getToStateNumber(){
        return this.toStateNumber;
    }
    public int getFromStateNumber(){ return this.fromStateNumber;}
}
