import java.util.LinkedList;

public class FSA {
    private LinkedList<State> states = new LinkedList<State>();

    public void addState(State state){
        this.states.add(state);
    }
    public boolean isStateExist(int stateNumber){
        for (State state : states) {
            if (state.getNumber() == stateNumber)
                return true;
        }
        return false;
    }

    public State getState(int stateNumber){
        for (State state : states) {
            if (state.getNumber() == stateNumber)
                return state;
        }
        return null;
    }
}