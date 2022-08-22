package com.roc.leetcode.editor.cn;

/**
给你一个长度为 n 的整数数组
 nums ，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。 

 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。 

 

 示例 1: 

 
输入: nums = [4,2,3]
输出: true
解释: 你可以通过把第一个 4 变成 1 来使得它成为一个非递减数列。
 

 示例 2: 

 
输入: nums = [4,2,1]
输出: false
解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 

 

 提示： 
 

 
 n == nums.length 
 1 <= n <= 10⁴ 
 -10⁵ <= nums[i] <= 10⁵ 
 

 Related Topics 数组 👍 686 👎 0

*/
  
public class Q665NonDecreasingArray{
    public static void main(String[] args) {
        Solution solution = new Q665NonDecreasingArray().new Solution();
        int[] nums = {4,2,3};
        System.out.println(solution.checkPossibility(nums));
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
            /**
             * 贪心算法
             * 本题是要维持一个非递减的数列，所以遇到递减的情况时（nums[i] > nums[i + 1]），要么将前面的元素缩小，要么将后面的元素放大。
             * 但是本题唯一的易错点就在这，
             * 如果将nums[i]缩小，可能会导致其无法融入前面已经遍历过的非递减子数列；
             * 如果将nums[i + 1]放大，可能会导致其后续的继续出现递减；
             * 所以要采取贪心的策略，在遍历时，每次需要看连续的三个元素，也就是瞻前顾后，遵循以下两个原则：
             * - 需要尽可能不放大nums[i + 1]，这样会让后续非递减更困难；
             * - 如果缩小nums[i]，但不破坏前面的子序列的非递减性；
             * 算法步骤：
             * 遍历数组，如果遇到递减：
             * 还能修改：
             * 修改方案1：将nums[i]缩小至nums[i + 1]；
             * 修改方案2：将nums[i + 1]放大至nums[i]；
             * 不能修改了：直接返回false；
             */
            public boolean checkPossibility(int[] nums) {
            if (nums.length == 1) {
                return true;
            }
            // 是否有更改的机会
            boolean flag = nums[0] <= nums[1];
            for (int i = 1; i < nums.length - 1; i++) {
                // 出现递减的情况
                if (nums[i] > nums[i + 1]) {
                    if (flag) {
                        // 如果后一个大于前一个，将nums[i]缩小至nums[i + 1]；
                        if (nums[i + 1] >= nums[i - 1]) {
                            nums[i] = nums[i + 1];
                        }
                        // 如果后一个不大于前一个，将nums[i + 1]放大至nums[i]；
                        else {
                            nums[i + 1] = nums[i];
                        }
                        // 失去唯一的改变机会
                        flag = false;
                    }
                    else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}