import java.util.Arrays;

class DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        DeleteOperationForTwoStrings deleteOperation = new DeleteOperationForTwoStrings();
        System.out.println(deleteOperation.minDistance("sea", "eat"));
        System.out.println(deleteOperation.minDistance("leetcode", "etco"));

    }
    public int minDistance(String word1, String word2) {
        int[] alphabetSet = new int[26];
        updateAlphabetSet(word1, alphabetSet);
        updateAlphabetSet(word2, alphabetSet);
        return minimumStepsRequired(alphabetSet);
    }

    public void updateAlphabetSet(String word, int[] alphabetSet) {
        for(int i = 0; i < word.length(); i++) {
            alphabetSet[(word.charAt(i) - 97)]++;
        }
    }
    public int minimumStepsRequired(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 2) {
                result+=nums[i];
            } else {
                result+= nums[i] - 2;
            }
        }
        return result;
    }
}