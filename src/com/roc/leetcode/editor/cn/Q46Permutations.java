package com.roc.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 

 

 示例 1： 

 
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

 示例 2： 

 
输入：nums = [0,1]
输出：[[0,1],[1,0]]
 

 示例 3： 

 
输入：nums = [1]
输出：[[1]]
 

 

 提示： 

 
 1 <= nums.length <= 6 
 -10 <= nums[i] <= 10 
 nums 中的所有整数 互不相同 
 

 Related Topics 数组 回溯 👍 2216 👎 0

*/
  
public class Q46Permutations{
    public static void main(String[] args) {
        Solution solution = new Q46Permutations().new Solution();
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        public List<List<Integer>> permute(int[] nums) {
            LinkedList<Integer> track = new LinkedList<>();
            boolean[] used = new boolean[nums.length];
            backTrack(nums, track, used);
            return res;
        }

        void backTrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
            if (track.size() == nums.length) {
                res.add(new LinkedList<>(track));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                track.add(nums[i]);
                used[i] = true;
                backTrack(nums, track, used);
                track.removeLast();
                used[i] = false;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}