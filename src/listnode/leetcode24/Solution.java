package listnode.leetcode24;
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
//
//
// 示例 2：
//
//
//输入：head = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100
//
//
//
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
// Related Topics 递归 链表
// 👍 779 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

// https://leetcode-cn.com/problems/swap-nodes-in-pairs/submissions/
import listnode.ListNode;
import org.junit.Test;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode tempNode = head.next;
        head.next = swapPairs(head.next.next);
        tempNode.next = head;
        return tempNode;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = new ListNode(-1);
        ListNode tempNode = newHead;
        while (head != null && head.next != null) {
            ListNode tmpNode = head.next.next;
            tempNode.next = head.next;
            head.next = tmpNode;
            tempNode.next.next = head;
            tempNode = tempNode.next.next;
            head = tempNode.next;
        }
        return newHead.next;
    }

    @Test
    public void test01() {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode1 = new ListNode(1);

        listNode5.next = listNode4;
        listNode4.next = listNode3;
        listNode3.next = listNode2;
        listNode2.next = listNode1;

        ListNode tempNode = listNode5;
        while (tempNode != null) {
            System.out.print(tempNode.val + "\t");
            tempNode = tempNode.next;
        }

        tempNode = swapPairs2(listNode5);
        System.out.println();

        while (tempNode != null) {
            System.out.print(tempNode.val + "\t");
            tempNode = tempNode.next;
        }
    }
}
