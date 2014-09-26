package uk.ac.standrews.fsainterpreter.parser;

import org.junit.Before;
import org.junit.Test;

import uk.ac.standrews.fsainterpreter.representation.*;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class FSACheckerTest {

    private FSA fsa;
    private FSAChecker fsaChecker;

    @Before
    public void createFSA() {
        fsa = new FSA();

        fsa.addState(new State(1, false));
        fsa.addState(new State(2, false));
        fsa.addState(new State(3, false));
        fsa.addState(new State(4, true));

        fsa.getState(1).addEdge(new Edge(1, 'a', 2));
        fsa.getState(2).addEdge(new Edge(2, 'b', 3));
        fsa.getState(3).addEdge(new Edge(3, 'c', 4));

        fsaChecker = new FSAChecker();
    }

    @Test(expected=NullPointerException.class)
    public void testCheckFSANull() throws Exception {
        fsa = null;
        fsaChecker.check(fsa, "deq");
    }

    @Test(expected=NullPointerException.class)
    public void testCheckWordNull() throws Exception {
        fsaChecker.check(fsa, null);
    }

    @Test(expected= EmptyStackException.class)
    public void testCheckEmptyFSA() throws Exception {
        fsa = new FSA();
        fsaChecker.check(fsa, "adf");
    }

    @Test(expected= EmptyStackException.class)
    public void testCheckEmptyWord() throws Exception {
        fsaChecker.check(fsa, "");
    }

    @Test
    public void testCheckTrue() throws Exception {
        assertEquals(true, fsaChecker.check(fsa, "abc"));
    }

    @Test
    public void testCheckFalse() throws Exception {
        assertEquals(false, fsaChecker.check(fsa, "bac"));
    }

    @Test
    public void testFSAFindMaxState() throws Exception {
        assertEquals(4, fsa.findMaxState());
    }

    @Test
    public void testFSAFindMaxStateAnotherEdge() throws Exception {
        fsa.addState(new State(20, false));
        assertEquals(20, fsa.findMaxState());
    }

    @Test
    public void testFSAIsAcceptState() throws Exception {
        fsa = new FSA();
        fsa.addState(new State(1, true));
        fsa.addState(new State(2, true));
        fsa.addState(new State(3, true));
        fsa.addState(new State(5, false));

        assertEquals(3, fsa.findAccStates().size());
    }

    @Test
    public void testFSAInitialState() throws Exception {
        assertEquals(1, fsa.getInitialStateNumber());
    }

    @Test
    public void testFSAIncreaseStateNumber() throws Exception {
        fsa.incNumOfStates(5);
        assertEquals(6, fsa.getInitialStateNumber());
    }

    @Test
    public void testFSAIncreaseEdgeNumber() throws Exception {
        fsa.incNumOfStates(5);
        assertEquals(6, fsa.getState(6).getEdge('a').getFromStateNumber());
    }

    @Test
    public void testFSACheckStateExistTrue() throws Exception {
        assertTrue(fsa.isStateExist(1));
    }

    @Test
    public void testFSACheckStateExistFalse() throws Exception {
        assertFalse(fsa.isStateExist(100));
    }

    @Test
    public void testCheckCycleTrue() throws Exception {
        fsa.addState(new State(5, false));
        fsa.getState(4).addEdge(new Edge(5, 'd', 2));
        assertTrue(fsaChecker.check(fsa, "abcdbc"));
    }


    @Test
    public void testCheckCycleFalse() throws Exception {
        fsa.addState(new State(5, false));
        fsa.getState(4).addEdge(new Edge(5, 'd', 2));
        assertFalse(fsaChecker.check(fsa, "abcdb"));
    }

    @Test
    public void testCheckToInitial() throws Exception {
        fsa.addState(new State(5, false));
        fsa.getState(4).addEdge(new Edge(5, 'd', 1));
        assertTrue(fsaChecker.check(fsa, "abcdabc"));
    }

    @Test
    public void testCheckRandomOrderTrue() throws Exception {
        fsa = new FSA();

        fsa.addState(new State(2, false));
        fsa.addState(new State(3, true));
        fsa.addState(new State(1, false));
        fsa.addState(new State(6, true));

        fsa.getState(2).addEdge(new Edge(2, 'a', 1));
        fsa.getState(1).addEdge(new Edge(1, 'b', 3));
        fsa.getState(3).addEdge(new Edge(3, 'c', 6));

        assertTrue(fsaChecker.check(fsa, "abc"));
    }


    @Test
    public void testCheckRandomOrderFalse() throws Exception {
        fsa = new FSA();

        fsa.addState(new State(2, false));
        fsa.addState(new State(3, true));
        fsa.addState(new State(1, false));
        fsa.addState(new State(6, true));

        fsa.getState(2).addEdge(new Edge(2, 'a', 1));
        fsa.getState(1).addEdge(new Edge(1, 'b', 3));
        fsa.getState(3).addEdge(new Edge(3, 'c', 6));

        assertFalse(fsaChecker.check(fsa, "cba"));
    }

    @Test
    public void testCheckMoreEdges() throws Exception {

        fsa.getState(1).addEdge(new Edge(1, 'd', 2));
        fsa.getState(2).addEdge(new Edge(2, 'e', 3));
        fsa.getState(3).addEdge(new Edge(3, 'f', 4));

        assertTrue(fsaChecker.check(fsa, "aef"));
    }

    @Test
    public void testCheckMoreEdges2() throws Exception {

        fsa.getState(1).addEdge(new Edge(1, 'd', 2));
        fsa.getState(2).addEdge(new Edge(2, 'e', 3));
        fsa.getState(3).addEdge(new Edge(3, 'f', 4));

        assertTrue(fsaChecker.check(fsa, "dec"));
    }
    @Test
    public void testCheckMoreEdgesFalse() throws Exception {

        fsa.getState(1).addEdge(new Edge(1, 'd', 2));
        fsa.getState(2).addEdge(new Edge(2, 'e', 3));
        fsa.getState(3).addEdge(new Edge(3, 'f', 4));

        assertFalse(fsaChecker.check(fsa, "deq"));
    }


}