package hashmaps.targetsum;
import java.util.HashSet;

public class TargetSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> seenNumbers = new HashSet<>();
        for (int num : arr) {
            int complement = target - num;
            // Check if the complement of the current number is in the set
            if (seenNumbers.contains(complement)) {
                return true; // Pair found
            }
            // Add the current number to the set
            seenNumbers.add(num);
        }
        return false; // No pair found
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 7, 1, 5, 2};
        int target = 10;
        if (hasPairWithSum(arr, target)) {
            System.out.println("A pair with the given sum exists.");
        } else {
            System.out.println("No pair with the given sum exists.");
        }
    }
}
