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
import java.util.List;
import java.util.Random;
import java.util.HashMap;
import java.util.AbstractMap;
import java.util.Date;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
	
	
		public static void main(String[] args) {
			System.out.println(halvesAreAlike("book"));
		}

    public static boolean halvesAreAlike(String s) {
    	String vowel = "aeiouAEIOU";
    	int leftCount = 0, rightCount = 0;
        List<Character> charList = vowel.chars()
        								.mapToObj(e -> (char)e)
        								.collect(Collectors.toList());
        for(int first = 0,second = s.length() / 2; first < s.length() / 2; first++,second++) {
        	if(charList.contains(s.charAt(first))) {
        		leftCount++;
        	}
        	if(charList.contains(s.charAt(second))) {
        		rightCount++;
        	}
        }
        return leftCount == rightCount;
    }
}