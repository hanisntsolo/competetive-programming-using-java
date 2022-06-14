import java.util.Arrays;

public class Subsets {

	public static void main(String[] args) {
		Subsets subset = new Subsets();
		System.out.println(Arrays.toString(subset.generateSubsets("hanisntsolo")));
	}

	public String[] generateSubsets(String query) {
		int length = query.length();
		String[] result = new String[1 << length];
		for(int i = 0; i < 1 << length; i++) {
			result[i] = getSubset(i, query);
		}
		return result;
	}
	public String getSubset(int num, String query) {
		String res = "";
		int pos = 0;
		while(num > 0) {
			if((num & 1) == 1 ) {
				res+=query.charAt(pos);
			}
			num = num >> 1;
			pos++;
		}
		System.out.println(res);
		return res;
	}
}