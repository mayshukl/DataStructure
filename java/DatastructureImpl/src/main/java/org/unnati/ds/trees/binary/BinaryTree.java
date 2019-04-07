package org.unnati.ds.trees.binary;

import org.unnati.ds.DataStructureUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;

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

         @Override
         public boolean equals(Object o) {
             if (this == o) return true;
             if (o == null || getClass() != o.getClass()) return false;
             Node node = (Node) o;
             return Objects.equals(value, node.value) &&
                     Objects.equals(leftNode, node.leftNode) &&
                     Objects.equals(rightNode, node.rightNode);
         }

         @Override
         public int hashCode() {
             return Objects.hash(value, leftNode, rightNode);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryTree that = (BinaryTree) o;
        return Objects.equals(root, that.root);
    }

    @Override
    public int hashCode() {
        return Objects.hash(root);
    }

    public BinaryTree(@NotNull  Object value){
        this.root=new Node(value);
        size++;
    }

    public BinaryTree(@NotNull  Node value){
        this.root=value;
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

    public int getMaxWidth(){
        if(this.root==null)
            return 0;
        int dia=0;
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(this.root);
        queue.add(null);
        int tempDia=0;
        while(!queue.isEmpty()){
            Node node=queue.poll();
            if(node!=null){
                tempDia++;
                if(node.leftNode!=null) queue.add(node.leftNode);
                if(node.rightNode!=null) queue.add(node.rightNode);
            }else{
                if(queue.size()!=0){
                    if(tempDia>dia)
                        dia=tempDia;
                    tempDia=0;
                    queue.add(null);
                }
            }
        }
        return dia;
    }

    public int getHeight(){
        return this.getDepth(this.root);
    }

    /**
     *
     * Get Diameter of the tree height(leftSubtree)+height(rightSubtree)+1
     *
     * */

    public int getDiameter(){
        return this.root==null ? 0 : this.getDepth(root.leftNode)+this.getDepth(root.rightNode)+1;
    }

    private int getDepth(Node node){
        if(node==null)
            return 0;
        int leftSubTreeDepth=this.getDepth(node.leftNode);
        int rightSubTreeDepth=this.getDepth(node.rightNode);
        return (leftSubTreeDepth>rightSubTreeDepth ? leftSubTreeDepth:rightSubTreeDepth)+1;
    }

    /**
     * Clone a Binary tree
     *
     * */
    public BinaryTree clone(){
        return new BinaryTree(this.cloneNode(this.root));
    }

    private Node cloneNode(Node node){
        if(node==null)
            return null;
        Node clonedLeftNode=null;
        Node clonedRightNode=null;
        if(node.leftNode!=null){
            clonedLeftNode=cloneNode(node.leftNode);
        }
        if(node.rightNode!=null){
            clonedRightNode=cloneNode(node.rightNode);
        }
        Node clonedNode=new Node(node.value);
        clonedNode.leftNode=clonedLeftNode;
        clonedNode.rightNode=clonedRightNode;
        return clonedNode;
    }

    /**
     *  Nodes at kth distance
     *
     * */
    public List<Node> getNodesAtDistance(int distance){
        List<Node> list=new ArrayList<Node>();
        this.getNodesAtDistance(this.root,distance,list);
        return list;
    }

    private void getNodesAtDistance(Node node,int distance,List nodes){
        if(node==null)
            return;

        if(distance==0)
            nodes.add(node.getValue());
        else{
            getNodesAtDistance(node.leftNode,distance-1,nodes);
            getNodesAtDistance(node.rightNode,distance-1,nodes);
        }
    }

    /**
     *
     *  Print Ancestor
     *
     * */
    public List<Node> getAncestor(Node searchKey){
        if(searchKey==null || searchKey.value==null)
            return new ArrayList<Node>();
        List<Node> list=new ArrayList<Node>();
        isAncestor(this.root,searchKey,list);
        return list;
    }

    private boolean isAncestor(Node node,Node searchKey,List ancestors) {
        if (node == null)
            return false;
        boolean isAncestor = false;
        if (node.value.equals(searchKey.value)){
            return true;
        }else{
           isAncestor= this.isAncestor(node.leftNode,searchKey,ancestors) ||   this.isAncestor(node.rightNode,searchKey,ancestors);
           if(isAncestor){
               ancestors.add(node.value);
           }
        }
        return isAncestor;
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
     * Depth First Search Inorder with Stack
     *
     * */
    public List inorderWithStack(){
        List list=new ArrayList();
        Stack<Node> stack=new Stack();
        Node node=this.getRoot();
        if(node==null)
            return list;
        //stack.add(node);
        this.pushNodes(node,stack);
        while(!stack.empty()) {
            node=stack.pop();
            list.add(node.getValue());
            this.pushNodes(node.getRightNode(),stack);
        }
        return list;
    }

    public void pushNodes(Node node,Stack stack){
        while (node != null) {
            stack.push(node);
            node=node.getLeftNode();
        }
    }

    /***
     *
     * Depth First Search Inorder with Threaded
     *
     * */
    public List inorderWithThreadedTree(){
        List list=new ArrayList();
        Node node=this.getRoot();
        if(node==null)
            return list;
        while(node!=null) {
            if (node.getLeftNode() == null) {
                list.add(node.getValue());
                node = node.getRightNode();
            } else {
                Node pre = node.getLeftNode();
                while (pre.getRightNode() != null && pre.rightNode != node)
                    pre = pre.getRightNode();

                if (pre.rightNode == node) {
                    pre.rightNode = null;
                    list.add(node.getValue());
                    node=node.rightNode;
                }else {
                    pre.rightNode = node;
                    node = node.leftNode;
                }
            }
        }
        return list;
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
