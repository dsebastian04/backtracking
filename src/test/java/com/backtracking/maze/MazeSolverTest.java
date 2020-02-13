package com.backtracking.maze;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MazeSolverTest {

    private MazeSolver mazeSolver;

    @Before
    public void setUp() {
        mazeSolver = new MazeSolver();
    }

    @Test
    void findPath() {
        int startPosition = 0;
        int endPosition = 0;
        HashMap<Integer, Set<Integer>> maze = new HashMap<>();
        mazeSolver.findPath(startPosition, endPosition, maze);
    }
}