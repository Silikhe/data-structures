import java.util.*;

public class AddTwoNumber {

//    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//    You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//    You can return the answer in any order.
//
//
//
//            Example 1:
//
//    Input: nums = [2,7,11,15], target = 9 o(n)
//    Output: [0,1]
//    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//    Example 2:
//
//    Input: nums = [3,2,4], target = 6
//    Output: [1,2]

    public static void main(String[] args) {
//        System.out.println();
//        for (int i = 0; i < num.length; i++){
//        num[i]
    }

//    Brute Force Approach
//    Complexity O(n2) o(1
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        // In case there is no solution, we'll just return null
        return null;
    }



//    Approach 2: Two-pass Hash Table

    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target - nums[i])){
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                break;
            }
            map.put(nums[i],i);
        }

        return result;
    }
}
