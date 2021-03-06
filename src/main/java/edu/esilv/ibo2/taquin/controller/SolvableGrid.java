package edu.esilv.ibo2.taquin.controller;

import com.oracle.tools.packager.Log;
import edu.esilv.ibo2.taquin.model.Grid;
import edu.esilv.ibo2.taquin.model.Node;
import edu.esilv.ibo2.taquin.model.Position;
import edu.esilv.ibo2.taquin.model.Tree;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;

public class SolvableGrid {

    private Grid g = new Grid(Party.perfect);
    private ArrayList<Integer> lastMoves = new ArrayList<Integer>();

    public SolvableGrid() {
        g = new Grid(Party.perfect); // perfect grid
    }

    private String getRandomDirection() {

        ArrayList<String> directions = new ArrayList<String>();
        directions.add("getLeft");
        directions.add("getTop");
        directions.add("getRight");
        directions.add("getBottom");

        int rdm = new Random().nextInt() % directions.size();
        Log.info("Random index : " + String.valueOf(rdm));

        return directions.get(rdm);
    }

    private void randomMoveZero() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Log.info("test");
        int rdm = new Random().nextInt() % 4;
        Log.info("Random int : " + String.valueOf(rdm));
        Position pos = null;
        switch (rdm) {
            case 0:
                pos = g.getCaseByKey(0).getPos().getTop();
                break;
            case 1:
                pos = g.getCaseByKey(0).getPos().getRight();
                break;
            case 2:
                pos = g.getCaseByKey(0).getPos().getBottom();
                break;
            case 3:
                pos = g.getCaseByKey(0).getPos().getLeft();
                break;
        }
        if (pos != null && pos.isInGrid()) {
            g.moveCase(g.getCaseByPos(pos));
            lastMoves.add(rdm);
            return;
        }
    }

    public Grid genSolvablegrid(int iterations) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        for (int i = 0; i < iterations; i++) {
            randomMoveZero();
        }
        return g;
    }




}
