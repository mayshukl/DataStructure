package org.unnati.geeksforgeek;

public class PrintKeysBST {

    private static class Node {

        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static Node root;
    
    void print(Node node, int k1, int k2) {

        /* base case */
        if (node == null) {
            return;
        } 
  
        if(k1<=node.data && node.data<=k2) {
            System.out.print(node.data + " ");
            print(node.left,k1,k2);
            print(node.right,k1,k2);
        }else if(k1>node.data){
            print(node.right,k1,k2);
        }   else {
            print(node.left,k1,k2);
        }
       
    }


    public static void main(String[] args) {
        PrintKeysBST tree = new PrintKeysBST();
        int k1 = 10, k2 = 25;
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);

        tree.print(root, k1, k2);
    }
}
