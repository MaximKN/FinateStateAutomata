
public class Edge {
    private String transition;
    private int fromStateNumber;
    private int toStateNumber;

    public Edge(int fromStateNumber, String transition, int toStateNumber){
        this.fromStateNumber = fromStateNumber;
        this.transition = transition;
        this.toStateNumber = toStateNumber;
    }

    public String getTransition(){
        return transition;
    }
}
