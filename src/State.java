import java.util.LinkedList;

public class State {

    private LinkedList<Edge> edges = new LinkedList<Edge>();
    private int number;
    private boolean isAcceptedState;

    public State(int number, boolean isAcceptedState){
        this.number = number;
        this.isAcceptedState = isAcceptedState;
    }
    public int getNumber(){
        return number;
    }
    public void addEdge(Edge edge){
        this.edges.add(edge);
    }
    public Edge getEdge(char c){
        for (Edge edge : edges) {
            if(edge.getTransition() == c) return edge;
        }
        return null;
    }
    public boolean getIsAcceptedState(){
        return this.isAcceptedState;
    }
}
