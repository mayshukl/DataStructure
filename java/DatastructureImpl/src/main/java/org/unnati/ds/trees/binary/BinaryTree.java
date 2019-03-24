package org.unnati.ds.trees.binary;

import org.unnati.ds.DataStructureUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    enum NodeSide{
        LEFT,
        RIGHT
    }

     class Node{
        private Object value;
        private Node leftNode;
        private Node rightNode;

        public Node findNode(NodeSide side){
            Node node=null;
            switch (side){
                case LEFT:
                    node=this.leftNode;
                    break;
                case RIGHT:
                    node=this.rightNode;
                    break;
            }
            return node;
        }

        public Node addNode(NodeSide side,@NotNull  Object value){
             Node node=new Node(value);
             switch (side){
                 case LEFT:
                     this.leftNode=node;
                 break;
                 case RIGHT:
                     this.rightNode=node;
                  break;
             }
            BinaryTree.this.size++;
             return node;
         }

        public Node(Object value, Node leftNode, Node rightNode) {
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        public Node(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }
    }

    private Node root;
    private int size=0;

    public BinaryTree(@NotNull  Object value){
        this.root=new Node(value);
        size++;
    }

    public Node getRoot() {
        return root;
    }


    public int getLevel(){
        int level=0;
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(this.root);
        queue.add(null);
        while(queue.size()!=0){
            Node node=queue.poll();
            while(node!=null){
                if(node.getLeftNode()!=null){
                    queue.add(node.getLeftNode());
                }
                if(node.rightNode!=null){
                    queue.add(node.getRightNode());
                }
                node=queue.poll();
            }
            level++;
            if(queue.size()!=0){
                queue.add(null);
            }
        }
        return level;
    }


    /***
     *
     * Depth First Search Inorder
     *
     * */
    public List inorder(){
        List list=new ArrayList();
        this.inorder(this.root,list);
        return list;
    }
    private void inorder(Node node,@NotEmpty  List list){
        if(node==null){
            return;
        }
        inorder(node.getLeftNode(),list);
        list.add(node.getValue());
        inorder(node.getRightNode(),list);
    }

    /***
     *
     * Depth First Search Preorder
     *
     * */

    public List preorder(){
        List list=new ArrayList();
        this.preorder(this.root,list);
        return list;
    }
    private void preorder(Node node,@NotEmpty  List list){
        if(node==null){
            return;
        }

        list.add(node.getValue());
        preorder(node.getLeftNode(),list);
        preorder(node.getRightNode(),list);
    }


    /***
     *
     * Depth First Search Postorder
     *
     * */

    public List postorder(){
        List list=new ArrayList();
        this.postorder(this.root,list);
        return list;
    }
    private void postorder(Node node,@NotEmpty  List list){
        if(node==null){
            return;
        }
        postorder(node.getLeftNode(),list);
        postorder(node.getRightNode(),list);
        list.add(node.getValue());
    }

    /***
     *
     * Breadth First Search / Level Ordering
     *
     * */

    public List levelOrder(){
        List list=new ArrayList();
        Queue<Node> queue=new LinkedList();
        if(this.root!=null) queue.add(root);
        this.levelOrder(queue,list);
        return list;
    }
    private void levelOrder(Queue<Node> queue,@NotEmpty  List list){
        if(queue.size()==0){
            return;
        }
        Node node=queue.poll();
        list.add(node.value);
        if(node.leftNode!=null) queue.add(node.leftNode);
        if(node.rightNode!=null) queue.add(node.rightNode);
        this.levelOrder(queue,list);
    }

    /***
     *
     * Breadth First Search / Level Ordering
     *
     * */

    public void insertNodeLevelOrder(@NotNull Object value){
        Queue<Node> queue=new LinkedList();
        queue.add(this.root);
        while(queue.size()!=0){
            Node node=queue.poll();
            if(node.getLeftNode()!=null){
                queue.add(node.getLeftNode());
            }else{
                node.addNode(NodeSide.LEFT,value);
                break;
            }
            if(node.getRightNode()!=null){
                queue.add(node.getRightNode());
            }else{
                node.addNode(NodeSide.RIGHT,value);
                break;
            }
        }
        size++;
    }



    /***
     *
     *  ARRAY REPRESENTATION OF TREE
     *
     * */

    public Object[] getAsArray(){
        Object[] array=new Object[(int)Math.pow(2D,(double)this.getLevel())-1];
        this.convertToArray(0,this.getRoot(),array);
        return array;
    }

    private void convertToArray(int index,Node root,Object[] array){
        if(root==null)
            return;
        array[index]=root.getValue();
        convertToArray(2*index+1,root.getLeftNode(),array);
        convertToArray(2*index+2,root.getRightNode(),array);
    }


    /***
     *
     *  CHECK IF TREE IS MIRROR IMAGE OF ITSELF
     *
     * */

    public boolean isTreeFoldable(){
       boolean isFoldable=true;
       if(this.getRoot()!=null )
           isFoldable=isMirrorImage(this.getRoot().getLeftNode(),this.getRoot().getRightNode());
       return isFoldable;
    }

    /***
     *
     *  CHECK IF 2 TREE  ARA MIRROR IMAGE OF EACH OTHER
     *
     * */

    public static boolean isMirrorImage(BinaryTree tree1, BinaryTree tree2){
        return isMirrorImage(tree1.getRoot(),tree2.getRoot());
    }

    public static boolean isMirrorImage(Node tree1, Node tree2){
        boolean isMirror=true;
        if(tree1==null && tree2==null)
            return true;

        if(tree1==null&&tree2!=null || tree1!=null&&tree2==null || tree1.getValue()!=tree2.getValue())
            return false;
        isMirror =   isMirrorImage(tree1.getLeftNode(),tree2.getRightNode()) &&   isMirrorImage (tree1.getRightNode(),tree2.getLeftNode());
        return isMirror;
    }

    /***
     *
     *  Print Post Order from preOrder and inOrder
     *
     * */
    static Integer preIndex=0;
    public static Object[] getPostOrder(Object[] inOrder,Object[] preOrder){
        List objects=new ArrayList();
        positionRootNodeAsPostOrder(inOrder,preOrder,objects,0,inOrder.length-1);
        return objects.toArray();
    }


    private static void positionRootNodeAsPostOrder(Object[] inOrder,Object[] preOrder,List postOrder, int startIndex,int endIndex){
        if(startIndex>endIndex){
            return;
        }
        int rootIndex= DataStructureUtils.findIndex(inOrder,preOrder[preIndex++]);
        //This will position left subtree
        positionRootNodeAsPostOrder(inOrder,preOrder,postOrder,startIndex,rootIndex-1);
        positionRootNodeAsPostOrder(inOrder,preOrder,postOrder,rootIndex+1,endIndex);
        postOrder.add(inOrder[rootIndex]);
    }

}
