// Remove Linked List Elements
// Remove all elements from a linked list of integers that have value val.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            if(curr.val == val){
                // First element
                if(prev == null) {
                    head = head.next;
                }
                else{
                    prev.next = curr.next;
                }
            }
            else{
                prev = curr;
            }
            
            curr = curr.next;
        }
        return head;
    }
}