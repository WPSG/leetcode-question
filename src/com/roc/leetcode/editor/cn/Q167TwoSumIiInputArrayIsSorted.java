package com.roc.leetcode.editor.cn;

/**
给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个
数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.
length 。 

 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。 

 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。 

 你所设计的解决方案必须只使用常量级的额外空间。 

 示例 1： 

 
输入：numbers = [2,7,11,15], target = 9
输出：[1,2]
解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。 

 示例 2： 

 
输入：numbers = [2,3,4], target = 6
输出：[1,3]
解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。 

 示例 3： 

 
输入：numbers = [-1,0], target = -1
输出：[1,2]
解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 

 

 提示： 

 
 2 <= numbers.length <= 3 * 10⁴ 
 -1000 <= numbers[i] <= 1000 
 numbers 按 非递减顺序 排列 
 -1000 <= target <= 1000 
 仅存在一个有效答案 
 

 Related Topics 数组 双指针 二分查找 👍 874 👎 0

*/
  
public class Q167TwoSumIiInputArrayIsSorted{
    public static void main(String[] args) {
        Solution solution = new Q167TwoSumIiInputArrayIsSorted().new Solution();
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 因为数组已经排好序，我们可以采用方向相反的双指针来寻找这两个数字，一个初始指向最小的元素，即数组最左边，向右遍历；一个初始指向最大的元素，即数组最右边，向左遍历。
         * 如果两个指针指向元素的和等于给定值，那么它们就是我们要的结果。如果两个指针指向元素的和小于给定值，我们把左边的指针右移一位，使得当前的和增加一点。
         * 如果两个指针指向元素的和大于给定值，我们把右边的指针左移一位，使得当前的和减少一点。
         * */
        public int[] twoSum(int[] numbers, int target) {
            int minIndex = 0, maxIndex = numbers.length - 1;
            while (minIndex <= maxIndex) {
                if (numbers[minIndex] + numbers[maxIndex] > target) {
                    maxIndex--;
                } else if (numbers[minIndex] + numbers[maxIndex] < target) {
                    minIndex++;
                } else {
                    break;
                }
            }
            return new int[]{minIndex + 1, maxIndex + 1};
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}