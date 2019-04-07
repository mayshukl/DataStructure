package org.unnati.ds.trees.binary;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTest {
//                     5
 //                 /       \
//               /             \
//            4                 6
//            \                 /
//              8              10
    BinaryTree binaryTree=null;
//                     5
//                 /       \
//               /             \
//            4                 4
//            \                 /
//              8              8
    BinaryTree foldableBinaryTree=null;

    @Before
    public void setUp(){
        binaryTree=new BinaryTree(5);
        BinaryTree.Node node=binaryTree.getRoot();
        BinaryTree.Node rootLeft=binaryTree.getRoot().addNode(BinaryTree.NodeSide.LEFT, 4);
        BinaryTree.Node rootLeftRight=rootLeft.addNode(BinaryTree.NodeSide.RIGHT, 8);

        BinaryTree.Node rootRight=binaryTree.getRoot().addNode(BinaryTree.NodeSide.RIGHT,6);
        BinaryTree.Node rootRightLeft=rootRight.addNode(BinaryTree.NodeSide.LEFT,10);

        foldableBinaryTree=new BinaryTree(5);
        node=foldableBinaryTree.getRoot();
        rootLeft=foldableBinaryTree.getRoot().addNode(BinaryTree.NodeSide.LEFT, 4);
        rootLeftRight=rootLeft.addNode(BinaryTree.NodeSide.RIGHT, 8);

        rootRight=foldableBinaryTree.getRoot().addNode(BinaryTree.NodeSide.RIGHT,4);
        rootRightLeft=rootRight.addNode(BinaryTree.NodeSide.LEFT,8);
    }

    @Test
    public void createBinaryTree(){
        BinaryTree binaryTree=new BinaryTree(5);
        binaryTree.getRoot().addNode(BinaryTree.NodeSide.LEFT, 4);
        binaryTree.getRoot().addNode(BinaryTree.NodeSide.RIGHT,6);
        Assert.assertEquals(binaryTree.getRoot().getValue(),5);
        Assert.assertEquals(binaryTree.getRoot().findNode(BinaryTree.NodeSide.LEFT).getValue(),4);
        Assert.assertEquals(binaryTree.getRoot().findNode(BinaryTree.NodeSide.RIGHT).getValue(),6);
    }

    @Test
    public void testGetHeight(){
        Assert.assertEquals(3,binaryTree.getHeight());
    }

    @Test
    public void testGetDiameter(){
        Assert.assertEquals(5,binaryTree.getDiameter());
    }

    @Test
    public void testGetWidth(){
        Assert.assertEquals(2,binaryTree.getMaxWidth());
    }

    @Test
    public void testGetNodesAtDistance(){
        List list=new ArrayList();
        list.add(8);list.add(10);
        Assert.assertEquals(list,binaryTree.getNodesAtDistance(2));
    }

    @Test
    public void testClone(){
        BinaryTree clone=binaryTree.clone();
        Assert.assertEquals(clone,binaryTree);
    }

    @Test
    public void testGetAncestor(){
        List list=new ArrayList();
        list.add(4);list.add(5);
        BinaryTree.Node node=new BinaryTree(8).getRoot();
        Assert.assertEquals(list,binaryTree.getAncestor(node));
    }

    @Test
    public void testInorder(){
        List list=new ArrayList();
        list.add(4);list.add(8);list.add(5);list.add(10);list.add(6);
        List result=binaryTree.inorder();
        Assert.assertEquals(list,result);

    }

    @Test
    public void testInorderWithStack(){
        List list=new ArrayList();
        list.add(4);list.add(8);list.add(5);list.add(10);list.add(6);
        List result=binaryTree.inorderWithStack();
        Assert.assertEquals(list,result);

    }

    @Test
    public void testInorderWithThreded(){
        List list=new ArrayList();
        list.add(4);list.add(8);list.add(5);list.add(10);list.add(6);
        List result=binaryTree.inorderWithThreadedTree();
        Assert.assertEquals(list,result);

    }

    @Test
    public void testPreorder(){
        List list=new ArrayList();
        list.add(5); list.add(4);list.add(8);list.add(6);list.add(10);
        List result=binaryTree.preorder();
        Assert.assertEquals(list,result);

    }
    @Test
    public void testPostorder(){
        List list=new ArrayList();
        list.add(8);list.add(4);list.add(10); list.add(6);list.add(5);
        List result=binaryTree.postorder();
        Assert.assertEquals(list,result);

    }

    @Test
    public void testLevelorder(){
        List list=new ArrayList();
        list.add(5);list.add(4);list.add(6); list.add(8);list.add(10);
        List result=binaryTree.levelOrder();
        Assert.assertEquals(list,result);

    }

    @Test
    public void testTreeLevel(){
        Assert.assertEquals(3,this.binaryTree.getLevel());

    }

    @Test
    public void testConvertToArray(){
        Object[] array=new Object[]{5,4,6,null,8,10,null};
        Assert.assertEquals(array,this.binaryTree.getAsArray());
    }

    @Test
    public void testIsFoldable(){
        Assert.assertEquals(false,this.binaryTree.isTreeFoldable());
        Assert.assertEquals(true,this.foldableBinaryTree.isTreeFoldable());
    }

    @Test
    public void testGeneratePostOrder(){
       Integer[] inOrder=new Integer[]{4, 2, 5, 1, 3, 6};
       Integer[] preOrder=new Integer[]{1, 2, 4, 5, 3, 6};
        Integer[] postOrderEx=new Integer[]{4, 5, 2, 6, 3, 1};
       Object[] postOrderResult=BinaryTree.getPostOrder(inOrder,preOrder);
        Assert.assertEquals(postOrderEx,postOrderResult);
    }
}
