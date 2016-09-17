package leetcode;

/**
 * Created by heifrank on 16/8/2.
 */
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode cur = node;
        int fill = 0;
        while(l1 != null || l2 != null){
            int x = fill;
            if(l1 != null){
                x += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                x += l2.val;
                l2 = l2.next;
            }

            cur.next = new ListNode(x % 10);
            cur = cur.next;
            fill = x > 9 ? 1 : 0;
        }
        if(fill != 0)cur.next = new ListNode(1);
        return node.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}


