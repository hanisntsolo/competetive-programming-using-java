package com.competetive.recursionandbacktracking.recursiontypes;

public class TypesOfRecursion {
    /**
     * TAIL RECURSION
     * 1. If the recursive function call returns at the end of the function
     * then it is called tail recursion.
     *
     * Tail recursion is similar to a (for or while loop.)
     * This method executes all the statements before jumping to the next recursive call.
     */
    /**
     * HEAD RECURSION
     * 1.If the recursive functions call occurs at the beginning of the function
     * then it is called head recursion.
     *
     * This approach saves the state of the function call before jumping into the next recursive
     * call.
     * IMPTT!!
     * head recursion needs more memory because of the states it stores.
     *
     * PROBLEM : Stack overflow error
     * Use tail recursion into iteration C++ compiler optimizes tail recursion.
     */
    public void tail(int n) {
        System.out.println("Calling the function with n="+n);
        if(n == 0)
            return;
        //do something
//        System.out.println("DO SOMETHING");
        System.out.println("The value n="+n);
        //recursive call
        tail(n - 1);
    }
    public void head(int n) {
        System.out.println("Calling the function with n="+n);
        if(n == 0) {
            return;
        }
        //recursive call
        head(n - 1);
        //do something
//        System.out.println("DO SOMETHING");
        System.out.println("The value n="+n);
    }
    //Tail recursion with optimization
    int fact(int n, int acc) {
        if(n == 0) return acc;
        return fact(n - 1,n * acc);
    }
    /**
     * n = 4
     * <- fact(4, (1))
     * <- fact(3, (4 * 1))
     * <- fact(2, (3 * (4 * 1)))
     * <- fact(1, 2 * (3 * 4 * 1))
     * <- fact(0, 24)
     */

    /**
     *
     */
}
