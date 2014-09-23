import java.util.LinkedList;

public class State {

    private LinkedList<Edge> edges = new LinkedList<Edge>();
    private int number;

    public State(int number){
        this.number = number;
    }
    public int getNumber(){
        return number;
    }
    public void addEdge(Edge edge){
        edges.add(edge);
    }
    public boolean isEdgeExist(String c){
        for (Edge edge : edges) {
            if(edge.getTransition().equals(c)) return true;
        }
        return false;
    }
}
