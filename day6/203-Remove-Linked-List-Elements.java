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
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode nextnode=curr.next;
            if(curr.val==val){
 
               
                if(prev==null){
                    head=nextnode;
                }
                else{
                     prev.next=nextnode;
                     
                }
                
                curr=nextnode;

            }
            else{
                prev=curr;
                curr=nextnode;
            }
            
        }
        return head;
    }
}