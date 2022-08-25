package com.roc.leetcode.editor.cn;

import java.util.List;

/**
给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。 

 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。 

 

 示例 1： 

 
输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
输出："apple"
 

 示例 2： 

 
输入：s = "abpcplea", dictionary = ["a","b","c"]
输出："a"
 

 

 提示： 

 
 1 <= s.length <= 1000 
 1 <= dictionary.length <= 1000 
 1 <= dictionary[i].length <= 1000 
 s 和 dictionary[i] 仅由小写英文字母组成 
 

 Related Topics 数组 双指针 字符串 排序 👍 312 👎 0

*/
  
public class Q524LongestWordInDictionaryThroughDeleting{
    public static void main(String[] args) {
        Solution solution = new Q524LongestWordInDictionaryThroughDeleting().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 找到长度最长且字典序最小的字符串。
        public String findLongestWord(String s, List<String> dictionary) {
            String result = "";
            for (String item : dictionary) {
                int sIndex = 0, dicIndex = 0;
                while (sIndex < s.length() && dicIndex < item.length()) {
                    if (s.charAt(sIndex) == item.charAt(dicIndex)) {
                        dicIndex++;
                    }
                    sIndex++;
                }
                if (dicIndex == item.length()){
                    if (item.length() > result.length() ||
                            (item.length() == result.length() && item.compareTo(result) < 0)) {
                        result = item;
                    }
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}