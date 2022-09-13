package com.roc.leetcode.editor.cn;

/**
给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 

 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 

 

 示例 1： 
 
 
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
"ABCCED"
输出：true
 

 示例 2： 
 
 
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
"SEE"
输出：true
 

 示例 3： 
 
 
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
"ABCB"
输出：false
 

 

 提示： 

 
 m == board.length 
 n = board[i].length 
 1 <= m, n <= 6 
 1 <= word.length <= 15 
 board 和 word 仅由大小写英文字母组成 
 

 

 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 

 Related Topics 数组 回溯 矩阵 👍 1435 👎 0

*/
  
public class Q79WordSearch{
    public static void main(String[] args) {
        Solution solution = new Q79WordSearch().new Solution();
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean isFounded = false;
        public boolean exist(char[][] board, String word) {
            if (board.length == 0) {
                return false;
            }
            boolean[][] used = new boolean[board.length][board[0].length];
            for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
                for (int columnIndex = 0; columnIndex < board[0].length; columnIndex++) {
                    backTrack(rowIndex, columnIndex, board, used, word, 0);
                }
            }
            return isFounded;
        }

        void backTrack(int rowIndex, int columnIndex, char[][] board, boolean[][] used,
                       String word, int curIndex) {
            if (rowIndex < 0 || rowIndex >= board.length || columnIndex < 0 || columnIndex >= board[0].length) {
                return;
            }
            if (used[rowIndex][columnIndex] || isFounded || board[rowIndex][columnIndex] != word.charAt(curIndex)) {
                return;
            }
            if (curIndex == word.length() - 1) {
                isFounded = true;
                return;
            }
            used[rowIndex][columnIndex] = true;
            backTrack(rowIndex + 1, columnIndex, board,  used, word, curIndex + 1);
            backTrack(rowIndex - 1, columnIndex, board, used, word, curIndex + 1);
            backTrack(rowIndex, columnIndex + 1, board, used, word, curIndex + 1);
            backTrack(rowIndex, columnIndex - 1, board, used, word, curIndex + 1);
            used[rowIndex][columnIndex] = false;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}