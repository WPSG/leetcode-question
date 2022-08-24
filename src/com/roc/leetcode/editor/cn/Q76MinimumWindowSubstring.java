package com.roc.leetcode.editor.cn;

import java.util.HashMap;

/**
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 

 

 注意： 

 
 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
 

 

 示例 1： 

 
输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
 

 示例 2： 

 
输入：s = "a", t = "a"
输出："a"
 

 示例 3: 

 
输入: s = "a", t = "aa"
输出: ""
解释: t 中两个字符 'a' 均应包含在 s 的子串中，
因此没有符合条件的子字符串，返回空字符串。 

 

 提示： 

 
 1 <= s.length, t.length <= 10⁵ 
 s 和 t 由英文字母组成 
 

 
进阶：你能设计一个在 
o(n) 时间内解决此问题的算法吗？

 Related Topics 哈希表 字符串 滑动窗口 👍 2083 👎 0

*/
  
public class Q76MinimumWindowSubstring{
    public static void main(String[] args) {
        Solution solution = new Q76MinimumWindowSubstring().new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(solution.minWindow(s, t));

    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 参考：https://leetcode.cn/problems/minimum-window-substring/solution/leetcode-76-zui-xiao-fu-gai-zi-chuan-cja-lmqz/
        public String minWindow(String s, String t) {
            // 两个哈希表，sFreq哈希表维护的是s字符串中滑动窗口中各个字符出现多少次，tFreq哈希表维护的是t字符串各个字符出现多少次。
            HashMap<Character, Integer> tFreq = new HashMap<>(128);
            HashMap<Character, Integer> sFreq = new HashMap<>(128);
            for (int i = 0; i < t.length(); i++) {
                tFreq.put(t.charAt(i), tFreq.getOrDefault(t.charAt(i),0) + 1);
            }
            // cnt 表示当时有多少个元素符合
            int cnt = 0, len = 0x3f3f3f3f;
            String result = "";
            // 两个指针，left 和 right ， left 用于收缩窗口，right 用于延长窗口，枚举过程中，不断增加i使滑动窗口增大，相当于向右扩展滑动窗口。
            for (int left = 0, right = 0; right < s.length(); right++) {
                sFreq.put(s.charAt(right), sFreq.getOrDefault(s.charAt(right),0) + 1);
                // 对于新加入的字符s[right],如果sFreq[s[right]] <= tFreq[s[right]]，说明当前新加入的字符s[right]是必需的，且还未到达字符串t所要求的数量。
                // 我们还需要事先定义一个cnt变量，cnt维护的是s字符串[right,left]区间中满足t字符串的元素的个数，记录相对应字符的总数。新加入的字符s[right]必需，则cnt++
                if (tFreq.containsKey(s.charAt(right)) && sFreq.get(s.charAt(right)) <= tFreq.get(s.charAt(right))) {
                    cnt++;
                }
                // 收缩滑动窗口。因此当sFreq[s[left]] > tFreq[s[left]时，说明sFreq哈希表中s[left]的数量多于tFreq哈希表中s[left]的数量，
                // 此时我们就需要向右收缩滑动窗口，left++并使sFreq[s[left]]--，即sFreq[s[left ++ ]] --。
                while (left < right &&
                        (!tFreq.containsKey(s.charAt(left)) || sFreq.get(s.charAt(left)) > tFreq.get(s.charAt(left)))) {
                    int count = sFreq.get(s.charAt(left)) - 1;
                    sFreq.put(s.charAt(left), count);
                    left++;
                }
                // 当cnt == t.size时，说明此时滑动窗口包含符串 t 的全部字符。我们重复上述过程找到最小窗口即为答案。
                if (cnt == t.length() && right - left + 1 < len) {
                    len = right - left + 1;
                    result = s.substring(left, right + 1);
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}