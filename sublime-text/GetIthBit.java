import java.util.Scanner;

public class GetIthBit {

	public static void main(String[] args) {
		GetIthBit getBit = new GetIthBit();
		// Scanner sc = new Scanner(System.in);
		// int n = sc.nextInt();
		// System.out.println(getBit.getIthBit(16, n));
		// System.out.println(getBit.clearIthBit(16, 4));
		// System.out.println(getBit.setIthBit(5, 1));
		int number = 5;
		int result = getBit.updateIthBit(number, 1, 0);
		System.out.println(result);
		result = getBit.updateIthBit(number, 1, 1);
		System.out.println(result);

	}

	public int getIthBit(int num, int bit) {
		int mask = (1 << bit);
		return (num & mask) > 0 ? 1 : 0;
	}
	// 000101
	public int clearIthBit(int num, int bit) {
		int mask = 1 << bit;
		return num & (~mask);
	}
	public int setIthBit(int num, int bit) {
		int mask = 1 << bit;
		return num | mask;
	}
	public int updateIthBit(int num, int bit, int value) {
		clearIthBit(num, bit);
		int mask = value << bit;
		num = num | mask;
		return num;
	}

}