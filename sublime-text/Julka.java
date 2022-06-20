import java.util.*;
import java.lang.*;
import java.math.BigInteger;

class Julka
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		BigInteger N = sc.nextBigInteger();
		BigInteger K = sc.nextBigInteger();
		
		System.out.println(N.subtract(K).divide(BigInteger.valueOf(2)).add(K));
		System.out.println(N.subtract(K).divide(BigInteger.valueOf(2)));
	}
}