package com.competetive.recursionandbacktracking.recursiontypes;

public class Sum {
    public int recursiveSum(int n) {
        //base case to avoid infinite loop
        // WHEN TO TERMINATE THE ALGORITHM
        if(n <= 1) return n;
        //recursive case
        return n + recursiveSum(n - 1);
    }
    public int iterativeSumWhile(int n) {
        int sum = 0;
        while(n > 0) {
            sum+=n;
            n--;
        }
        return sum;
    }
    int iterativeSumFor(int n) {
        int result = 0;
        for(int num = 1; num <= n; num++) {
            result += num;
        }
        return result;
    }
    /**
     * sum(5) -> 5 + sum(4) -> 4 + sum(3) -> 3 + sum(2) -> 2 + sum(1) + 1 + sum(0)
     *   15      5  + 10   <-  4 +  6     <- 3 + 3      <-  2 +  1    <- 1 + 0
     */
}
