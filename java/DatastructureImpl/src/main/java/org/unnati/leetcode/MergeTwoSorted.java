package org.unnati.leetcode;

public class MergeTwoSorted {
    
   private static class ListNode{
        int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode head=null,node=null;
        if(l1.val<l2.val){
            node=l1;
            l1=l1.next;
        }else{
            node=l2;
            l2=l2.next;
        }
        head=node;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                node.next=l1;
                l1=l1.next;
            }else{
                node.next=l2;
                l2=l2.next;
            }
            node=node.next;
        }
        addRemaining(l1,l2,node);
        return head;
    }
    
    void addRemaining(ListNode l1, ListNode l2,ListNode node){
        if(l1==null){
            addRemaining(l2,l1,node);
        }else{
            node.next=l1;   
        }
    }

    public static void main(String[] args) {
        MergeTwoSorted mergeTwoSorted=new MergeTwoSorted();
        mergeTwoSorted.mergeTwoLists(new ListNode(1),new ListNode(2));
    }
}
