package com.backtracking.maze;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        int endPosition = 8;
        List<Integer> path = mazeSolver.findPath(startPosition, endPosition, createMaze3x3());
        Assert.assertEquals(Stream.of(0, 3, 4, 7, 8).collect(Collectors.toList()), path);
    }

    private HashMap<Integer, Set<Integer>> createMaze3x3() {
        HashMap<Integer, Set<Integer>> maze = new HashMap<>();
        maze.put(0, Stream.of(1, 3).collect(Collectors.toSet()));
        maze.put(1, Stream.of(2).collect(Collectors.toSet()));
        maze.put(2, Collections.emptySet());
        maze.put(3, Stream.of(4, 6).collect(Collectors.toSet()));
        maze.put(4, Stream.of(5, 7).collect(Collectors.toSet()));
        maze.put(5, Collections.emptySet());
        maze.put(6, Collections.emptySet());
        maze.put(7, Stream.of(8).collect(Collectors.toSet()));
        maze.put(8, Collections.emptySet());
        return maze;
    }
}