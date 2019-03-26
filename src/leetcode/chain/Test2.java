package leetcode.chain;

/**
 * 删除链表的倒数第N个节点
 *
 * @author toonew on 2018/7/12
 */
public class Test2 {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
//        ListNode node4 = new ListNode(9);
//        ListNode node5 = new ListNode(10);

        node1.next = node2;
        node2.next = node3;

        Test2 test = new Test2();
        test.removeNthFromEnd(node1, 4);

        System.out.println(node1);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preNode = head;
        ListNode curNode = head;

        for (int i = 0; i < n; i++) {
            curNode = curNode.next;
        }
        if (curNode == null) {
            return preNode.next;
        }

        while (curNode.next != null) {
            preNode = preNode.next;
            curNode = curNode.next;
        }
        preNode.next = preNode.next.next;

        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
