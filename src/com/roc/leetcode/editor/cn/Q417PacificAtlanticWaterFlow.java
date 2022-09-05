package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。 

 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上单元
格 高于海平面的高度 。 

 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。 

 返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可流向
大西洋 。 

 

 示例 1： 

 

 
输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 

 示例 2： 

 
输入: heights = [[2,1],[1,2]]
输出: [[0,0],[0,1],[1,0],[1,1]]
 

 

 提示： 

 
 m == heights.length 
 n == heights[r].length 
 1 <= m, n <= 200 
 0 <= heights[r][c] <= 10⁵ 
 

 Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 518 👎 0

*/
  
public class Q417PacificAtlanticWaterFlow{
    public static void main(String[] args) {
        Solution solution = new Q417PacificAtlanticWaterFlow().new Solution();
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
         * 虽然题目要求的是满足向下流能到达两个大洋的位置，如果我们对所有的位置进行搜索，那么在不剪枝的情况下复杂度会很高。
         * 因此我们可以反过来想，从两个大洋开始向上流，这样我们只需要对矩形四条边进行搜索。
         * 搜索完成后，只需遍历一遍矩阵，满足条件的位置即为两个大洋向上流都能到达的位置。
         * */
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] heights;
        int m, n;

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            this.heights = heights;
            this.m = heights.length;
            this.n = heights[0].length;
            boolean[][] pacific = new boolean[m][n];
            boolean[][] atlantic = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                dfs(i, 0, pacific);
            }
            for (int j = 1; j < n; j++) {
                dfs(0, j, pacific);
            }
            for (int i = 0; i < m; i++) {
                dfs(i, n - 1, atlantic);
            }
            for (int j = 0; j < n - 1; j++) {
                dfs(m - 1, j, atlantic);
            }
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (pacific[i][j] && atlantic[i][j]) {
                        List<Integer> cell = new ArrayList<>();
                        cell.add(i);
                        cell.add(j);
                        result.add(cell);
                    }
                }
            }
            return result;
        }

        void dfs(int row, int col, boolean[][] ocean) {
            if (ocean[row][col]) {
                return;
            }
            ocean[row][col] = true;
            for (int[] dir : dirs) {
                int newRow = row + dir[0], newCol = col + dir[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                        heights[newRow][newCol] >= heights[row][col]) {
                    dfs(newRow, newCol, ocean);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}