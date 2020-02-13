package com.backtracking.maze;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MazeSolverTest {

    private MazeSolver mazeSolver;

    @Before
    public void setUp() {
        mazeSolver = new MazeSolver();
    }

    @Test
    public void findPath() {
        int startPosition = 0;
        int endPosition = 8;
        List<Integer> path = mazeSolver.solve(startPosition, endPosition, createMaze3x3());
        Assert.assertEquals(Stream.of(0, 3, 4, 7, 8).collect(Collectors.toList()), path);
    }

    @Test
    public void findPath_2() {
        int startPosition = 0;
        int endPosition = 8;
        List<Integer> path = mazeSolver.solve(startPosition, endPosition, createMaze3x3_double_path());
        Assert.assertEquals(Stream.of(0, 3, 4, 5, 8).collect(Collectors.toList()), path);
    }

    /**
     * 0 -> 1 -> 2
     * |
     * v
     * 3 -> 4 -> 5
     * |    |
     * v    v
     * 6    7 -> 8
     *
     * @return
     */
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

    /**
     * 0 -> 1 -> 2
     * |
     * v
     * 3 -> 4 -> 5
     * |    |    |
     * v    v    v
     * 6    7 -> 8
     *
     * @return
     */
    private HashMap<Integer, Set<Integer>> createMaze3x3_double_path() {
        HashMap<Integer, Set<Integer>> maze = new HashMap<>();
        maze.put(0, Stream.of(1, 3).collect(Collectors.toSet()));
        maze.put(1, Stream.of(2).collect(Collectors.toSet()));
        maze.put(2, Collections.emptySet());
        maze.put(3, Stream.of(4, 6).collect(Collectors.toSet()));
        maze.put(4, Stream.of(5, 7).collect(Collectors.toSet()));
        maze.put(5, Stream.of(8).collect(Collectors.toSet()));
        maze.put(6, Collections.emptySet());
        maze.put(7, Stream.of(8).collect(Collectors.toSet()));
        maze.put(8, Collections.emptySet());
        return maze;
    }
}