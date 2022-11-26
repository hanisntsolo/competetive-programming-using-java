import java.util.Scanner;

public class BitManipulation {

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		// int input = sc.nextInt();
		System.out.println(even(10));
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


}