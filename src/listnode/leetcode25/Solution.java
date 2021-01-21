package listnode.leetcode25;
//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
//
//
// 示例：
//
// 给你这个链表：1->2->3->4->5
//
// 当 k = 2 时，应当返回: 2->1->4->3->5
//
// 当 k = 3 时，应当返回: 3->2->1->4->5
//
//
//
// 说明：
//
//
// 你的算法只能使用常数的额外空间。
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
//
// Related Topics 链表
// 👍 845 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

//https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
import listnode.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2)
            return head;
        ListNode newHeadPre = new ListNode();
        newHeadPre.next = head;

        ListNode tempNewHead = newHeadPre;
        ListNode newHead = head;
        while (newHead != null) {
            ListNode tailNode = tempNewHead;
            for (int i = 0; i < k; i++) {
                tailNode = tailNode.next;
                if (tailNode == null)
                    return newHeadPre.next;
            }
            ListNode nextNode = tailNode.next;
            ListNode[] nodes = getNewNode(newHead, tailNode);
            newHead = nodes[0];
            tailNode = nodes[1];

            tempNewHead.next = newHead;
            tailNode.next = nextNode;

            tempNewHead = tailNode;
            newHead = nextNode;
        }
        return newHeadPre.next;
    }

    private ListNode[] getNewNode(ListNode head, ListNode tail) {
        ListNode headTemp = head;
        ListNode tailNext = tail.next;

        while (tail != tailNext) {
            ListNode next = headTemp.next;

            headTemp.next = tailNext;
            tailNext = headTemp;
            headTemp = next;
        }
        return new ListNode[]{tail, head};
    }
}
