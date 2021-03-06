package edu.esilv.ibo2.taquin.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.*;

public class _CaseTest {

    private Grid testGrid;
    private Case case1;
    private Case case1b;
    private Case case2;
    private Case case3;
    private Case case7;
    private Case case11;
    private Case case0;
    private Case case12;
    private Case case13;
    private Case case15;
    private Case caseNotInGrid;
    private Case caseNotInGrid3;

    @Before
    public void initTests() throws Exception{
        /*
         y=0  y=1  y=2  y=3
         -------------------
 x=0    |  1 |  2 |  3 |  4 |
 x=1    |  5 |  6 |  7 |  8 |
 x=2    |  9 | 10 | 11 | 12 |
 x=3    | 13 | 14 | 15 |  0 |
         -------------------
         */
        ArrayList<Integer> config1 = new ArrayList<Integer>();
        config1.add(1);
        config1.add(2);
        config1.add(3);
        config1.add(4);
        config1.add(5);
        config1.add(6);
        config1.add(7);
        config1.add(8);
        config1.add(9);
        config1.add(10);
        config1.add(11);
        config1.add(12);
        config1.add(13);
        config1.add(14);
        config1.add(15);
        config1.add(0);
        testGrid = new Grid(config1);
        case1 = new Case(1, 0, 0);
        case1b = new Case(case1);
        case2 = new Case(0, 0, 1);
        case2.setKey(2);
        case3 = new Case(3, 0, 2);
        case7 = new Case(7, 1, 2);
        case0 = new Case(0, 3, 3);
        Position pos11 = new Position(0, 0);
        case11 = new Case(11, pos11);
        case11.setPos(2, 2);
        Position pos12 = new Position(2, 3);
        case12 = new Case(12, new Position());
        case12.setPos(pos12);
        case13 = new Case(13, 3, 0);
        case15 = new Case(15, 3, 2);
        caseNotInGrid = new Case(42, 12, 1);
        caseNotInGrid3 = new Case(2, -4, 1);
    }

    @Test
    public void getTop() throws Exception {
        assertNull(case1.getTop(testGrid));
        assertNotNull(case0.getTop(testGrid));
        assertEquals(case0.getTop(testGrid).getPos().getX(), 2);
        assertEquals(case0.getTop(testGrid).getPos().getY(), 3);
        assertNotNull(case12.getTop(testGrid));
        assertEquals(case12.getTop(testGrid).getPos().getX(), 1);
        assertEquals(case12.getTop(testGrid).getPos().getY(), 3);
        assertNotNull(case13.getTop(testGrid));
        assertEquals(case13.getTop(testGrid).getPos().getX(), 2);
        assertEquals(case13.getTop(testGrid).getPos().getY(), 0);
    }

    @Test
    public void getRight() throws Exception {
        assertNull(case12.getRight(testGrid));
        assertNotNull(case1.getRight(testGrid));
        assertEquals(case1.getRight(testGrid).getPos().getX(), 0);
        assertEquals(case1.getRight(testGrid).getPos().getY(), 1);
        assertNotNull(case11.getRight(testGrid));
        assertEquals(case11.getRight(testGrid).getPos().getX(), 2);
        assertEquals(case11.getRight(testGrid).getPos().getY(), 3);
        assertNotNull(case13.getRight(testGrid));
        assertEquals(case13.getRight(testGrid).getPos().getX(), 3);
        assertEquals(case13.getRight(testGrid).getPos().getY(), 1);
    }

    @Test
    public void getBottom() throws Exception {
        assertNull(case0.getBottom(testGrid));
        assertNotNull(case1.getBottom(testGrid));
        assertEquals(case1.getBottom(testGrid).getPos().getX(), 1);
        assertEquals(case1.getBottom(testGrid).getPos().getY(), 0);
        assertNotNull(case11.getBottom(testGrid));
        assertEquals(case11.getBottom(testGrid).getPos().getX(), 3);
        assertEquals(case11.getBottom(testGrid).getPos().getY(), 2);
        assertNotNull(case7.getBottom(testGrid));
        assertEquals(case7.getBottom(testGrid).getPos().getX(), 2);
        assertEquals(case7.getBottom(testGrid).getPos().getY(), 2);
    }

    @Test
    public void getLeft() throws Exception {
        assertNull(case1.getLeft(testGrid));
        assertNotNull(case3.getLeft(testGrid));
        assertEquals(case3.getLeft(testGrid).getPos().getX(), 0);
        assertEquals(case3.getLeft(testGrid).getPos().getY(), 1);
        assertNotNull(case11.getLeft(testGrid));
        assertEquals(case11.getLeft(testGrid).getPos().getX(), 2);
        assertEquals(case11.getLeft(testGrid).getPos().getY(), 1);
        assertNotNull(case7.getLeft(testGrid));
        assertEquals(case7.getLeft(testGrid).getPos().getX(), 1);
        assertEquals(case7.getLeft(testGrid).getPos().getY(), 1);
    }

    @Test
    public void isInGrid() throws Exception {
        assertTrue(case0.isInGrid());
        assertTrue(case7.isInGrid());
        assertFalse(caseNotInGrid.isInGrid());
        assertFalse(caseNotInGrid3.isInGrid());
    }

    @Test
    public void isMovable() throws Exception {
        assertTrue(case12.isMovable(testGrid));
        assertFalse(case1.isMovable(testGrid));
        assertTrue(case15.isMovable(testGrid));
    }

    @Test
    public void isEqual() throws Exception {
        assertFalse(case1.isEqual(case2));
        assertTrue(case1.isEqual(case1b));
        assertFalse(case12.isEqual(case0));
    }

    @Test
    public void equals() throws Exception {
        assertFalse(case1b.isEqual(case2));
        case1b.equals(case2);
        assertTrue(case1b.isEqual(case2));
    }

    @Test
    public void testString() throws Exception {
        assertTrue(case1.toString().contains(String.valueOf(case1.getKey())));
        assertTrue(case1.toString().contains(case1.getPos().toString()));
    }

    @Test
    public void setKey() throws Exception {
        Case testCase = new Case(12, 1, 3);
        testCase.setKey(4);
        assert testCase.getKey() == 4;
    }

    @Test
    public void setPos() throws Exception {
        Case testCase = new Case(12, 1, 3);
        testCase.setPos(3, 1);
        assert testCase.getPos().getX() == 3;
        assert testCase.getPos().getY() == 1;
    }
}