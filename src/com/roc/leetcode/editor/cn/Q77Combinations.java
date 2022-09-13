package com.roc.leetcode.editor.cn;

import java.util.*;

/**
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 

 你可以按 任何顺序 返回答案。 

 

 示例 1： 

 
输入：n = 4, k = 2
输出：
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
] 

 示例 2： 

 
输入：n = 1, k = 1
输出：[[1]] 

 

 提示： 

 
 1 <= n <= 20 
 1 <= k <= n 
 

 Related Topics 回溯 👍 1129 👎 0

*/
  
public class Q77Combinations{
    public static void main(String[] args) {
        Solution solution = new Q77Combinations().new Solution();
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        public List<List<Integer>> combine(int n, int k) {
            ArrayDeque<Integer> track = new ArrayDeque<>();
            backTrack(n, k, 1, track);
            return res;
        }

        void backTrack(int n, int k, int index, Deque<Integer> track) {
            if (track.size() == k) {
                res.add(new ArrayList<>(track));
                return;
            }
            for (int i = index; i <= n - (k - track.size()) + 1; i++) {
                track.addLast(i);;
                backTrack(n, k, i + 1, track);
                track.removeLast();
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}