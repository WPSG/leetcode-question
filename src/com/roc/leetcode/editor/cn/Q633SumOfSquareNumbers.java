package com.roc.leetcode.editor.cn;

/**
给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a² + b² = c 。 

 

 示例 1： 

 
输入：c = 5
输出：true
解释：1 * 1 + 2 * 2 = 5
 

 示例 2： 

 
输入：c = 3
输出：false
 

 

 提示： 

 
 0 <= c <= 2³¹ - 1 
 

 Related Topics 数学 双指针 二分查找 👍 382 👎 0

*/
  
public class Q633SumOfSquareNumbers{
    public static void main(String[] args) {
        Solution solution = new Q633SumOfSquareNumbers().new Solution();
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum(int c) {
            int left = 0, right = (int)Math.sqrt(c);
            while (left <= right) {
                // 注意使用 long, 不能使用 int
                long sum = (long) left * left + (long) right * right;
                if (sum == c) {
                    return true;
                } else if (sum > c) {
                    right--;
                } else {
                    left++;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}