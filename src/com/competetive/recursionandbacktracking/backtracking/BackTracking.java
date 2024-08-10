package com.competetive.recursionandbacktracking.backtracking;

public class BackTracking {

    /**
     * With the help of backtracking we dont need to consider all the states because,
     * we can remove bad states by a margin.
     * Backtracking is a form of [recursion]
     *
     * General algorithm for finding all solutions to some computational problems.
     * called Constraint satisfaction problems.[Pattern]
     * It is often much faster than brute force enumeration of all complete candidates,
     * because it can eliminate a large number of candidates with a single test.
     * N-queens problem or Sudoku
     *  BRUTE FORCE:
     *      we consider and evaluate all the possible solutions one by one
     *      until we find the solution.
     *  BACK-TRACKING: Fundamental Principle.
     *      We can discard several bad states with just a single iteration
     *      if partial candidate A cannot be completed to a valid solution then
     *      we abandon A as a solution.
     *      1.Each partial candidate is the parent of the candidates that differ from it by a single
     *      extension step
     *      2.Leaves of the tree are the partial candidates that cannot be extended any further
     *      3.The backtracking algorithm traverses this search tree recursively from root down - like
     *      depth first search.
     *
     *      CAN BE CALLED GAME TREE OR SEARCH TREE.
     *
     *      BACKTRACKING IS CALLED DEPTH FIRST SEARCH IF APPLIED ON TREES
     *
     *      Backtracking is also called depth first search and vice versa.
     *
     *      1. For every node the algorithm checks whether the given node can be completed to a valid solution.
     *      2. If it can not then the whole subtree is skipped (this is the key advantage of backtracking)
     *      3. It recursively enumerates all subtree of the node.
     *
     * TIP: MINIMAX algo can compute all the optimal move in tick-tac-toe.
     */
    public static void main(String[] args) {
        NQueens nQueens = new NQueens(4);
        nQueens.solve();
    }
    //Implement yourself ;

    /**
     * PROBLEM STATEMENT: Place N Queens on an NxN chessboard so that no two queens threaten
     * each other.
     * 2. Queens can attack horizontally, vertically and we have to consider the diagonals too.
     * 3. The Original problem was designed for 8 queens so (N=8)
     * 4. Gauss worked on the problem and Dijkstra used this problem to illustrate the power of what
     * he called structured programming.
     *
     * ANOTHER PROBLEM: There are an extremely huge states to consider.
     */
    /**
     * How do we backtrack?
     */
    static class NQueens {
        // Represent chess board with two dimension array.
        private int[][] chessTable;
        private int numOfQueens;
        public NQueens(int numOfQueens) {
            this.numOfQueens = numOfQueens;
            this.chessTable = new int[numOfQueens][numOfQueens];
        }
        public void solve(){
            if(setQueens(0)) { // means there is a solution
                printQueens();
            } else {
                System.out.println("There is no solution ...!");
            }
        }
        private boolean setQueens(int colIndex) {
            // it means that we have already found the location for N Queens (problem solved)
            if(colIndex == numOfQueens) {
                return true;
            }
            // consider all the possible locations in the given column one by one.
            for (int rowIndex = 0; rowIndex < numOfQueens; rowIndex++) {
                if(isPlaceValid(rowIndex, colIndex)) {
                    chessTable[rowIndex][colIndex] = 1;
                    // Solve the problem for next queen (colIndex + 1)
                    if(setQueens(colIndex + 1))
                        return true;
                    // BACKTRACK !!!!
                    chessTable[rowIndex][colIndex] = 0;
                }
            }
            // can not found a valid position (we have tried all the rows without any success)
            // have to change the position of already settled queens.
            return false;
        }
        private boolean isPlaceValid(int rowIndex, int colIndex){
            // there can not be any queen on the left row.
            for (int i = 0; i < colIndex; i++) {
                if  (chessTable[rowIndex][i] == 1) {
                    return false;
                }
            }
            // we do not have to check the columns.

            // we have to check diagonal locations
            for (int i = rowIndex, j = colIndex;i>=0 && j>=0;i--,j--) {
                if(chessTable[i][j] == 1)
                    return false;
            }
            for (int i = rowIndex, j = colIndex; i < chessTable.length && j >= 0; i++, j--){
                if(chessTable[i][j] == 1)
                    return false;
            }
            // else valid position
            return true;
        }
        public void printQueens() {
            for (int i = 0; i < chessTable.length; i++) {
                for (int j = 0; j < chessTable.length; j++) {
                    if(chessTable[i][j] == 1) {
                        System.out.print(" * ");
                    } else {
                        System.out.print(" - ");
                    }
                }
                System.out.println();
            }
        }
    }

}
