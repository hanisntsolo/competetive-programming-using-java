package com.competetive.recursionandbacktracking.recursiontypes;

public class EuclidianAlgorithm {
    /**
     * Is an efficient method of computing the gcd of two integers -
     * THE LARGEST NUMBER THAT DIVIDES THEM BOTH WITHOUT LEAVING A REMAINDER.
     *
     * Working Principle : Greatest common divisor of two numbers DOES NOT CHANGE
     * if the larger number is replaced by its difference with the smaller number.
     */
    /**
     *
     *
     *  45 10
     *  45 = 10 * 4 + (5) is nothing but a % b
     *  10 = 5 * 2 + (0) is noting but a % b
     * @param a first parameter greater than b
     * @param b seconds parameter smaller than a
     * @return gcd(a,b)
     */
    public int gcd(int a, int b) {
        // can check with b == 0 or a % b == 0 and return a; BASE CASE
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public int gcdIteration(int a, int b) {
        int temp = b;
        while(b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
