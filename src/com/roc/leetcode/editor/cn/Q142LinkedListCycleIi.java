package com.roc.leetcode.editor.cn;

import com.roc.leetcode.ListNode;

/**
给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 

 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表
中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 

 不允许修改 链表。 

 
 

 

 示例 1： 

 

 
输入：head = [3,2,0,-4], pos = 1
输出：返回索引为 1 的链表节点
解释：链表中有一个环，其尾部连接到第二个节点。
 

 示例 2： 

 

 
输入：head = [1,2], pos = 0
输出：返回索引为 0 的链表节点
解释：链表中有一个环，其尾部连接到第一个节点。
 

 示例 3： 

 

 
输入：head = [1], pos = -1
输出：返回 null
解释：链表中没有环。
 

 

 提示： 

 
 链表中节点的数目范围在范围 [0, 10⁴] 内 
 -10⁵ <= Node.val <= 10⁵ 
 pos 的值为 -1 或者链表中的一个有效索引 
 

 

 进阶：你是否可以使用 O(1) 空间解决此题？ 

 Related Topics 哈希表 链表 双指针 👍 1728 👎 0

*/
  
public class Q142LinkedListCycleIi{
    public static void main(String[] args) {
        Solution solution = new Q142LinkedListCycleIi().new Solution();
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 给定两个指针，分别命名为 slow 和 fast，起始位置在链表的开头。
     * 每次 fast 前进两步，slow 前进一步。如果 fast 可以走到尽头，那么说明没有环路；
     * 如果 fast 可以无限走下去，那么说明一定有环路，且一定存在一个时刻 slow 和 fast 相遇。
     * 当 slow 和 fast 第一次相遇时，我们将 fast 重新移动到链表开头，并让 slow 和 fast 每次都前进一步。
     * 当 slow 和 fast 第二次相遇时，相遇的节点即为环路的开始点。
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head, fast = head;
            do {
                if (fast == null || fast.next == null) {
                    return null;
                }
                fast = fast.next.next;
                slow = slow.next;
            } while (fast != slow);
            fast = head;
            while (fast != slow) {
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}