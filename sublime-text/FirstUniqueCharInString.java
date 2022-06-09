
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;

public class FirstUniqueCharInString {

	public static void main(String[] args) {
		FirstUniqueCharInString obj = new FirstUniqueCharInString();

		System.out.println(obj.firstUniqChar("dhirendra"));
		System.out.println(obj.firstUniqChar("leetcode"));
		System.out.println(obj.firstUniqChar("loveleetcode"));
		System.out.println(obj.firstUniqChar("aabb"));

	}

	public int firstUniqChar(String s) {
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		char[] charArray = s.toCharArray();
		for (char ch : charArray) {
			if(!map.containsKey(ch)) {
				map.put(ch, 1);
			} else {
				int currentCount = map.get(ch);
				map.put(ch, currentCount + 1);
			}
		}
		System.out.println(map);
		Set<Map.Entry<Character, Integer>> entries = map.entrySet();
		Iterator<Map.Entry<Character, Integer>> iter = entries.iterator();
		while(iter.hasNext()) {
			Map.Entry<Character, Integer> entry = iter.next();
			if(entry.getValue() == 1) {
				return search(s, entry.getKey());
			}
		}
		return -1;
		// for (Iterator iter : map.entrySet()) {
		// 	System.out.println(iter);
		// }
	}
	public int search(String s, char character) {
		return s.indexOf(character);
	}
}