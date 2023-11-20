import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Percolation. Given a composite systems comprised of randomly distributed insulating and metallic
 * materials: what fraction of the materials need to be metallic so that the composite system is an
 * electrical conductor? Given a porous landscape with water on the surface (or oil below), under
 * what conditions will the water be able to drain through to the bottom (or the oil to gush through
 * to the surface)? Scientists have defined an abstract process known as percolation to model such
 * situations.
 *
 * <p>The model. We model a percolation system using an n-by-n grid of sites. Each site is either
 * open or blocked.
 *
 * <p>A full site is an open site that can be connected to an open site in the top row via a chain
 * of neighboring (left, right, up, down) open sites.
 *
 * <p>We say the system percolates if there is a full site in the bottom row.
 *
 * <p>In other words, a system percolates if we fill all open sites connected to the top row and
 * that process fills some open site on the bottom row.
 *
 * <p>(For the insulating/metallic materials example, the open sites correspond to metallic
 * materials, so that a system that percolates has a metallic path from top to bottom, with full
 * sites conducting. For the porous substance example, the open sites correspond to empty space
 * through which water might flow, so that a system that percolates lets water fill open sites,
 * flowing from top to bottom.)
 */
public class Percolation {
  private final WeightedQuickUnionUF system;
  private final WeightedQuickUnionUF systemPercolates;
  private final byte[] sites;
  private final int top;
  private final int bottom;
  private final int totalColumns;
  private final int totalRows;
  private int numberOfOpenSites;

  // creates n-by-n grid, with all sites initially blocked
  public Percolation(int n) { // adding 2 extra for top and bottom
    if (n < 1) throw new IllegalArgumentException("Arguments less than 1.");
    top = n * n;
    bottom = n * n + 1;
    totalColumns = n;
    totalRows = n;
    system = new WeightedQuickUnionUF(n * n + 2);
    systemPercolates = new WeightedQuickUnionUF(n * n + 2);
    sites = new byte[n * n]; // 0:closed //1: open //2: Full
    numberOfOpenSites = 0;
  }

  // opens the site (row, col) if it is not open already
  public void open(int row, int col) {
    // what do we do when we are opening the site.
    if (isValidRowColCombination(row, col)) {
      int currSite = getIndex(row, col);
      this.sites[currSite] = 1;
      numberOfOpenSites += 1;

      // Top artificial cell
      if (row == 1 && !(system.find(currSite) == system.find(top))) {
        system.union(currSite, top);
        systemPercolates.union(currSite, top);
      }
      // Bottom artificial cell
      if (row == totalRows) {
        systemPercolates.union(currSite, bottom);
      }
      // Union with bottom cell
      if (row < totalRows)
        if (isOpen(row + 1, col)) {
          system.union(currSite, getIndex(row + 1, col));
          systemPercolates.union(currSite, getIndex(row + 1, col));
        }
      // Union with upper cell
      if (row > 1)
        if (isOpen(row - 1, col)) {
          system.union(currSite, getIndex(row - 1, col));
          systemPercolates.union(currSite, getIndex(row - 1, col));
        }
      // Union with right cell
      if (col < totalColumns)
        if (isOpen(row, col + 1)) {
          system.union(currSite, getIndex(row, col + 1));
          systemPercolates.union(currSite, getIndex(row, col + 1));
        }
      // Union with left cell
      if (col > 1)
        if (isOpen(row, col - 1)) {
          system.union(currSite, getIndex(row, col - 1));
          systemPercolates.union(currSite, getIndex(row, col - 1));
        }
    }
  }

  // is the site (row, col) open?
  public boolean isOpen(int row, int col) {
    return isValidRowColCombination(row, col) && sites[getIndex(row, col)] == 1;
  }

  // is the site (row, col) full?
  public boolean isFull(int row, int col) {
    if (isValidRowColCombination(row, col)) {
      if (!isOpen(row, col)) {
        return false;
      }
    }
    int currSite = getIndex(row, col);
    return system.find(top) == system.find(currSite);
  }

  // returns the number of open sites
  public int numberOfOpenSites() {
    return numberOfOpenSites == 0 ? 0 : numberOfOpenSites - 1;
  }

  // does the system percolate?
  public boolean percolates() {
    return systemPercolates.find(top) == systemPercolates.find(bottom);
  }

  private int getIndex(int i, int j) {
    return (i - 1) * totalColumns + j - 1;
  }

  private boolean isValidRowColCombination(int i, int j) {
    if (i < 1 || j < 1 || i > totalColumns || j > totalRows)
      throw new IllegalArgumentException("Argument out of Bounds!");
    return true;
  }
}
