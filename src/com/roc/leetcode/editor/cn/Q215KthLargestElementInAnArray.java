package com.roc.leetcode.editor.cn;

import java.util.Arrays;

/**
给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 

 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 

 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 

 

 示例 1: 

 
输入: [3,2,1,5,6,4], k = 2
输出: 5
 

 示例 2: 

 
输入: [3,2,3,1,2,4,5,5,6], k = 4
输出: 4 

 

 提示： 

 
 1 <= k <= nums.length <= 10⁵ 
 -10⁴ <= nums[i] <= 10⁴ 
 

 Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1853 👎 0

*/
  
public class Q215KthLargestElementInAnArray{
    public static void main(String[] args) {
        Solution solution = new Q215KthLargestElementInAnArray().new Solution();
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int left = 0, right = nums.length - 1;
            quickSort(nums, left, right);
            System.out.println(Arrays.toString(nums));
            return nums[nums.length - k];
        }

        void quickSort(int[] nums, int left, int right) {
            if (left + 1 > right) {
                return;
            }
            int leftIndex = left, rightIndex = right, key = nums[left];
            while (leftIndex < rightIndex) {
                while (leftIndex < rightIndex && nums[rightIndex] >= key) {
                    rightIndex--;
                }
                nums[leftIndex] = nums[rightIndex];
                while (leftIndex < rightIndex && nums[leftIndex] <= key) {
                    leftIndex++;
                }
                nums[rightIndex] = nums[leftIndex];
            }
            nums[leftIndex] = key;
            quickSort(nums, left, leftIndex);
            quickSort(nums, leftIndex + 1, right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}