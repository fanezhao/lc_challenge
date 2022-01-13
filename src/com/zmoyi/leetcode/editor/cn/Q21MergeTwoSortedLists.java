/**
 * <p>将两个升序链表合并为一个新的 <strong>升序</strong> 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 </p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg" style="width: 662px; height: 302px;" />
 * <pre>
 * <strong>输入：</strong>l1 = [1,2,4], l2 = [1,3,4]
 * <strong>输出：</strong>[1,1,2,3,4,4]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>l1 = [], l2 = []
 * <strong>输出：</strong>[]
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>l1 = [], l2 = [0]
 * <strong>输出：</strong>[0]
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>两个链表的节点数目范围是 <code>[0, 50]</code></li>
 * <li><code>-100 <= Node.val <= 100</code></li>
 * <li><code>l1</code> 和 <code>l2</code> 均按 <strong>非递减顺序</strong> 排列</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>递归</li><li>链表</li></div></div><br><div><li>👍 2138</li><li>👎 0</li></div>
 */

package com.zmoyi.leetcode.editor.cn;

public class Q21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new Q21MergeTwoSortedLists().new Solution();

        ListNode n1 = new Q21MergeTwoSortedLists().new ListNode(1);
        ListNode n2 = new Q21MergeTwoSortedLists().new ListNode(2);
        ListNode n3 = new Q21MergeTwoSortedLists().new ListNode(4);
        n1.next = n2;
        n2.next = n3;

        ListNode n4 = new Q21MergeTwoSortedLists().new ListNode(1);
        ListNode n5 = new Q21MergeTwoSortedLists().new ListNode(3);
        ListNode n6 = new Q21MergeTwoSortedLists().new ListNode(4);
        n4.next = n5;
        n5.next = n6;

        ListNode result = solution.mergeTwoLists(n1, n4);
        for (ListNode temp = result; temp != null; temp = temp.next) {
            System.out.println(temp.val);
        }

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {

        /**
         * 官方思路：
         * 我们可以用迭代的方法来实现上述算法。当 l1 和 l2 都不是空链表时，判断 l1 和 l2 哪一个链表的头节点的值更小，将较小值的节点添加到结果里，
         * 当一个节点被添加到结果里之后，将对应链表中的节点向后移一位。
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode preHead = new ListNode(-1);

            ListNode pre = preHead;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    pre.next = l1;
                    l1 = l1.next;
                } else {
                    pre.next = l2;
                    l2 = l2.next;
                }
                pre = pre.next;
            }

            pre.next = l1 == null ? l2 : l1;
            return preHead.next;
        }

        // 个人思路：以list1为基础，把list2中的节点和list1的节点进行值比较。如果小于，节点插入到list1前面；如果大于，继续遍历list1，找到插入的位置（n.val < val < n.next.val）
        // 思路不行，太复杂，且代码不好实现。
        public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {

            if (list1 == null && list2 == null) {
                return null;
            }

            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }

            ListNode temp = list2;

            while (temp != null) {
                int val = temp.val;
                ListNode next = temp.next;
                if (val < list1.val) {
                    temp.next = list1;
                    list1 = temp;
                    break;
                } else {
                    ListNode next1 = list1.next;
                    while (next1 != null) {
                        if (val < next1.val) {
                            list1.next = temp;
                            temp.next = next1;
                            break;
                        }
                        list1 = list1.next;
                    }
                }
                temp = next;
            }

            return list1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}