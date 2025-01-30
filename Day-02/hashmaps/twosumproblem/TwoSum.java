package hashmaps.twosumproblem;
import java.util.HashMap;
public  class TwoSum {
    public static int[] solve(int []nums,int target){
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            numMap.put(nums[i], i);
        }
        return new int[] {};
    }
    public static void main(String[] args) {
        int []arr={122,123,4,5,6,10};
          int []ans=solve(arr,15);
          if(ans.length==0)return;
        for(int i=0;i<2;i++){
           System.out.print(ans[i]+" ");
       }
    }
}