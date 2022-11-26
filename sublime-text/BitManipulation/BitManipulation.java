import java.math.BigInteger;

public class BitManipulation {

	public static void main(String[] args) {
		System.out.println("BitManipulation.class");
		System.out.println("Bit present is =" + BitManipulation.getIthBit(5, 2)); // Expected output =>
	}
	// num = 5 101
	// bit = 3 |
	public static int getIthBit(int num, int bit) {
		int mask = 1 << bit;
		System.out.println(mask);
		return ((num & mask) > 0) ? 1 : 0;
	}
	// 000101
	// public int clearIthBit(int num, int bit) {

	// }
	// public int setIthBit(int num, int bit) {

	// }
	// public int updateIthBit(int num, int bit, int value) {

	// }

	// public int clearLastIBits(int num, int bit) {

	// }

	// public int clearBitsInRange(int num, int j, int i) {

	// }

	// public int countBits(int num) {

	// }
	// //Hack to count the set bits;
	// public int hackCountBits(int num) {

	// }

	// public int convertToBinary(int num) {

	// }
}