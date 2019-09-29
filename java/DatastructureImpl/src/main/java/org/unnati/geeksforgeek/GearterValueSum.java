package org.unnati.geeksforgeek;

public class GearterValueSum {
    private class Node {

        int data;
        Node left, right;

        Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    Node root;

    void inorder()
    {
        inorderUtil(this.root);
    }

    public void insert(int data)
    {
        this.root = this.insertRec(this.root, data);
    }

    Node insertRec(Node node, int data)
    {
        /* If the tree is empty, return a new node */
        if (node == null) {
            this.root = new Node(data);
            return this.root;
        }

        /* Otherwise, recur down the tree */
        if (data <= node.data) {
            node.left = this.insertRec(node.left, data);
        } else {
            node.right = this.insertRec(node.right, data);
        }
        return node;
    }

    // Utility function for inorder traversal of 
    // the tree 
    void inorderUtil(Node node)
    {
        if (node == null)
            return;

        inorderUtil(node.left);
        System.out.print(node.data + " ");
        inorderUtil(node.right);
    }

    // Driver Function 
    public static void main(String[] args)
    {
        GearterValueSum tree = new GearterValueSum(); 
          
          /* Let us create following BST 
              50 
           /     \ 
          30      70 
         /  \    /  \ 
       20   40  60   80 */

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.modifyBST(tree.root);

        // print inoder tarversal of the modified BST 
        tree.inorder();
    }


    int modifyBST(Node node){
        return modifyBST(node,0);
    }

    int modifyBST(Node node,int sum){
        if(node==null){
            return sum;
        }
        
        int rightSum=modifyBST(node.right,sum);
        node.data=node.data+rightSum;
        return modifyBST(node.left,node.data);
    }

}
