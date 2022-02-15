package com.competetive.introduction;

//Static imports for less code
import static java.lang.Math.*;
import static java.lang.System.out;
//Utilities
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.AbstractMap;
import java.util.Date;

public class Templating {
    //Peigonehole-Principle: Given an integer n, find a number consisting only of digits 0 and 1.

    //which is divisible by n...
    double number = Math.pow(2,10);

    //Partial sums of an array.
    //Fast modular exponentiation recursive
    public static int fastExpo(int a, long n, int MOD) {
        if(n==0) return 1;
        //a^n % MOD
        if(n%2==0)  //a^n = (a^2)^n/2
            return fastExpo(a*a,n/2,MOD);
        return (a * fastExpo(a,n-1,MOD)) % MOD; //a^n = a*(a)^n-1
    }

    public static boolean[] soe(int n) {
        int length = 100001;
        boolean[] isPrime = new boolean[length];
        for(int i=2;i<n/2;i++) {
            if(!isPrime[i]) {
                for(int j=i*2;j<n;j+=i) {
                    isPrime[j] = true;
                }
            }
        }
        return isPrime;
    }
    public static void print(long[] arr)
        {
            //for debugging only
            for(long x: arr)
                out.print(x+" ");
            out.println();
        }

    public static void main(String[] args) {
//        out.println(min(6,7));
//        out.println(max(4,5));
//        out.println(isPrime(70));
//        print(primeFactors(10847319842138L));
//        print(primeFactors(15));
//        print(primeFactors(313));
//        print(primeFactors(300));
        boolean[] primes = soe(100000);
        long primeSum = 0;
        for (int i = 2; i <10000 ; i++) {
            if(!primes[i]) {
//                out.print(i + " ");
                primeSum+=i;
            }
        }
//        out.println();
//        out.println(primeSum);
        out.println(fastExpo(2,10,234));
    }

    public static boolean isPrime(long num) {
        if(num<=1) return false;
        for (long i = 2; i <num; i++) {
            if(num%i==0) return false;
        }
        return true;
    }
    public static long[] primeFactors(long num) {
        long[] f = new long[100];
        long[] expo = new long[100];
        long d = 2,len=-1;
        if(num == 1) {
            len++;
            f[(int) len] = d;
            expo[(int) len] = 0;
            return f;
        }
        while(d*d<=num && num>1) {
            long k=0;
            while(num%d==0) {
                k++;
                num/=d;
            }
            if (k > 0) {
                len++;
                f[(int) len] = k;
                expo[(int) len] = d;
            }
            d++;
        }
        if(num>1) {
            len++;
            f[(int) len] = num;
            expo[(int) len] = 1;
        }
        return f;
    }

}
