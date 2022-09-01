package com.roc.leetcode.editor.cn;

/**
给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。 

 请你找出并返回只出现一次的那个数。 

 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。 

 

 示例 1: 

 
输入: nums = [1,1,2,3,3,4,4,8,8]
输出: 2
 

 示例 2: 

 
输入: nums =  [3,3,7,7,10,11,11]
输出: 10
 

 

 
 

 提示: 

 
 1 <= nums.length <= 10⁵ 
 0 <= nums[i] <= 10⁵ 
 

 Related Topics 数组 二分查找 👍 542 👎 0

*/
  
public class Q540SingleElementInASortedArray{
    public static void main(String[] args) {
        Solution solution = new Q540SingleElementInASortedArray().new Solution();
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
         * 二分的核心是确定左右指针变化时的条件，由于有序数组中相等元素一定相邻,所以在单一元素左侧，相邻的奇偶元素应该相等，
         * 即索引为 i 的元素应该满足:
         * i 是偶数：nums[i] == nums[i + 1]，则 0 - i+1 都是相等元素
         * i 是奇数：nums[i] == nums[i - 1]，则 0 - i 都是相等元素
         * 根据这一性质作为二分的判断条件，对奇偶索引位置分类讨论，不断缩小区间找到最终结果
         * */
        public int singleNonDuplicate(int[] nums) {
            int leftIndex = 0, rightIndex = nums.length - 1, mid;
            while (leftIndex < rightIndex) {
                mid = (rightIndex - leftIndex) / 2 + leftIndex;
                if (mid % 2 == 0) {
                    if (nums[mid] == nums[mid + 1]) {
                        leftIndex = mid + 1;
                    } else {
                        rightIndex = mid;
                    }
                } else {
                    if (nums[mid] == nums[mid - 1]) {
                        leftIndex = mid + 1;
                    } else {
                        rightIndex = mid;
                    }
                }
            }
            return nums[leftIndex];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}