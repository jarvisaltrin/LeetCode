// Linked List Cycle II (Floyd's Cycle Detection Algorithm)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // Floyd's Cycle Detection Algorithm
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next!=null){
            slow = slow.next; fast = fast.next.next;
            if(slow == fast){
                ListNode search = head;
                while(search != slow){
                    slow = slow.next; search = search.next;
                }
                return search;
            }
        }
        return null;
    }
}
