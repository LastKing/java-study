package leetcode.chain;

/**
 * 删除链表的中结点
 *
 * @author toonew on 2018/7/12
 */
public class Test1 {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Test1 test = new Test1();
        test.deleteNode(node2);

        System.out.println(node1.val);
        System.out.println(node1.next.val);
        System.out.println(node1.next.next.val);
    }

    public void deleteNode(ListNode node) {

        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;

    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
