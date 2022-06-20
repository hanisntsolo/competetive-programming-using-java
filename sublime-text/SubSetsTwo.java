import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SubSetsTwo {

    public static void main(String[] args) {
        int[] query = new int[] {1, 2, 2};
        List<List<Integer>> res = subsetsWithDup(query);
        System.out.println(res);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        int numLen = nums.length;
        List<List<Integer>> superSet = new ArrayList<>();
        for(int i = 0; i < (1 << numLen); i++) {
            List<Integer> subSet = new ArrayList<>();
            int subSetLen = numLen;
            int currNum = i;
            while(subSetLen > 0) {
                int num = nums[subSetLen - 1];
                if((currNum & 1) > 0) {
                    subSet.add(num);
                }
                currNum >>= 1;
                subSetLen-=1;
            } 
            superSet.add(subSet);
        }
        return superSet;
    }
}