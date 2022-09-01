package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。 

 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。 

 

 示例 1: 

 
输入: s = "tree"
输出: "eert"
解释: 'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 

 示例 2: 

 
输入: s = "cccaaa"
输出: "cccaaa"
解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 

 示例 3: 

 
输入: s = "Aabb"
输出: "bbAa"
解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
注意'A'和'a'被认为是两种不同的字符。
 

 

 提示: 

 
 1 <= s.length <= 5 * 10⁵ 
 s 由大小写英文字母和数字组成 
 

 Related Topics 哈希表 字符串 桶排序 计数 排序 堆（优先队列） 👍 423 👎 0

*/
  
public class Q451SortCharactersByFrequency{
    public static void main(String[] args) {
        Solution solution = new Q451SortCharactersByFrequency().new Solution();
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String frequencySort(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
            entries.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
            StringBuilder builder = new StringBuilder();
            for (Map.Entry<Character, Integer> item :
                    entries) {
                for (int i = 0; i < item.getValue(); i++) {
                    builder.append(item.getKey());
                }
            }
            return builder.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}