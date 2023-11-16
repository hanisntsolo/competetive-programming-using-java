

public class Percolation {

    private int numberOfOpenSitesLeft;
    private int[] id;
    private rows;
    private cols;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
    	numberOfOpenSitesLeft = 0;
    	id = new int[n * n];
    	totalrows = n;
    	totalcols = n;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
    	if(!isOpen(row, col)) {
    		numberOfOpenSitesLeft+=1;
    		id[getIndex(row, col)] = 1;
    	}
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
    	return id[getIndex(row, col)] == 0;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
    	return id[getIndex(row, col)] == 1;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
    	return numberOfOpenSitesLeft;
    }

    // does the system percolate?
    public boolean percolates() {

    }
    //helper to get a one 2D array in form of 1D interpretation
    private int getIndex(int row, int col) {
    	return row * totalcols + col;
    }

    // test client (optional)
    public static void main(String[] args)
}