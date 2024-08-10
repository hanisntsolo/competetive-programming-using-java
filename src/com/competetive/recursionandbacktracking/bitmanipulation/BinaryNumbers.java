package com.competetive.recursionandbacktracking.bitmanipulation;

public class BinaryNumbers {

    /**
     * If we have N bits then we can represent 2^n numbers.
     * 32 bit long floats can represent 2^32 numbers;
     * Binary Ops : And & Or
     *
     * @param args
     */
    public static void main(String[] args) {
//        System.out.println(27 & 15);
//        System.out.println(27 ^ 15);
//        System.out.println(27 << 2);
//        System.out.println(100 >> 3);
//        System.out.println(27 >> 1);
        System.out.println(Integer.toBinaryString(121));
        System.out.println(Integer.parseInt(Integer.toBinaryString(1000)));
//        System.out.println(countBits(1000));
        System.out.println(multiply(11L,11L));
        System.out.println(11*11);
    }
    public static int countBits(int n) {
        int counter = 0;
        while(n > 0) {
            System.out.println(n);
            counter++;
            n >>= 1; // divide by 2.
        }
        return counter;
    }
    // O(1) Running time complexity.

    /**
     * 5^1 = 101 -> 5
     *       001 -> 1
     *       -------- XOR
     *       100 -> 4
     *
     * @param n
     * @return
     */
    public static boolean isEven(int n) {
        return (n ^ 1) == n + 1; // XOR Operator with 1 increments the value for even numbers
    }

    /**
     * 6^1 110 -> 6
     *     001 -> 1
     *     -------- XOR
     *     111 -> 7
     *
     * @param n
     * @return
     */
    public static boolean isOdd(int n) {
        return (n ^ 1) == n - 1; // XOR Operator with 1 decrements the value for odd numbers
    }
    /**
     * Russian Peasant Problem
     * a x b = (2a) x (b/2) for even
     * a x b = (2a) x (b/2) + a for odd
     *
     */
    public static long multiply(long a, long b) {
        long result = 0;
        while(b > 0) {
            // if 'b' becomes odd (XOR operator decrements the value by 1 for odd numbers)
            // we want to skip when 'b' is even
            if((b ^ 1) == b - 1)
                result = result + a;

            // double the first number
            a <<= 1;
            // halve the second number
            b >>= 1;
        }
        return result;
    }
    public static int multiply(int a, int b) {
        return b == 1
            ? a : (b ^ 1) == b - 1
            ? a + multiply(2 * a, b / 2) : multiply(2 * a, b / 2);
    }


}
