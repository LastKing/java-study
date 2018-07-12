package leecode.chain;

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
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(10);

        node1.next = node2;

        Test2 test = new Test2();
        test.removeNthFromEnd(node1, 2);

        System.out.println(node1.val);
        System.out.println(node1.next.val);
        System.out.println(node1.next.next.val);
        System.out.println(node1.next.next.next.val);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        int length = 1;

        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            length++;
        }
        int num = length - n;

        ListNode node2 = head;
        for (int i = 0; i <= num; i++) {
            if (i == num) {
                node2.val = node2.next.val;
                node2.next = node2.next.next;
            } else {
                node2 = node2.next;
            }
        }
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
