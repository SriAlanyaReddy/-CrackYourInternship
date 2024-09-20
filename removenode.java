/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Base case: if the list is empty, return null
        if (head == null) {
            return null;
        }
        
        // Recursively call the function on the next node
        head.next = removeElements(head.next, val);
        
        // If the current node's value is equal to the target value, skip this node
        return head.val == val ? head.next : head;
    }
}
