package org.unnati.geeksforgeek;

import java.util.*;

public class BinaryTreeVerticalOrder {
    
    private Node root;
    
    private static class Node{
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    
    
    private class Range{
        int min;
        int max;
    }
    
    private void createMap(Node root, int level, Map<Integer, List<Integer>> map,Range range){
        if(root==null){
            return;
        }
        List<Integer> list=map.get(level);
        if(list==null){
            list=new ArrayList<>();
            map.put(level,list);
        }
        list.add(root.data);
        if(range.max<level){
            range.max=level;
        }
        if(range.min>level){
            range.min=level;
        }
        createMap(root.left,level-1,map,range);
        createMap(root.right,level+1,map,range);
    }
    
    public void  verticalOrder(Node root){
        Map<Integer,List<Integer>> map=new HashMap<>();
        Range range=new Range();
        createMap(root,0,map,range);
        
        for(int i=range.min;i<=range.max;i++){
            for(int value:map.get(i)){
                System.out.print(value+" ");
            }
            System.out.println();
        }
    }
    

    public static void main(String args[])
    {
        BinaryTreeVerticalOrder tree = new BinaryTreeVerticalOrder();

        /* Let us construct the tree shown in above diagram */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        tree.root.right.right.right = new Node(9);

        System.out.println("vertical order traversal is :");
        tree.verticalOrder(tree.root);
    }
    
}
