import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
  private static final double CONFIDENCE_95 = 1.96D;
  private final double[] threshold;
  private final int tRes;

  // perform T independent computational experiments on an N-by-N grid
  public PercolationStats(int n, int t) {
    if (n < 1 || t < 1) {
      throw new IllegalArgumentException();
    }
    tRes = t;
    threshold = new double[t];

    for (int i = 0; i < threshold.length; i++) {
      threshold[i] = calcThreshold(n);
    }
  }

  // test client, described below
  public static void main(String[] args) {
    PercolationStats stats =
        new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    System.out.println("mean                    = " + stats.mean());
    System.out.println("stddev                  = " + stats.stddev());
    System.out.println(
        "95% confidence interval = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
  }

  private double calcThreshold(int n) {
    double counter = 0;
    counter = getCounter(n, counter);
    return counter / (n * n);
  }

  private double getCounter(int n, double counter) {
    int i;
    int j;
    Percolation percolation = new Percolation(n);
    while (!percolation.percolates()) {
      i = StdRandom.uniformInt(n) + 1;
      j = StdRandom.uniformInt(n) + 1;
      if (!percolation.isOpen(i, j)) {
        counter++;
        percolation.open(i, j);
      }
    }
    return counter;
  }

  // sample mean of percolation threshold
  public double mean() {
    return StdStats.mean(threshold);
  }

  // sample standard deviation of percolation threshold
  public double stddev() {
    return StdStats.stddev(threshold);
  }

  // returns lower bound of the 95% confidence interval
  public double confidenceLo() {
    return mean() - (CONFIDENCE_95 * stddev()) / (Math.sqrt(tRes));
  }

  // returns upper bound of the 95% confidence interval
  public double confidenceHi() {
    return mean() + (CONFIDENCE_95 * stddev()) / (Math.sqrt(tRes));
  }
}
