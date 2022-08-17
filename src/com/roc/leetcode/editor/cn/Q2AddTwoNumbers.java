package com.roc.leetcode.editor.cn;

import com.roc.leetcode.ListNode;

/**
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 

 请你将两个数相加，并以相同形式返回一个表示和的链表。 

 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 

 

 示例 1： 
 
 
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
 

 示例 2： 

 
输入：l1 = [0], l2 = [0]
输出：[0]
 

 示例 3： 

 
输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]
 

 

 提示： 

 
 每个链表中的节点数在范围 [1, 100] 内 
 0 <= Node.val <= 9 
 题目数据保证列表表示的数字不含前导零 
 

 Related Topics 递归 链表 数学 👍 8476 👎 0

*/
  
public class Q2AddTwoNumbers{
  public static void main(String[] args) {
    Solution solution = new Q2AddTwoNumbers().new Solution();
    ListNode listNode = new ListNode(0);
    ListNode listNode2 = new ListNode(0);
    System.out.println(solution.addTwoNumbers(listNode, listNode2));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode() {}
   *     ListNode(int val) { this.val = val; }
   *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   * }
   */
  class Solution {
      public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumList , p;
        sumList = new ListNode();
        p = sumList;
        int carry = 0;
        int sumTemp = 0;
        while(l1 != null && l2 != null){
          if ((l1.val + l2.val + carry) >= 10) {
            sumTemp = (l1.val + l2.val + carry) % 10;
            carry = 1;
          } else {
            sumTemp = l1.val + l2.val + carry;
            carry = 0;
          }
          p.val = sumTemp;
          if(l1.next != null || l2.next != null){
            p.next = new ListNode();
            p = p.next;
          }
          l1 = l1.next;
          l2 = l2.next;
        }
        if(l1 != null)
          l2 = l1;
        while(l2 != null) {
          if ((l2.val + carry) >= 10) {
            sumTemp = (l2.val + carry) % 10;
            carry = 1;
          } else {
            sumTemp = l2.val + carry;
            carry = 0;
          }
          p.val = sumTemp;
          if(l2.next != null){
            p.next = new ListNode();
            p = p.next;
          }
          l2 = l2.next;
        }
        if(carry == 1){
          p.next = new ListNode(carry);
        }
        return sumList;
      }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}