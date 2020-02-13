package com.backtracking.maze;


import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Class that finds the path in a Maze.
 *
 * @author sebastian.leal
 */
public class MazeSolver {

    private Set<Integer> visitedNodes;
    private List<Integer> path;

    /**
     * Solve the path implementing Backtracking (find one way).
     * <p>
     * It may not be the best possible solution.
     *
     * @param startPosition int with the start Position
     * @param endPosition   int with the end Position
     * @param maze          Map<Integer,Set<Integer>> map with the maze.
     * @return List<Integer> with the solution.
     */
    public List<Integer> solve(int startPosition, int endPosition, Map<Integer, Set<Integer>> maze) {
        visitedNodes = new HashSet<>();
        path = new LinkedList<>();
        solvePath(startPosition, endPosition, maze);
        Collections.reverse(path);
        return path;
    }

    /**
     * Recursive method to find the path between two nodes.
     *
     * @param startPosition int with the start Position
     * @param endPosition   int with the end Position
     * @param maze          Map<Integer,Set<Integer>> map with the maze.
     * @return boolean, true if the path from start to end was found, false otherwise.
     */
    private boolean solvePath(int startPosition, int endPosition, Map<Integer, Set<Integer>> maze) {
        if (!visitedNodes.contains(startPosition)) {
            for (Integer edge : maze.get(startPosition)) {
                if ((edge == endPosition)) {
                    path.add(endPosition);
                    path.add(startPosition);
                    return true;
                }
                if (solvePath(edge, endPosition, maze)) {
                    path.add(startPosition);
                    return true;
                }
            }
        }
        visitedNodes.add(startPosition);
        return false;
    }
}
