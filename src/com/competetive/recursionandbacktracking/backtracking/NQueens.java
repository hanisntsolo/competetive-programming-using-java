package com.competetive.recursionandbacktracking.backtracking;

public class NQueens {
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
