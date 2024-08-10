package com.competetive.recursionandbacktracking.recursiontypes;

public class Fibonacci {

    /**
     * Recursion have something to do with breadth first search with a tree like structure.
     * @param n
     * @return
     */
    public int head(int n) {
        if(n <= 1) return n;
        // first we call
//        System.out.println("Calling for number : " + n);
        int fib1 = head(n - 1); // This can at worst make 1 -> 1.
        int fib2 = head(n - 2); // This can make n to be 0 -> 0.
        // make some operations
        int result = fib1 + fib2;
        // this is why DYNAMIC PROGRAMMING; since we are doing twin calculations.
        return result;
    }
    public int tail(int n, int a, int b) {
        if(n == 0) return a;
        if(n == 1) return b;
        return tail(n - 1, b, b + a);
    }

}
