public class PercolationStats {

    private Percolation percolation;
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        percolation = new Percolation(n);
    }

    // sample mean of percolation threshold
//    public double mean() {
//
//    }
//
//    // sample standard deviation of percolation threshold
//    public double stddev() {
//
//    }
//
//    // low endpoint of 95% confidence interval
//    public double confidenceLo() {
//
//    }
//
//    // high endpoint of 95% confidence interval
//    public double confidenceHi() {
//
//    }

    // test client (see below)
    public static void main(String[] args) {
        PercolationStats percolationStats = new PercolationStats(10, 3);
    }

}