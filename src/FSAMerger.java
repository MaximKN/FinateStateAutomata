import java.io.IOException;
import java.util.LinkedList;

public class FSAMerger {

    private FSA finalFSA;

    public FSAMerger(String path) throws IOException{
        String[] paths = path.split(" ");

        FSAConstructor fsaConstructor = new FSAConstructor(paths[0]);
        FSA firstFSA = fsaConstructor.getFSA();

        fsaConstructor = new FSAConstructor(paths[1]);
        FSA secondFSA = fsaConstructor.getFSA();

        secondFSA.incNumOfStates(firstFSA.findMaxState());

        LinkedList<State> accStates = firstFSA.findAccStates();

        int initStateSecondFSA = secondFSA.getInitialStateNumber();

        for (State state : accStates) {
            state.addEdge(new Edge(state.getNumber(), ' ', initStateSecondFSA));
        }
        this.merge(firstFSA, secondFSA);
    }

    public void merge(FSA firstFSA, FSA secondFSA){
        LinkedList<State> states = secondFSA.getStates();
        for (State state : states){
            firstFSA.addState(state);
        }

        finalFSA = firstFSA;
    }

    public FSA getFinalFSA(){
        return finalFSA;
    }
}
