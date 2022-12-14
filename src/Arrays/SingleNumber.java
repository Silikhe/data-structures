package Arrays;

public class SingleNumber {

//    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//
//    You must implement a solution with a linear runtime complexity and use only constant extra space.
//
//
//
//    Example 1:
//
//    Input: nums = [2,2,1]
//    Output: 1
//    Example 2:
//
//    Input: nums = [4,1,2,1,2]
//    Output: 4
//    Example 3:
//
//    Input: nums = [1]
//    Output: 1
//
//
//    Constraints:
//
//            1 <= nums.length <= 3 * 104
//            -3 * 104 <= nums[i] <= 3 * 104
//    Each element in the array appears twice except for one element which appears only once.
    public int singleNumber(int[] nums) {

        // do XOR operation on all element using bit wise operator concept

        // for dry run take table of 1 to 9 base10 to binary
        // XOR all element u will get unique element

        int ans =0;
        for (int i =0; i<nums.length; i++){
            ans ^=nums[i];
        }
        return ans;
    }
}
