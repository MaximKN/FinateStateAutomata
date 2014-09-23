import java.util.ArrayList;

public class FSA {
    private ArrayList<State> states = new ArrayList<State>();

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

    public boolean isEdgeExist(State state, String transition){
        return state.isEdgeExist(transition);
    }
}