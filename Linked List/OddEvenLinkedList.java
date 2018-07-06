/* 
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head != null) {
            ListNode odd = head, even = head.next, evenHead = even; 
            while (odd != null && even != null && even.next != null) {
                odd.next = odd.next.next; 
                even.next = even.next.next; 
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead; 
        }
        return head;
        }
    }