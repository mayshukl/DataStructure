package org.unnati.leetcode;


public class AddTwoNumberReverse {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int value){
            this.val=value;
        }
    }

    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int carry=0;
        while(node1 !=null || node2!=null){
            int x=node1 != null ? node1.val :0 ;
            int y=node2 != null ? node2.val :0 ;
            int sum= x+y+carry;
            carry=sum/10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if(node1!=null){
                node1=node1.next;
            }
            if(node2!=null){
                node2=node2.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return  head.next;
    }
    
}
