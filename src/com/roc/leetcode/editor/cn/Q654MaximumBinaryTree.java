package com.roc.leetcode.editor.cn;

import com.roc.leetcode.TreeNode;

/**
给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建: 

 
 创建一个根节点，其值为 nums 中的最大值。 
 递归地在最大值 左边 的 子数组前缀上 构建左子树。 
 递归地在最大值 右边 的 子数组后缀上 构建右子树。 
 

 返回 nums 构建的 最大二叉树 。 

 

 示例 1： 
 
 
输入：nums = [3,2,1,6,0,5]
输出：[6,3,5,null,2,0,null,null,1]
解释：递归调用如下所示：
- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
        - 空数组，无子节点。
        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
            - 空数组，无子节点。
            - 只有一个元素，所以子节点是一个值为 1 的节点。
    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
        - 只有一个元素，所以子节点是一个值为 0 的节点。
        - 空数组，无子节点。
 

 示例 2： 
 
 
输入：nums = [3,2,1]
输出：[3,null,2,null,1]
 

 

 提示： 

 
 1 <= nums.length <= 1000 
 0 <= nums[i] <= 1000 
 nums 中的所有整数 互不相同 
 

 Related Topics 栈 树 数组 分治 二叉树 单调栈 👍 518 👎 0

*/
  
public class Q654MaximumBinaryTree{
    public static void main(String[] args) {
        Solution solution = new Q654MaximumBinaryTree().new Solution();
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 用递归函数 construct(nums, start end) 表示对数组 nums 中从 nums[start] 到 nums[end] 的元素构建一棵树。
     * 先找到 start - end 区间里最大的值，作为根节点，再进行递归操作
     * 左子树为 construct(nums,start,maxIndex−1)；
     * 右子树为 construct(nums,maxIndex+1,end)。
    */
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return construct(nums, 0, nums.length - 1);
        }

        public TreeNode construct(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }
            int maxIndex = getMaxIndex(nums, start, end);
            TreeNode node = new TreeNode(nums[maxIndex]);
            node.left = construct(nums, start, maxIndex - 1);
            node.right = construct(nums, maxIndex + 1, end);
            return node;
        }

        public int getMaxIndex(int[] nums, int start, int end) {
            int index = start;
            for (int i = start + 1; i <= end; i++) {
                if (nums[i] > nums[index]) {
                    index = i;
                }
            }
            return index;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}