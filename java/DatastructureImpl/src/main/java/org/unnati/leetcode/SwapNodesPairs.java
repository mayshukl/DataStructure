package org.unnati.leetcode;

public class SwapNodesPairs {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public ListNode swapPairs(ListNode head) {
        ListNode node=head,temp;
        //swap first 2 node
        if(node!=null&&node.next!=null){
            temp=node.next;
            node.next=temp.next;
            temp.next=node;
            node=temp.next;
            head=temp;
        }
        while(node!=null&&node.next!=null&&node.next.next!=null){
            temp=node.next.next;
            node.next.next=temp.next;
            temp.next=node.next;
            node.next=temp;
            node=temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        SwapNodesPairs swapNodesPairs=new SwapNodesPairs();
        
    }
    
    
}
