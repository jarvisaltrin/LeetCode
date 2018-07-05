//Given a linked list, remove the n-th node from the end of list and return its head.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start, fast = start;
        //To make gap between slow and fast as n, move fast in front
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //maintain the gap and move fast to end
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
}