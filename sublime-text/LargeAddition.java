public class LargeAddition {

	public static void main(String[] args) {
		String num1 = "123867878787871878676817878436564687667867481741867978768167164";
		String num2 = "945345345354345345345345345345345354345345345385678645345345354656876546456876459";
		String result = getBigSum(num1, num2);
		System.out.println(result);
	}

	public static String getBigSum(String first, String second) {
		int firstLen = first.length();
		int secondLen = second.length();
		if(firstLen > secondLen)  {
			String temp = first;
			first = second;
			second = temp;
		}
		firstLen = first.length();
		secondLen = second.length();
		int carry = 0;
		int[] result = new int[second.length()];
		int index = 0;
		while(firstLen > 0 || secondLen > 0) {
			int firstNum = 0, secondNum = 0;
			if(firstLen > 0) {
				firstLen--;
				char firstChar = first.charAt(firstLen);
				firstNum = Character.getNumericValue(firstChar);
			}
			if(secondLen > 0) {
				secondLen--;
				char secondChar = second.charAt(secondLen);
				secondNum = Character.getNumericValue(secondChar);
			}
			int sum = firstNum + secondNum;
			int remainder = sum % 10;
			result[index] = remainder + carry;
			carry = sum / 10;
			index++;
		}
		String res = "";
		for(int i = 0; i < result.length; i++) {
			res = result[i] + res;
		}
		return res;
	}
}