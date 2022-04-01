import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeNodeTest {
    @Test
    public void addNonNullElement(){
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(15);
        assertEquals(15, newNode.getElement());
    }
    @Test
    public void addNullElement(){
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(null);
        assertEquals(null, newNode.getElement());
    }

    @Test
    public void setNotNullElement(){
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(15);
        newNode.setElement(20);
        assertEquals(20, newNode.getElement());
    }
    @Test
    public void setNullElement(){
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(15);
        newNode.setElement(null);
        assertEquals(null, newNode.getElement());
    }

    @Test
    public void addNotNullChildToNotNullElement(){
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(15);
        newNode.addLeftChild(new BinaryTreeNode<>(6));
        assertEquals(6, newNode.getLeftChild().getElement());
    }
    @Test
    public void addNullChildToNotNullElement(){
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(15);
        newNode.addLeftChild(new BinaryTreeNode<>(null));
        assertEquals(null, newNode.getLeftChild().getElement());
    }
   /* @Test
    public void addNullChildToNullElement(){
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(null);
        newNode.addLeftChild(new BinaryTreeNode<>(null));
        assertEquals(null, newNode.getLeftChild().getElement());
    }
    @Test
    public void addNotNullChildToNullElement(){
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(null);
        newNode.addLeftChild(new BinaryTreeNode<>(15));
        assertEquals(null, newNode.getLeftChild().getElement());
    }*/
}
