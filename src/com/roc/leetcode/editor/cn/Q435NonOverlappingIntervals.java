package com.roc.leetcode.editor.cn;

import java.util.Arrays;

/**
给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 
。 

 

 示例 1: 

 
输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
输出: 1
解释: 移除 [1,3] 后，剩下的区间没有重叠。
 

 示例 2: 

 
输入: intervals = [ [1,2], [1,2], [1,2] ]
输出: 2
解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 

 示例 3: 

 
输入: intervals = [ [1,2], [2,3] ]
输出: 0
解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 

 

 提示: 

 
 1 <= intervals.length <= 10⁵ 
 intervals[i].length == 2 
 -5 * 10⁴ <= starti < endi <= 5 * 10⁴ 
 

 Related Topics 贪心 数组 动态规划 排序 👍 767 👎 0

*/
  
public class Q435NonOverlappingIntervals{
    public static void main(String[] args) {
        Solution solution = new Q435NonOverlappingIntervals().new Solution();
        int[][] intervals = new int[][] {{1,2}, {2,3},{3,4},{1,3}};
        System.out.println(solution.eraseOverlapIntervals(intervals));
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
         * 在选择要保留区间时，区间的结尾十分重要：选择的区间结尾越小，余留给其它区间的空间就越大，就越能保留更多的区间。
         * 因此，我们采取的贪心策略为，优先保留结尾小且不相交的区间。
         * 具体实现方法为，先把区间按照结尾的大小进行增序排序，每次选择结尾最小且和前一个选择的区间不重叠的区间。
         * */
        public int eraseOverlapIntervals(int[][] intervals) {
            if(intervals.length == 0) {
                return 0;
            }
//            也可以使用lambda表达式
            Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
            /*Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });*/
            int right = intervals[0][1];
            int ans = 1;
            for (int i = 1; i < intervals.length; i++) {
                if(intervals[i][0] >= right) {
                    ans++;
                    right = intervals[i][1];
                }
            }
            return intervals.length - ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}