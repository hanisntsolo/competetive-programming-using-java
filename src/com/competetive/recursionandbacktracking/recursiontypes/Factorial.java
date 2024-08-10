package com.competetive.recursionandbacktracking.recursiontypes;

public class Factorial {

    public int head(int n) {
        if(n == 1) return 1;
        return n * head(n - 1);
    }
    public int tail(int n, int accumulator) {
        if(n == 0) return accumulator;
        return tail(n - 1, n*accumulator);
    }
    public int factHead(int n) {
        if(n == 0) {
            System.out.println("BASE CASE");
            return 1;
        }
        System.out.println("Before recursion call n="+n);
        int res = n * factHead(n - 1);
        System.out.println("After recursion result res="+res);
        return res;
    }
    public int factTail(int n, int accumulator) {
        if(n == 0) {
            System.out.println("BASE CASE");
            return accumulator;
        }
        System.out.println("Before recursion call n="+n);
        // Decrement the call and Increment the accumulator
        int res = factTail(n - 1, n*accumulator);
        System.out.println("After recursion result res="+res);
        return res;
    }
}
