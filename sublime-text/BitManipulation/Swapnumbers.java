public class Swapnumbers {

	public static void main(String[] args) {
		int a=5,b=6;
		System.out.println("a="+a+",b="+b);
		//Using third variable
		int c=a;
		a=b;
		b=c;
		//Without using third variable
		a+=b;
		b=a-b;
		a=a-b;
		//Without using third variable and using XOR
		a^=b;
		// 	a = 5 = 101
		// 	b = 6 = 110
		// a =	a | b = 011
		b^=a;//
		// 	b = 6 = 110
		// 	a = 3 = 011
		// b = b | a =	101
		a^=b;
		//     a = 3 = 011
		//     b = 5 = 101
		// a = a | b = 110 
		   
		System.out.println("a="+a+",b="+b);


	
	}
}