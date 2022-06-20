import java.math.BigInteger;

public class BigIntegerFactorials {

	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println(factorial(100));

	}

	static BigInteger factorial(int N) {
		BigInteger res = new BigInteger("1");
		for(int i = 2; i <= N; i++) {
			res = res.multiply(BigInteger.valueOf(i));
		}
		return res;
	}
}