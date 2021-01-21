package listnode.leetcode206;
//反转一个单链表。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
// 进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
// Related Topics 链表
// 👍 1439 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

//https://leetcode-cn.com/problems/reverse-linked-list/
import listnode.ListNode;
import org.junit.Test;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            ListNode tempNode = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = tempNode;
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

        tempNode = reverseList(listNode5);
        System.out.println();

        while (tempNode != null) {
            System.out.print(tempNode.val + "\t");
            tempNode = tempNode.next;
        }
    }
}
