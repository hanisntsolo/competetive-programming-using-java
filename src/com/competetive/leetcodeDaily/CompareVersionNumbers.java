package com.competetive.leetcodeDaily;
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
import java.util.*;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] versionFirst = version1.split("\\.");
        String[] versionSecond = version2.split("\\.");
        int len = 0;
        while(len<versionFirst.length || len < versionSecond.length) {
            int first=0,second=0;
            try{
                first = Integer.parseInt(versionFirst[len]);
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
            try{
                second = Integer.parseInt(versionSecond[len]);
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
            if(first<second) return -1;
            else if(first>second) return 1;
            len++;
        }
        return 0;
    }

}
