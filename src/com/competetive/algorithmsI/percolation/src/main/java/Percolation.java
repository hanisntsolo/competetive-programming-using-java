import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation {
    private WeightedQuickUnionUF system;
    private int numberOfOpenSitesLeft;
    private int[] id;
    private int totalRows;
    private int totalCols;
    boolean flag = true;
    int virtualTop;
    int virtualBottom;
    private final int[][] directions = new int[][]{
        {-1, 0}, // UP
        {0, +1}, // RIGHT
        {+1, 0}, // DOWN
        {0, -1} // LEFT
    };
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        numberOfOpenSitesLeft = 0;
        system = new WeightedQuickUnionUF(n * n);
        id = new int[n * n];
        totalRows = n;
        totalCols = n;
//        id[0] = 1;
//        id[n * n - 1] = 1;
        virtualTop = 0;
        virtualBottom = (totalCols * totalRows) - 1;
    }

    // opens the site (row, col) if it is not open already
    // and add union of all 4 directions here.
    public void open(int row, int col) throws IllegalArgumentException {
            System.out.println("Opening" + row +"::"+ col);
            numberOfOpenSitesLeft+=1;
            id[getIndex(row, col)] = 1;
            //Now try to put a union with all other adjacent blocks.
            createUnionOnConnectedBlocks(row, col);
    }

    private void createUnionOnConnectedBlocks (int row, int col) throws IllegalArgumentException {
        for(int i = 0 ; i < directions.length; i++) {
            int nextRow = row + directions[i][0];
            int nextCol = col + directions[i][1];
            if(nextRow > row || nextCol > col || nextRow < 0 || nextCol < 0 || id[getIndex(nextRow, nextCol)] == 0) continue;
            else {
                if(isOpen(nextRow, nextCol) && !system.connected(getIndex(row, col), getIndex(nextRow, nextCol)))
                    system.union(getIndex(row, col), getIndex(nextRow, nextCol));
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) throws IllegalArgumentException {
        StdOut.println("INDEX :: " + "Row" + row + "Col"+ col + "::" + getIndex(row, col) + "Status :: of site " + id[getIndex(row, col)]);
        return id[getIndex(row, col)] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) throws IllegalArgumentException {
        return id[getIndex(row, col)] == 1;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSitesLeft;
    }

    // does the system percolate?
    public boolean percolates() throws IllegalArgumentException {
        for(int i = 0; i < totalCols; i++) {
            if(isOpen(0, i)) {
//                System.out.println("Connected top to bottom" + system.connected(virtualTop, virtualBottom));
                system.union(virtualTop, getIndex(0, i));
            }
            if(isOpen(totalRows - 1, i)) {
//                System.out.println("Connected top to bottom" + system.connected(virtualTop, virtualBottom));
                system.union(getIndex(totalRows - 1, i), virtualBottom);
            }
        }
        return system.connected(virtualTop, virtualBottom);
    }
    //helper to get a one 2D array in form of 1D interpretation
    private int getIndex(int row, int col) {
        int index =  row * totalCols + col;
//        if(index < 0 || index > totalRows * totalCols - 1)
//            throw new IllegalArgumentException("Row and Column Overflowed");
        return index;
    }

    // test client (optional)
    public static void main(String[] args) {
        int N = 5;
        Percolation grid = new Percolation(N);
        while(!grid.percolates()) {
            int randomIndex = StdRandom.uniformInt(N*N);
            int row = randomIndex / N;
            int col = randomIndex % N;
            if(!grid.isOpen(row, col))
                grid.open(row, col);
            System.out.println("Number of open sites left" + grid.numberOfOpenSites());
        }
        System.out.println(grid.numberOfOpenSites());;
    }
}