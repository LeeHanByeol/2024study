import java.util.*;

class Solution {
    public String solution(String s) {
        
        String[] nums_s = s.split(" ");
        
        int[] nums = new int[nums_s.length];
        for(int i = 0; i < nums_s.length; i++){
            nums[i] = Integer.parseInt(nums_s[i]);
        }
        Arrays.sort(nums);

        return nums[0] + " " + nums[nums.length-1];
    }
}