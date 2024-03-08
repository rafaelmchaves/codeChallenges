package linkedlist;

/**
 *
 * <a href="https://leetcode.com/problems/two-sum/description/">two-sum-problem-leetcode</a>
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;

        int rest = 0;
        ListNode node1 = l1;
        ListNode node2 = l2;
        while (node1 != null || node2 != null || rest != 0) {
            int sum = (node1 != null ? node1.val : 0) + (node2 != null ? node2.val : 0) + rest;
            if (sum > 9) {
                sum = sum - 10;
                rest = 1;
            } else {
                rest = 0;
            }

            tail.next = new ListNode(sum);
            tail = tail.next;

            node1 = node1 != null? node1.next : null;
            node2 = node2 != null? node2.next : null;
        }

        return head.next;
    }

    public static void main(String[] args) {

        //[2,4,3]
        ListNode e = new ListNode(2);
        e.next = new ListNode(4);
        e.next.next = new ListNode(3);

        ListNode e2 = new ListNode(5);
        e2.next = new ListNode(6);
        e2.next.next = new ListNode(4);

        var resultListNode = addTwoNumbers(e, e2);

        while (resultListNode != null) {
            System.out.print(resultListNode.val + " ");
            resultListNode = resultListNode.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
