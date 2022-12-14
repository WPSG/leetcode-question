package com.roc.leetcode.editor.cn;

/**
给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。 

 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。 

 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元
素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。 

 

 示例 1： 

 
输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
解释：需要合并 [1,2,3] 和 [2,5,6] 。
合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 

 示例 2： 

 
输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]
解释：需要合并 [1] 和 [] 。
合并结果是 [1] 。
 

 示例 3： 

 
输入：nums1 = [0], m = 0, nums2 = [1], n = 1
输出：[1]
解释：需要合并的数组是 [] 和 [1] 。
合并结果是 [1] 。
注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 

 

 提示： 

 
 nums1.length == m + n 
 nums2.length == n 
 0 <= m, n <= 200 
 1 <= m + n <= 200 
 -10⁹ <= nums1[i], nums2[j] <= 10⁹ 
 

 

 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？ 

 Related Topics 数组 双指针 排序 👍 1539 👎 0

*/
  
public class Q88MergeSortedArray{
    public static void main(String[] args) {
        Solution solution = new Q88MergeSortedArray().new Solution();
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 因为这两个数组已经排好序，我们可以把两个指针分别放在两个数组的末尾，即 nums1 的 m − 1 位和 nums2 的 n − 1 位。
         * 每次将较大的那个数字复制到 nums1 的后边，然后向前移动一位。因为我们也要定位 nums1 的末尾，所以我们还需要第三个指针，以便复制。
         * 在以下的代码里，我们直接利用 m 和 n 当作两个数组的指针，再额外创立一个 pos 指针，起始位置为 m + n − 1。
         * 每次向前移动 m 或 n 的时候，也要向前移动 pos。这里需要注意:
         * 如果 nums1的数字已经复制完，不要忘记把 nums2 的数字继续复制；
         * 如果 nums2 的数字已经复制完，剩余nums1 的数字不需要改变，因为它们已经被排好序。
         * */
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int pos = nums1.length - 1, nums1Pos = m - 1, nums2Pos = n - 1;
            while (nums1Pos >= 0 && nums2Pos >= 0) {
                nums1[pos--] = nums1[nums1Pos] > nums2[nums2Pos] ? nums1[nums1Pos--] : nums2[nums2Pos--];
            }
            while (nums2Pos >= 0) {
                nums1[pos--] = nums2[nums2Pos--];
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}