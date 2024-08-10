package com.competetive.recursionandbacktracking.recursion;

import recursiontypes.EuclidianAlgorithm;
import recursiontypes.Factorial;
import recursiontypes.Fibonacci;
import recursiontypes.Sum;
import recursiontypes.TowerOfHanoi;
import recursiontypes.TypesOfRecursion;

public class RecursionAndBackTracking {

    /**
     * Recursion is a method where the solution to a problem
     * depends on solution to smaller instances
     * of the same problem.
     * So we break the tasks into smaller and smaller subtasks
     * This approach can be applied to several types of problems - this is
     * why recursion is in the center of computer science.
     * Recursion -- center of computer science.
     * Graphs
     * Binary Search Tree.
     * Define base cases to infinite loops. Need to track when to solve recursion.
     *
     * EVERY PROBLEM CAN BE SOLVED EITHER WITH RECURSION OR ITERATION.
     *
     * RECURSION :
     * We have to track the function calls.
     * No need to define another data structure to keep the track of the state it will be done by the operating system.
     * Function calls are pushed on to the stack and popped when needed.
     * During recursion, we have to track what function calls occurred and what
     * arguments are to be handed over.
     *
     * @param args
     * Conclusion bw head and tail recursion (This happens in C++ Compiler)
     * We don't need any backtracking and hence tail recursion with acc optimization is the best.
     *
     */

    public static void main(String[] args) {
        System.out.println("This is it.");
        Factorial factorial = new Factorial();

        System.out.println(factorial.head(5));;
        System.out.println(factorial.tail(5,1));

        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.head(0));
        System.out.println(fibonacci.head(5));
        System.out.println(fibonacci.head(10));
        System.out.println(fibonacci.tail(10, 0, 1));

        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        towerOfHanoi.solve(2, 'A', 'B', 'C');

        Sum sum = new Sum();
        System.out.println(sum.recursiveSum(5));
        System.out.println(sum.iterativeSumWhile(5));
        System.out.println();
        TypesOfRecursion recursionTypes = new TypesOfRecursion();
//        recursionTypes.head(5);
//        recursionTypes.tail(5);

//        factorial.factHead(5);
//        factorial.factTail(5,1);
        EuclidianAlgorithm euclidianAlgorithm = new EuclidianAlgorithm();
        System.out.println(euclidianAlgorithm.gcd(10,5));
        System.out.println(euclidianAlgorithm.gcd(240,65));
        System.out.println(euclidianAlgorithm.gcdIteration(240,65));
    }

    /**
     *
     *      * JUNIOR
     *      *    reverse(UNIOR) + J
     *      *    reverse(NIOR) + U
     *      *    reverse(IOR) + N
     *      *    reverse(OR) + I
     *      *    reverse(R) + O
     *      *    reverse("") + R
     *      *    Backtracking the calls we get the reverse.
     *      *    ROINUJ
     *      *
     *      *
     * @param s
     * @return
     */
    String reverse(String s) {
        if(s.equals("")) return s;
        return reverse(s.substring(1)) + s.charAt(0);
    }



}
/**
 * Memory Management :
 * Stack mem stores local variables as well.
 *
 */
/**
 * Heap Memory : Place where dynamic memory allocation takes place.
 * Heap mem (larger than) > stack mem
 * Stack memory has the references which point object to the heap memory.
 * Heap Memory is slower than stack memory.
 * It can become fragmented. FRAGMENTATION!.
 */
/**
 * Small is size but faster to access.
 * Stack Frames cannot be fragmented.
 * Stack Overflow might occur. Large amount of stack frames cannot be handled by stack size.
 *
 */
/**
 * Notes :
 * 1. Generated machine level binary code must be loaded into memory.
 * 2. Random Access Memory that is used to run programs.
 *
 */

/**
 *
 * HEAP : Contains objects
 * STACK : Contains references
 * MACHINE CODE
 *
 */

/**
 * Minimax Algorithm is a perfectly implemented depth first search.
 * 2.Need to return after execution of particular method.
 */