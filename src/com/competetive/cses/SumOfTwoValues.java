//package com.competetive.cses;
import java.util.Scanner;
public class SumOfTwoValues {
    public static void positionOfTarget(int[] array, int target) {
        boolean found = false;
        for(int i=0;i<array.length;i++) {
            int numToFind = target - array[i];
            for(int j=i+1;j<array.length;j++) {
                if(array[j] == numToFind) {
                    System.out.println(i+1+" "+(j+1));
                    found = true;
                    break;
                }
            }
            if(found) break;
        }
        if(!found)
        System.out.println("IMPOSSIBLE");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int target = sc.nextInt();
        int[] array = new int[length];
        for(int i=0;i<array.length;i++)
            array[i] = sc.nextInt();
        positionOfTarget(array, target);
    }
}
