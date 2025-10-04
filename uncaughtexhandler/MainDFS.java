package com.kunal.practice.thread.completionservice.JavaBits.uncaughtexhandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/*
 * Depth-First Search (DFS) is a graph traversal algorithm that explores nodes of
 * a graph/tree by going as deep as possible along one path before backtracking.
 * It’s like exploring a maze by always going forward until you hit a dead end,
 * then retracing steps.
 */
public class MainDFS {

    //Adjacency list representation of DFS.
    private Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    //Adding source and destinations
    public void addEdge(int source, int destination) {
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
        adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>()).add(source);
    }

    public void dfsRecursive(int nodeValue, HashSet<Integer> visited) {
        if(visited.contains(nodeValue)) {
            return;
        }

        visited.add(nodeValue);
        System.out.print(" "+nodeValue);
        for(int child : adjacencyList.get(nodeValue)) {
            dfsRecursive(child, visited);
        }

    }

    /***
     * Time Complexity:
     *
     * O(V + E) → because each vertex and edge is visited once.
     *
     * Space Complexity:
     *
     * O(V) for visited array + recursion stack (worst-case depth).
     * @param args
     */
    public static  void main(String[] args) {
        System.out.println("Hello World");
            MainDFS dfsGraph = new MainDFS();

            // Build a simple graph:
            //    0
            //   / \
            //  1   2
            // / \   \
            // 3  4   5

            dfsGraph.addEdge(0, 1);
            dfsGraph.addEdge(0, 2);
            dfsGraph.addEdge(1, 3);
            dfsGraph.addEdge(1, 4);
            dfsGraph.addEdge(2, 5);

            System.out.println("DFS Recursive Traversal starting from node 0:");
            dfsGraph.dfsRecursive(0, new HashSet<>());
    }

}
