import java.util.Scanner;

public class BitManipulation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		// System.out.println(even(input));
		System.out.println(evenWithOutBit(input));
	}

	private static String even(int num) {
		//if number is even = true
		//if number is odd = false
		int mask = 1;
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


}