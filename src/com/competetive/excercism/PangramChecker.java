package com.competetive.excercism;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
//Static imports for less code
import static java.math.BigInteger.valueOf;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.System.out;
//Utilities
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.AbstractMap;
import java.util.Date;
public class PangramChecker {
    public static boolean isPangram(String str) {
        int[] array = new int[26];
        str = str.toLowerCase();
        for(int i = 0 ;i < str.length(); i++) {
            // 'a' = 65 - 65 = 0
            // 'z' = 90 - 65 = 25
            int currChar = str.charAt(i);
            int index = (int)(str.charAt(i) - 97);
            if(str.charAt(i)<='z' && str.charAt(i)>='a')
                if(array[(int)str.charAt(i) - 97]==0) {
                    array[(int)str.charAt(i) - 97] = 1;
                }
        }
        for(int i = 0; i < 26; i++) {
            if(array[i]==0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        out.println(PangramChecker.isPangram("the quick brown fox jumps over the lazy dog"));
    }
}
