import java.util.Scanner;
import java.math.BigInteger;

public class BigIntegers {

	/**
	 * Variable are of two types   one - primitives
	 * 							second - objects
	 * 
	 * 
	 */

	public static void main(String[] args) {

		BigInteger b1 = new BigInteger("5");
		System.out.println(b1);

		BigInteger b2 = new BigInteger("1010", 2);
		System.out.println(b2);

		//take input
		Scanner sc  = new Scanner(System.in);

		BigInteger b3 = sc.nextBigInteger();
		System.out.println(b3);

	}
	//Modular Arithemetic
	//Base Conversion 10 => 2 => 8 => 16
	//Power Calculation
	//Bitwise Operators
	//Prime Generation & more!
}