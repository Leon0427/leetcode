/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //1.sum and carry bit 
        //2.move forward
        //3.see if l1,l2 still not null
        int stayBit = 0, carryBit = 0, sum = 0;
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        while(l1!=null && l2!=null){
            sum = l1.val + l2.val + carryBit;
            carryBit = sum/10;
            cur.next = new ListNode(sum%10);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode left = (l1!=null)?l1:l2;
        while(left!=null){
            sum = left.val + carryBit;
            carryBit = sum/10;
            cur.next = new ListNode(sum%10);
            cur = cur.next;
            left = left.next;
        }
        if(carryBit!=0){
            cur.next = new ListNode(carryBit);
        }
        return ans.next;
    }
}