
public class Checker {
    public void check(FSA fsa, String word){

        int length = word.length();
        int charNumber = 0;
        int stateNumber = fsa.getInitialStateNumber();
        boolean isFound = false;

        Edge edge;
        State state = fsa.getState(stateNumber);

        // Check all characters in word
        while (charNumber != length) {
            edge = state.getEdge(word.charAt(charNumber));  // find edge of the given state based on character

            if (edge != null) {

                stateNumber = edge.getToStateNumber();  // assign pointed value from edge
                charNumber++; // next character
                state = fsa.getState(stateNumber); // assign next state based on number
                isFound = state.getIsAcceptedState(); // check is it accepting state
            }
            else {
                isFound = false; // if there is no such edge, fsa is in not accepting state
                break;
            }
        }

        if (isFound) {
            System.out.println("accepted");
        } else{
            System.out.println("not accepted");
        }
    }
}
