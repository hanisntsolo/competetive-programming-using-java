package com.competetive.educationalround;
//Static imports for less code
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.System.out;
//Utilities


public class AntiFibonacciPattern {
//    static class PermutingArray {
//        static void permutingArray(java.util.List<Integer> arrayList, int element) {
//            for (int i = element; i < arrayList.size(); i++) {
//                java.util.Collections.swap(arrayList, i, element);
//                permutingArray(arrayList, element + 1);
//                java.util.Collections.swap(arrayList, element, i);
//            }
//            if (element == arrayList.size() - 1) {
//                System.out.println(java.util.Arrays.toString(arrayList.toArray()));
//            }
//        }
//    }
        static class PermutingArray {
                static void permutingArray(List<Integer> arrayList, int element) {
                    for (int i = element; i < arrayList.size(); i++) {
                        Collections.swap(arrayList, i, element);
                        permutingArray(arrayList, element + 1);
                        Collections.swap(arrayList, element, i);
                    }
                    if (element == arrayList.size() - 1) {
//                        printAntiPermute(arrayList.toArray());
                        out.println(Arrays.toString(arrayList.toArray()));
//                        printAntiPermute(Arrays.stream(arrayList).map(o -> (int) o).toArray(int[]::new));
                    }
                }
            }
    public static int permuteCount = 0;
    public static int printFibonacci(int n) {
        int number = n;
        int[] array = new int[number];
        for (int i = 0; i < array.length; i++) {
            array[i] = i+1;
        }
        if(permuteCount<n) {
            permute(array);
        } else {
            return 0;
        }
        permuteCount = 0;
        return 0;
    }
    public static void printAntiPermute(int[] fib) {
        int count = 0;
        for (int i = 2; i <fib.length ; i++) {
            count = i;
            if(fib[i-2]+fib[i-1]!=fib[i]) continue;
            return;
        }
        if(count==fib.length-1 && permuteCount<fib.length) {
            permuteCount+=1;
            for (int i = 0; i < fib.length; i++) {
                out.print(fib[i]+" ");
            }
            out.println();
        }
    }
    public static void permute(int[] arr){
        permuteHelper(arr, 0);
    }
    private static void permuteHelper(int[] arr, int index) {
        if (index >= arr.length - 1) { //If we are at the last element - nothing left to permute
            //System.out.println(Arrays.toString(arr));
            //Print the array
//            System.out.print("[");
            int[] newArray = new int[arr.length];
            for (int i = 0; i < arr.length - 1; i++) {
//                System.out.print(arr[i] + ", ");
                newArray[i] = arr[i];

            }
            if (arr.length > 0)
                newArray[arr.length - 1] = arr[arr.length - 1];
//                System.out.print(arr[arr.length - 1]);
//            System.out.println("]");
            printAntiPermute(newArray);
            return;
        }

        for (int i = index; i < arr.length; i++) { //For each index in the sub array arr[index...end]

            //Swap the elements at indices index and i
            int t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;

            //Recurse on the sub array arr[index+1...end]
            out.println(Arrays.toString(arr));
            if(permuteCount<arr.length) {
                permuteHelper(arr, index + 1);
            } else {
                permuteCount = 0;
                break;
            }
            //Swap the elements back
            t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int testCases = sc.nextInt();
//        int[] num = new int[testCases];
//
//        for (int i = 0; i < testCases; i++) {
//            int number = sc.nextInt();
//            num[i] = number;
//        }
//        for (int i = 0; i < testCases; i++) {
//            printFibonacci(num[i]);
//        }
        PermutingArray
                .permutingArray(java.util.Arrays.asList(9, 8, 7, 6, 4,3,2,1,5,6,7,8,4,3,2,6,8,2,4,6,6), 0);
    }
}
