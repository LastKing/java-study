package leetcode.chain;

/**
 * @author toonew on 2018/7/12
 */
public class Test3 {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
//        ListNode node4 = new ListNode(9);
//        ListNode node5 = new ListNode(10);

        node1.next = node2;
        node2.next = node3;

        Test3 test = new Test3();
        node1 = test.reverseList(node1);

        System.out.println(node1);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode next = null;


        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
