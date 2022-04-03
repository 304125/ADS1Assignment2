import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {
    private static BinaryTreePrint print;

    @BeforeAll
    public static void setPrint(){
        print = new BinaryTreePrint();
    }

    @Test
    public void insertDuplicateElement(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(new BinarySearchTreeNode<>(15));
        assertTrue(tree.insert(10));
        assertFalse(tree.insert(15));
    }

    @Test
    public void insertMany(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(new BinarySearchTreeNode<>(15));
        assertTrue(tree.insert(10));
        assertTrue(tree.insert(11));
        assertTrue(tree.insert(18));
        assertTrue(tree.insert(1));
    }

    @Test
    public void insertManyBeforeDuplicate(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(new BinarySearchTreeNode<>(15));
        assertTrue(tree.insert(10));
        assertTrue(tree.insert(11));
        assertTrue(tree.insert(18));
        assertTrue(tree.insert(1));
        assertTrue(tree.insert(12));
        assertTrue(tree.insert(2));
        assertTrue(tree.insert(5));
        assertTrue(tree.insert(22));
        print.printTree(tree.getRoot());
        assertFalse(tree.insert(5));
    }

    @Test
    public void findMinInSetUpTree(){
        BinarySearchTree<Integer> tree = setUpTree();
        assertEquals(1, tree.findMin());
    }

    @Test
    public void findMinInTreeWithRootOnly(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(new BinarySearchTreeNode<>(15));
        assertEquals(15, tree.findMin());
    }

    @Test
    public void findMaxInSetUpTree(){
        BinarySearchTree<Integer> tree = setUpTree();
        assertEquals(22, tree.findMax());
    }

    @Test
    public void findMaxInTreeWithRootOnly(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(new BinarySearchTreeNode<>(15));
        assertEquals(15, tree.findMax());
    }

    @Test
    public void containsOnSetUpTree(){
        BinarySearchTree<Integer> tree = setUpTree();
        assertTrue(tree.contains(18));
        assertTrue(tree.contains(22));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(15));
    }

    @Test
    public void doesNotContainOnSetUpTree(){
        BinarySearchTree<Integer> tree = setUpTree();
        assertFalse(tree.contains(17));
    }

    @Test
    public void containsOnSimpleTree(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(new BinarySearchTreeNode<>(15));
        assertTrue(tree.contains(15));
    }

    @Test
    public void doesNotContainOnSimpleTree(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(new BinarySearchTreeNode<>(15));
        assertFalse(tree.contains(16));
    }

    private BinarySearchTree<Integer> setUpTree(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(new BinarySearchTreeNode<>(15));
        tree.insert(10);
        tree.insert(11);
        tree.insert(18);
        tree.insert(1);
        tree.insert(12);
        tree.insert(2);
        tree.insert(5);
        tree.insert(22);
        tree.insert(16);
        return tree;
    }

    @Test
    public void removeRootSetUpTree(){
        BinarySearchTree<Integer> tree = setUpTree();
        print.printTree(tree.getRoot());
        assertTrue(tree.removeElement(15));
        print.printTree(tree.getRoot());
    }

    @Test
    public void removeLeafSetUpTree(){
        BinarySearchTree<Integer> tree = setUpTree();
        print.printTree(tree.getRoot());
        assertTrue(tree.removeElement(12));
        print.printTree(tree.getRoot());
        assertTrue(tree.removeElement(5));
        print.printTree(tree.getRoot());
    }

    @Test
    public void removeNodeWithOneChildSetUpTree(){
        BinarySearchTree<Integer> tree = setUpTree();
        print.printTree(tree.getRoot());
        assertTrue(tree.removeElement(11));
        print.printTree(tree.getRoot());
        assertTrue(tree.removeElement(2));
        print.printTree(tree.getRoot());
    }

    @Test
    public void removeNodeWithTwoChildrenSetUpTree(){
        BinarySearchTree<Integer> tree = setUpTree();
        print.printTree(tree.getRoot());
        assertTrue(tree.removeElement(10));
        print.printTree(tree.getRoot());
    }

    @Test
    public void rebalanceSetUpTree(){
        BinarySearchTree<Integer> tree = setUpTree();
        print.printTree(tree.getRoot());
        tree.rebalance();
        print.printTree(tree.getRoot());
        assertEquals(setUpTree().inOrder(), tree.inOrder());
    }
}
