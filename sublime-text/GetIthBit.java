//import java.util.Scanner;
//
//public class GetIthBit {
//
//	public static void main(String[] args) {
//		GetIthBit getBit = new GetIthBit();
//		// Scanner sc = new Scanner(System.in);
//		// int n = sc.nextInt();
//		// System.out.println(getBit.getIthBit(16, n));
//		// System.out.println(getBit.clearIthBit(16, 4));
//		// System.out.println(getBit.setIthBit(5, 1));
//		int number = 5;
//		int result = getBit.updateIthBit(number, 1, 0);
//		System.out.println(result);
//		result = getBit.updateIthBit(number, 1, 1);
//		System.out.println(result);
//		number = 15;
//		number = getBit.clearLastIBits(number, 3);
//		System.out.println(number);
//		number = 31;
//		number = getBit.clearBitsInRange(number, 3, 1);
//		System.out.println(number);
//		number = getBit.countBits(number);
//		System.out.println(number);
//		System.out.println(getBit.countBits(8));
//		System.out.println(getBit.hackCountBits(8));
//		System.out.println(getBit.convertToBinary(8));
//		System.out.println(getBit.convertToBinary(14));
//		System.out.println(getBit.convertToBinary(24));
//		System.out.println(getBit.convertToBinary(9));
//	}
//
//	public int getIthBit(int num, int bit) {
//		int mask = (1 << bit);
//		return (num & mask) > 0 ? 1 : 0;
//	}
//	// 000101
//	public int clearIthBit(int num, int bit) {
//		int mask = 1 << bit;
//		return num & (~mask);
//	}
//	public int setIthBit(int num, int bit) {
//		int mask = 1 << bit;
//		return num | mask;
//	}
//	public int updateIthBit(int num, int bit, int value) {
//		clearIthBit(num, bit);
//		int mask = value << bit;
//		num = num | mask;
//		return num;
//	}
//
//	public int clearLastIBits(int num, int bit) {
//		int mask = -1 << bit;
//		return num & mask;
//	}
//
//	public int clearBitsInRange(int num, int j, int i) {
//		// int a = -1 << (j + 1);
//		int a = ~0 << (j + 1);
//		int b = (1 << i) - 1;
//		int mask = a | b;
//		return num & mask;
//	}
//
//	public int countBits(int num) {
//		int count = 0;
//		while(num > 0) {
//			int lastBit = (num & 1);
//			count += lastBit;
//			num>>=1;
//		}
//		return count;
//	}
//	//Hack to count the set bits;
//	public int hackCountBits(int num) {
//		int count = 0;
//		while(num > 0) {
//			num = num & (num - 1);
//			count++;
//		}
//		return count;
//	}
//
//	public int convertToBinary(int num) {
//		int result = 0;
//		int power = 1;
//		while(num > 0) {
//			int lastBit = num & 1;
//			result += power * lastBit;
//			power*=10;
//			num = num >> 1;
//		}
//		return result;
//	}
//
//
//}