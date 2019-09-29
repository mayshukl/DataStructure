package org.unnati.leetcode;

import java.util.Stack;

public class ReverseNodesKGroup {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int[] array,int start, int end) { 
            this.val=array[start];
            if(start<end-1){
                this.next=new ListNode(array,start+1,end);   
            }
        }
    }

    public ListNode reverseKGroup(ListNode head, int k){
        int size=0;
        ListNode lasNode,p1,p2,p3,temp,preLasNode;
        lasNode=p1=p2=p3=head;
        preLasNode=null;
        while(p3!=null){
            size=k;
            while(size>0&&p3!=null){
                size--;
                p3=p3.next;
            }
            if(size>0){
                if(lasNode!=head){
                    lasNode.next=p1;   
                }
            }else{
                p2=p2.next;
                lasNode=null;
                while(p2!=p3){
                    temp=p2.next;
                    p2.next=p1;
                    if(lasNode==null){
                        lasNode=p1;
                    }
                    p1=p2;
                    p2=temp;
                }
                if(preLasNode!=null){
                    preLasNode.next=p1;
                }
                if(lasNode!=null){
                    if(lasNode==head){
                        head=p1;
                    }
                    lasNode.next=p3;
                    preLasNode=lasNode;   
                }
                p1=p3;
            }
        }
    return head;
    }
    
    
    public ListNode reverseKGroupMemoryExceed(ListNode head, int k) {
        Stack<ListNode> stack=new Stack<>();
        ListNode node = head;
        ListNode preNode = head;
        ListNode newHead = null;
        ListNode temp=null;
        int size;
        while (node!=null){
            size=k;
            while(node!=null&&size>0){
                stack.push(node);
                node=node.next;
                size--;
            }
            if(size==0){
                while(!stack.isEmpty()){
                    temp=stack.pop();
                    if(newHead==null){
                        preNode=temp;
                        newHead=preNode;
                    }else {
                        preNode.next=temp;
                        preNode=temp;
                    }
                }
            }else {
                while(!stack.isEmpty()){
                    temp=stack.pop();
                }
                if(newHead==null){
                    newHead=temp;
                }else{
                    preNode.next=temp;    
                }
                
            }
        }
        return newHead;
        
    }

    public static void main(String[] args) {
        ReverseNodesKGroup reverseNodesKGroup=new ReverseNodesKGroup();

        ListNode head=new ListNode(new int[]{1,2,3,4,5},0,5);
        reverseNodesKGroup.reverseKGroup(head,2);
    }
    
}
