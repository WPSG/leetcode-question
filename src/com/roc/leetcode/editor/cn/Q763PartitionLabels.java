package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。 

 

 示例： 

 
输入：S = "ababcbacadefegdehijhklij"
输出：[9,7,8]
解释：
划分结果为 "ababcbaca", "defegde", "hijhklij"。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 

 

 提示： 

 
 S的长度在[1, 500]之间。 
 S只包含小写字母 'a' 到 'z' 。 
 

 Related Topics 贪心 哈希表 双指针 字符串 👍 802 👎 0

*/
  
public class Q763PartitionLabels{
    public static void main(String[] args) {
        Solution solution = new Q763PartitionLabels().new Solution();
        String s = "ababcbacadefegdehijhklij";
        System.out.println(solution.partitionLabels(s));
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 贪心
         * 同一个字母只能出现在同一个片段，显然同一个字母的第一次出现的下标位置和最后一次出现的下标位置必须出现在同一个片段。
         * 因此需要遍历字符串，得到每个字母最后一次出现的下标位置。
         */
        public List<Integer> partitionLabels(String s) {
            int[] last = new int[26];
            for (int i = 0; i < s.length(); i++) {
                last[s.charAt(i) - 'a'] = i;
            }
            List<Integer> res = new ArrayList<>();
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
//                不断取当前字符所在的最后位置，与当前值作比较，取最大值
                end = Math.max(end, last[s.charAt(i) - 'a']);
                if (i == end) {
                    res.add(end - start + 1);
                    start = end + 1;
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}