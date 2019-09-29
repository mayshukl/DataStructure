package org.unnati.leetcode;

public class RemoveNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node=head;
        int length=0;
        while(node!=null){
            node=node.next;
            length++;
        }
        
        if(length==n){
            return head.next;
        }
        node=head;
        for(int i=1;i<length-n;i++){
            node=node.next;
        }
        if(node.next!=null){
            node.next=node.next.next;
        }
        return head;
    }
}
