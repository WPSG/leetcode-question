package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 

 n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 

 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 

 
 
 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
 
 

 

 示例 1： 
 
 
输入：n = 4
输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
解释：如上图所示，4 皇后问题存在两个不同的解法。
 

 示例 2： 

 
输入：n = 1
输出：[["Q"]]
 

 

 提示： 

 
 1 <= n <= 9 
 

 Related Topics 数组 回溯 👍 1505 👎 0

*/
  
public class Q51NQueens{
    public static void main(String[] args) {
        Solution solution = new Q51NQueens().new Solution();
        int n = 4;
        solution.solveNQueens(n).forEach(item -> {
            item.forEach(System.out::println);
            System.out.println();
        });
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<String>> res = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            for (char[] item : board) {
                Arrays.fill(item, '.');
            }
            backTrack(board, 0);
            return res;
        }

        void backTrack(char[][] board, int rowIndex) {
            if (rowIndex == board.length) {
                res.add(Arrays.stream(board).map(String::copyValueOf).collect(Collectors.toList()));
                return;
            }
            for (int columnIndex = 0; columnIndex < board[rowIndex].length; columnIndex++) {
                if (!isValid(board, rowIndex, columnIndex)) {
                    continue;
                }
                board[rowIndex][columnIndex] = 'Q';
                backTrack(board, rowIndex + 1);
                board[rowIndex][columnIndex] = '.';
            }
        }

        /* 是否可以在 board[row][col] 放置皇后？ */
        boolean isValid(char[][] board, int rowIndex, int columnIndex) {
            int n = board.length;
            // 检查列是否有皇后互相冲突
            for (int i = 0; i <= rowIndex; i++) {
                if (board[i][columnIndex] == 'Q') {
                    return false;
                }
            }
            // 检查右上方是否有皇后互相冲突
            for (int i = rowIndex - 1, j = columnIndex + 1; i >= 0 && j < n; i--, j++) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            // 检查左上方是否有皇后互相冲突
            for (int i = rowIndex - 1, j = columnIndex - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}