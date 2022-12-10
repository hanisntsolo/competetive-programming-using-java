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

public class BitManipulation {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		// System.out.println(even(input));
		System.out.println(clearBitsInRange(input, 6, 4));
		printBinary(input);
	}
	private static void printBinary(int num) {
		System.out.println(Integer.toBinaryString(num));
	}

	private static String even(int num) {
		//if number is even = true
		//if number is odd = false
		System.out.print("Num =:");
		printBinary(num);
		int mask = 1;
		int  result = (num & mask);
		System.out.print("Res =:");
		printBinary(result);

		if((num & mask) == 0) {
			return "The number is even";
		} else {
			return "The number is odd";
		}
	}

	// "%" modulo - we are trying to fetch remainder
	// "/" divide - we are trying to fetch quotient

	private static String evenWithOutBit(int num) {
		if(num % 2 == 0) {
			return "The number is EVEN";
		} else {
			return "The number is ODD";
		}
	}

	//get i'th bit
	//clear i'th bit
	//set i'th bit

	// Semester Exams //

	private static int getIthBit(int num, int i) {
		
		// 1 0 1 1
		//   |
		//   1

		int mask = (1 << i);
		System.out.print("Mask=:");
		printBinary(mask);
		int result = num & mask;
		System.out.print("Res =:");
		printBinary(result);
		return result;
	}

	private static int clearIthBit(int num, int i) {
		int mask = ~(1 << i);
		System.out.print("Mask=:");
		printBinary(mask);
		int result = num & mask;
		System.out.print("Res =:");
		printBinary(result);
		return result;
	}

	private static int setIthBit(int num, int i) {
		// 1 0 1 0
		// 0 1 0 0
		int mask = 1 << i;
		int result = num | mask;
		System.out.print("num =:");
		printBinary(num);
		System.out.print("Mask=:");
		printBinary(mask);
		System.out.print("Res =:");
		printBinary(result);
		return result;
	}

	//Update ith bit.
	private static int updateIthBit(int num, int i, int val) {
		//CODE HERE!!
		clearIthBit(num, i);
		int mask = val << i;
		int result = num | mask;
		System.out.print("num =:");
		printBinary(num);
		System.out.print("Mask=:");
		printBinary(mask);
		System.out.print("Res =:");
		printBinary(result);
		return result;
	}

	//clear bits in range.
	private	static int clearBitsInRange(int num, int i, int j) {
		//CODE HERE!!
		int mask1 = (~0 << (i + 1));
		int twosPower = (int)Math.pow(2, j - 1); // 2 ^ 4 = 16 | 15 11111
		System.out.println("Power of two to "+"j "+ twosPower);
		int mask2 = ((twosPower) | ( twosPower - 1)); // 1000
		int mask3 = mask1 | mask2;                   //  0111
		int result = num & mask3;
		System.out.print("num =:");
		printBinary(num);
		System.out.print("Mask1=:");
		printBinary(mask1);
		System.out.print("Mask2=:");
		printBinary(mask2);
		System.out.print("Mask3=:");
		printBinary(mask3);
		System.out.print("Res =:");
		printBinary(result);
		return result;
	}

}