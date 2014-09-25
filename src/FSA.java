import java.util.LinkedList;

/**
 * Finite state automate contains accepted and not accepted states
 * This class has methods that adds state to list,
 * checks that the given state is already exist in list.
 * It also returns the state by giving a number of it.
 */
public class FSA {

    /**
     * List of all states in automate
     */
    private LinkedList<State> states = new LinkedList<State>();

    /**
     * Add state to the list
     * @param state state
     */
    public void addState(State state){
        this.states.add(state);
    }

    /**
     * Check that given state is already exist
     * @param stateNumber number of the given state
     * @return boolean value is it exist or not
     */
    public boolean isStateExist(int stateNumber){
        for (State state : states) {
            if (state.getNumber() == stateNumber)
                return true;
        }
        return false;
    }

    /**
     * Getter for a state by a given number
     * @param stateNumber number of the given state
     * @return boolean value is it exist or not
     */
    public State getState(int stateNumber){
        for (State state : states) {
            if (state.getNumber() == stateNumber)
                return state;
        }
        return null;
    }

    /**
     * Finds the number of one of the accepting states.
     * @return the number of one of the accepting state
     */
    public LinkedList<State> findAccStates(){
        LinkedList<State> accStates = new LinkedList<State>();
        for (State state : states) {
            if (state.getIsAcceptedState())
                accStates.add(state);
        }
        if (accStates.size() == 0) { System.err.println("There is no accepting state"); System.exit(1); }
        return accStates;
    }

    /**
     * Finds max number of states. This is used by merge procedure
     * @return max number of states
     */
    public int findMaxState(){
        int max = states.get(0).getNumber();
        for (State state : states) {
            if (state.getNumber() > max)
                max = state.getNumber();
        }
        return max;
    }
    /**
     * State number incrementer. It needs to be done for merge procedure
     * @param number number of accepting state from the first FSA
     */
    public void incNumOfStates(int number){
        for (State state : states) {
            state.setNumber(state.getNumber() + number);
            state.incNumOfEdges(number);
        }
    }

    public LinkedList<State> getStates(){ return this.states;}

    /**
     * Getter for initial state number
     * @return initial state number
     */
    public int getInitialStateNumber(){
        return this.states.get(0).getNumber();
    }
}