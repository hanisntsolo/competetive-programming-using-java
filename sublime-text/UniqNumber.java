import java.util.Arrays;

public class UniqNumber {

	public static void main(String[] args) {
		UniqNumber object = new UniqNumber();
		int[] array = new int[] {1, 2, 3, 4, 5,100,5, 4, 3, 2, 1};
		System.out.println(object.uniqNumber(array));
		int[] array1 = new int[] {1, 2, 3, 4,5, 50,100,5, 4, 3, 2, 1};
		int[] array3 = new int[] {1, 1, 1, 4, 5, 5, 5};


		System.out.println(object.uniqNumberTwo(array1));
		System.out.println(Arrays.toString((object.uniqNumberTwo(array1))));
		System.out.println(object.uniqNumberThreeNplusOne(array3));
	}

	public int uniqNumber(int[] nums) {
		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			result ^= nums[i];
		}
		return result;
	}

	public int[] uniqNumberTwo(int[] nums) {
		int result = 0;
		for (int i=0; i < nums.length; i++) {
			result^=nums[i];
		}
		//Position of set bit

		int pos = 0;
		int temp = result;
		while((temp&1) == 0) {
			pos++;
			temp = temp >> 1;
		}

		//Filtering the two numbers based on set bit
		int setA = 0;
		int setB = 0;
		int mask = 1 << pos;
		for(int i = 0; i < nums.length; i++) {
			if((mask & nums[i]) > 0) {
				setA ^= nums[i];
			} else {
				setB ^= nums[i];
			}
		}
		int [] res = new int[] {setA, setB};
		return res;
	}
	public void updateBitSum(int num, int[] bitSums) {
		for(int i=0; i < 32;i++) {
			int ith_bitIsSet = (num & (1 << i));
			if(ith_bitIsSet != 0) { //Very Important in terms of java and C++;
				bitSums[i]++;
			} // 7 & ...001 => ...001 = 1 
		}
	}

	public int uniqNumberThreeNplusOne(int[] nums) {
		int[] bitSums = new int[32];
		for(int num : nums) {
			updateBitSum(num, bitSums);
		}
		System.out.println(Arrays.toString(bitSums));
		for(int i = 0; i < bitSums.length; i++) {
			bitSums[i] = bitSums[i] % 3;
		}

		int result = 0;
		for(int i = 0; i < bitSums.length; i++) {
			result += bitSums[i] * (1 << i);
		}
		return result;
	}
}