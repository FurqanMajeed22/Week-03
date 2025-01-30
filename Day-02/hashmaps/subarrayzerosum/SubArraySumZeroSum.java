package hashmaps.subarrayzerosum;
import java.util.*;
public class SubArraySumZeroSum {
    public static List<List<Integer>> subArrayExists(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int sum = 0;
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        sumMap.put(0, new ArrayList<>(Arrays.asList(-1)));
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sumMap.containsKey(sum)) {
                List<Integer> indices = sumMap.get(sum);
                for (int index : indices) {
                    List<Integer> subarray = new ArrayList<>();
                    for (int j = index + 1; j <= i; j++) {
                        subarray.add(arr[j]);
                    }
                    result.add(subarray);
                }
            }
            // Store the current sum and the index where it occurred
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {6, -1, -3, 4, -2, 2, 4, 6, -12, -7};

        // Find all subarrays with sum 0
        List<List<Integer>> subarrays = subArrayExists(arr);

        // Print the subarrays
        if (subarrays.isEmpty()) {
            System.out.println("No subarray with sum 0");
        } else {
            System.out.println("Subarrays with sum 0:");
            for (List<Integer> subarray : subarrays) {
                System.out.println(subarray);
            }
        }
    }
}
