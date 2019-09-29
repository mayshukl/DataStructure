package org.unnati.leetcode;
/**
 * If We merge n List one by one , this will take more time
 * proof :
 *  lets suppose we have 4 linked list each with node length 4
 *  
 *  merging first two will take 8 compare
 *  then merging third with result will take (8(from previous merge)+ (8+4)current merge )
 *  then merging Fourth with result will take (20(from previous merge)+ (20+4)current merge )
 *  Total compare will be 44
 * 
 * But in case of device and conquer 
 * 
 *  L1(4)    +     L2(4)        +     L3(4)    +   L4(4)
 * |________8 Compare______|         |_____________8 Compare_____________|
 *             |                                    |
 *             LM1(8)                              LM2(8) 
 *              |________________16 compare____________________|
 *                                  |
 *                                Total 32 Compare  
 * */

public class MergeKSortedLists {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }
        return mergeKLists(lists,0,lists.length-1);
    }

    public ListNode mergeKLists(ListNode[] lists,int start,int end) {
        if(start==end){
            return lists[start];
        }
        if(end-start==1){
           
            return merge2Lists(lists[start],lists[end]);
        }
        int mid=(end+start)/2;
        ListNode left=mergeKLists(lists,start,mid);
        ListNode right=mergeKLists(lists,mid+1,end);
        return merge2Lists(left,right);
    } 
    
    public ListNode merge2Lists(ListNode listNode1,ListNode listNode2) {
        if(listNode2==null){
            return listNode1;
        }
        if(listNode1==null){
            return listNode2;
        }
        ListNode head,node;
        if(listNode1.val<listNode2.val){
            node=listNode1;
            listNode1=listNode1.next;
        }else{
            node=listNode2;
            listNode2=listNode2.next;
        }
        head=node;
        while(listNode1!=null&&listNode2!=null){
            if(listNode1.val<listNode2.val){
                node.next=listNode1;
                listNode1=listNode1.next;
            }else{
                node.next=listNode2;
                listNode2=listNode2.next;
            }
            node=node.next;
        }
        mergeRemainingNode(listNode1,listNode2,node);
        return head;
    }
    
    private void mergeRemainingNode(ListNode listNode1,ListNode listNode2, ListNode node){
        if(listNode1==null){
            mergeRemainingNode(listNode2,listNode1,node);
        }else {
            node.next=listNode1;
        }
    }

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists=new MergeKSortedLists();
        ListNode[] lists=new ListNode[7];
        lists[1]=new ListNode(-10);
        lists[2]=new ListNode(-15);
        lists[3]=new ListNode(4);
        lists[4]=new ListNode(-5);
        lists[5]=null;
        lists[6]=new ListNode(-10);
        mergeKSortedLists.mergeKLists(lists);
    }
    
}
