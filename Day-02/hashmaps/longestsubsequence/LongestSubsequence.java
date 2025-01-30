package hashmaps.longestsubsequence;
import java.util.HashSet;
public class LongestSubsequence {
    // Function to find the length of the longest consecutive sequence
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Store all the numbers in a hash set for O(1) look-up
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestStreak = 0;

        // Iterate through each number
        for (int num : numSet) {
            // Check if it's the start of a new sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count the length of the consecutive sequence starting from num
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println("Length of Longest Consecutive Sequence: " + longestConsecutive(nums));
    }

}