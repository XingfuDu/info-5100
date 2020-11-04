/**
 * The deadline of this assignment is 09/25/2020 23:59 PST.
 * Please feel free to contact Yafei and Yaqi for any questions.
 */

public class ArrayMaxSum {
    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     * which has the largest sum and outprint its sum.
     *
     * Example 1:
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     *
     * Example 2:
     * Input: nums = [1]
     * Output: 1
     */
    public int maxSubArray(int[] nums) {
        //write your code here
	int maxSoFar = nums[0], endSoFar = nums[0];
	for (int i = 1; i < nums.length; i++) {
	    endSoFar = Math.max(nums[i], endSoFar + nums[i]);
	    maxSoFar = Math.max(maxSoFar, endSoFar);
	}
	return maxSoFar;
    }

    public static void main(String[] args) {
        //write your code here
	int[] array1 = new int[]{-2,1,-3,4,-1,2,1,-5,4};
	ArrayMaxSum ams = new ArrayMaxSum();
	int result1 = ams.maxSubArray(array1);
	System.out.println(result1);
	int[] array2 = new int[]{1};
       	int result2 = ams.maxSubArray(array2);
	System.out.println(result2);
    }
}