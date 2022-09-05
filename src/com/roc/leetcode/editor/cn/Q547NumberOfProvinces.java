package com.roc.leetcode.editor.cn;

/**

 
 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。 

 
 

 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 

 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
isConnected[i][j] = 0 表示二者不直接相连。 

 返回矩阵中 省份 的数量。 

 

 示例 1： 
 
 
输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
输出：2
 

 示例 2： 
 
 
输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
输出：3
 

 

 提示： 

 
 1 <= n <= 200 
 n == isConnected.length 
 n == isConnected[i].length 
 isConnected[i][j] 为 1 或 0 
 isConnected[i][i] == 1 
 isConnected[i][j] == isConnected[j][i] 
 

 Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 867 👎 0

*/
  
public class Q547NumberOfProvinces{
    public static void main(String[] args) {
        Solution solution = new Q547NumberOfProvinces().new Solution();
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /*
         * 深度优先搜索
         * 遍历所有城市，对于每个城市，如果该城市尚未被访问过，则从该城市开始深度优先搜索，通过矩阵 isConnected 得到与该城市直接相连的城市有哪些，
         * 这些城市和该城市属于同一个连通分量，然后对这些城市继续深度优先搜索，直到同一个连通分量的所有城市都被访问到，即可得到一个省份。
         * 遍历完全部城市以后，即可得到连通分量的总数，即省份的总数。
         * */
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length, res = 0;
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(isConnected, i, visited);
                    res++;
                }
            }
            return res;
        }

        void dfs(int[][] isConnected, int index, boolean[] visited) {
            visited[index] = true;
            for (int i = 0; i < isConnected[index].length; i++) {
                if (isConnected[index][i] == 1 && !visited[i]) {
                    dfs(isConnected, i, visited);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}