import java.util.Arrays;

public class LargeFactorials {

	public static void main(String[] args) {
		String result = computeFactorial(100);
		System.out.println(result);
	}
	public static String computeFactorial(int number) {
		//Compute the factorial;
		int[] factorials = new int[1000];
		factorials[0] = 1; // 2 4
		int size = 1;
		for(int i = 2; i <= number; i++) {
			int carry = 0;		
			for(int k = 0; k < size; k++) {
				int product = factorials[k] * i + carry;
				factorials[k] = product % 10;
				carry = product / 10;
			}
			//to handle the carry
			while(carry > 0) {
				// System.out.println(carry + " <=> " + Arrays.toString(factorials));	
				factorials[size] = carry % 10;
				carry = carry / 10;
				size = size + 1;
			}
		}
		System.out.println("Size =" + size);
		String result = "";
		for(int i = 1; i <= size; i++) {
			System.out.print(factorials[size - i] + "");
		}
		System.out.println();
		return "";
	}
	public static void multiply(int num, int[] factorials, int size) {
		int carry = 0;
		for(int i = 0; i < size; i++) {
			int product = factorials[i] * num + carry;
			factorials[i] = product % 10;
			carry = product / 10;
		}
		//to handle the carry
		while(carry > 0) {
			// System.out.println(carry + " <=> " + Arrays.toString(factorials));	
			factorials[size] = carry % 10;
			carry = carry / 10;
			size = size + 1;
		}
		// System.out.println("final" + Arrays.toString(factorials));	
	}
}