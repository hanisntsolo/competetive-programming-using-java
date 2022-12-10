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

	//get i'th bit
	//clear i'th bit
	//set i'th bit

	private static int getIthBit(int num, int i) {
		// 1 0 1 1
		//   |
		//   1
		int mask = (1 << i);
		int result = num & mask;
		return result;
	}

	private static int clearIthBit(int num, int i) {
		int mask = ~(1 << i);
		int result = num & mask;

	}

	private static int setIthBit(int num, int i) {
		// 1 0 1 0
		// 0 1 0 0
		int mask = 1 << i;
		int result = num | mask;
		return result;
	}

	//Update ith bit.
	private static int updateIthBit(int num, int i) {
		//CODE HERE!!
	}

	//clear bits in range.
	private	static int clearBitsInRange(int num, int i, int j) {
		//CODE HERE!!
	}

}