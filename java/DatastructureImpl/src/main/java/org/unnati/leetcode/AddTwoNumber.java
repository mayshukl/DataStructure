package org.unnati.leetcode;

class ListNode{
    int value;
    ListNode next;
    ListNode(int value){
        this.value=value;
    }
}
public class AddTwoNumber {
    private class ReturnType{
        int carry;
        ListNode node;
        ReturnType(int carry,ListNode node){
            this.carry=carry;
            this.node=node;
        }
        
    }  
    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode head=null;
        int length1=findLength(node1);
        int length2=findLength(node2);
        if(length1<length2){
            ListNode temp=node1;
            node1=node2;
            node2=temp;
        }
        ReturnType returnType= addNode(node1,node2,length1-length2);
        if(returnType.carry==1){
            head=new ListNode(1);
            head.next=returnType.node;
        }else {
            head=returnType.node;
        }
        return head;
    }

    ReturnType addNode(ListNode node1,ListNode node2,int diffLength){
        int addSum=0;
        ReturnType returnType=null;
        if(node1==null||node2==null){
            return new ReturnType(0,null);
        }
        if(diffLength>0){
            returnType=addNode(node1.next,node2,diffLength-1);
            addSum=node1.value+returnType.carry;
            
        }else{
             returnType=addNode(node1.next,node2.next,0);
             addSum=node1.value+node2.value+returnType.carry;
        }
        ListNode sumNode=new ListNode(addSum%10);
        sumNode.next=returnType.node;
        return new ReturnType(addSum/10,sumNode);
    }
    
    int findLength(ListNode node){
        if(node==null){
            return 0;
        }
        return findLength(node.next) +1;
    }
}
