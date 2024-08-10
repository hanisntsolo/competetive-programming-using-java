package com.competetive.recursionandbacktracking.backtracking;

public class HamiltonianCycleProblem {
    /**
     * 1. a G(V,E) graph is mage up of V vertices (also called as nodes) which are connected by E edges (links)
     * 2. In graph theory a Hamiltonian path is a path is a directed or undirected graph that visits each vertex exactly once.
     * 3. There could be several Hamiltonian paths in a given G(V,E) graph.
     * DIRECTED(directed edges) AND UNDIRECTED(No direction)
     *
     * Question 1. How many permutations are there for N nodes?
     *          2. Brute force has O(N!) running time complexity.
     *          3. We can eliminate and discard multiple states in one iteration if we are using backtracking.
     *
     * We will be using Adjacency matrix to represent the graph.
     *          a   b   c   d   e   f
     * a    [   0   1   0   0   0   1   ]
     * b    [   1   0   1   0   0   0   ]
     * c    [   0   1   0   0   1   0   ]
     * d    [   0   0   0   0   1   1   ]
     * e    [   0   0   1   1   0   1   ]
     * f    [   1   0   0   1   1   0   ]
     *
     * This is so called NP-complete problem.
     * DIRAC-PRINCIPLE: A simple G(V,E) graph with V vertices is hamiltonian if every vertex has degree
     * V/2 or greater
     * Degree is the number of edges of a vertex
     * Note: Finding Hamiltonian path is NP-complete but we can decide whether such path exists in linear
     * time complexity with topological ordering.
     *
     */
    /**
     * THE ALGORITHM (BACKTRACKING)
     * 1. Start with a random node (for example with index 0)
     * 2. Keep adding one of the neighbors of the actual node and we make sure it is not added already to the solution list
     * 3. We may backtrack as necessary.
     *
     */
    static class HamiltonianCycle {
        private int numOfVertices;
        private int[] hamiltonianPath;
        private int[][] adjacencyMatrix;
        public HamiltonianCycle(int[][] adjacencyMatrix) {
            this.adjacencyMatrix = adjacencyMatrix;
            this.numOfVertices = adjacencyMatrix[0].length;
            this.hamiltonianPath = new int[numOfVertices];
        }
        public void solve() {
            // We start with the first vertex with index 0
            hamiltonianPath[0] = 0;
            if(findSolution(1)) {
                showResult();
            } else {
                System.out.println("There is no solution ...");
            }
        }
        private boolean findSolution(int position) {
            if(position == numOfVertices) {
                return adjacencyMatrix[hamiltonianPath[position - 1]][hamiltonianPath[0]] == 1;
            }
            for(int vertexIndex = 1; vertexIndex < numOfVertices; ++vertexIndex) {
                if(isValid(vertexIndex, position)) {
                    // Include the vertex in the hamiltonian path
                    hamiltonianPath[position] = vertexIndex;
                    if(findSolution(position + 1))
                        return true;
                    // BACKTRACK !!!
                    // here we just consider the next vertex.
                }
            }
            // tried all vertex without success.
            return false;
        }
        private boolean isValid(int vertex, int actualPosition) {
            // first criteria: whether the two nodes are connected or not?
            if (adjacencyMatrix[hamiltonianPath[actualPosition - 1]][vertex] == 0)
                return false;
            // second criteria: whether we have already visited teh given node?
            for (int i = 0; i < actualPosition; ++i) {
                if(hamiltonianPath[i] == vertex)
                    return false;
            }
            return true;
        }
        private void showResult() {
            System.out.println("Hamiltonian cycle exist: ");
            for (int i = 0; i < hamiltonianPath.length; ++i) {
                System.out.print(hamiltonianPath[i] + " - ");
            }
            System.out.println(hamiltonianPath[0]);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,   1,   0,   0,   0,   1},
                          {1,   0,   1,   0,   0,   0},
                          {0,   1,   0,   0,   1,   0},
                          {0,   0,   0,   0,   1,   1},
                          {0,   0,   1,   1,   0,   1},
                          {1,   0,   0,   1,   1,   0}};
        HamiltonianCycle hamiltonianCycle = new HamiltonianCycle(matrix);
        hamiltonianCycle.solve();
    }
}
