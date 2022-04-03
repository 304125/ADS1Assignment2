import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {
    @Test
    public void getNullRoot(){
        BinaryTree<Integer> bt = new BinaryTree<>();
        assertNull(bt.getRoot());
    }

    @Test
    public void getRoot(){
        BinaryTreeNode<Integer> n = new BinaryTreeNode<>(1);
        BinaryTree<Integer> bt = new BinaryTree<>(n);
        assertEquals(1,bt.getRoot().getElement());
    }

    @Test
    public void setNullRoot(){
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.setRoot(null);
        assertNull(bt.getRoot());
    }

    @Test
    public void emptyIsEmpty(){
        BinaryTree<Integer> bt = new BinaryTree<>();
        assertTrue(bt.isEmpty());
    }

    @Test
    public void notEmptyIsEmpty(){
        BinaryTreeNode<Integer> n = new BinaryTreeNode<>();
        BinaryTree<Integer> bt = new BinaryTree<>(n);
        assertFalse(bt.isEmpty());
    }

    @Test
    public void emptyTreeSize(){
        BinaryTree<Integer> bt = new BinaryTree<>();
        assertEquals(0,bt.size());
    }

    @Test
    public void nonEmptyTreeSize(){
        ArrayList<BinaryTreeNode<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i < 11; i++){
            nodes.add(new BinaryTreeNode<>(i+1));
        }
        for(int i = 0; i < 5;i++){
            nodes.get(i).addLeftChild(nodes.get(2*i+1));
            nodes.get(i).addRightChild(nodes.get(2*(i+1)));
        }

        BinaryTree<Integer> bt = new BinaryTree<>(nodes.get(0));
        assertEquals(11,bt.size());
    }

    @Test
    public void containsElement(){
        ArrayList<BinaryTreeNode<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i < 11; i++){
            nodes.add(new BinaryTreeNode<>(i+1));
        }
        for(int i = 0; i < 5;i++){
            nodes.get(i).addLeftChild(nodes.get(2*i+1));
            nodes.get(i).addRightChild(nodes.get(2*(i+1)));
        }
        BinaryTree<Integer> bt = new BinaryTree<>(nodes.get(0));
        assertTrue(bt.contains(8));
    }

    @Test
    public void doesNotContainElement(){
        ArrayList<BinaryTreeNode<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i < 11; i++){
            nodes.add(new BinaryTreeNode<>(i+1));
        }
        for(int i = 0; i < 5;i++){
            nodes.get(i).addLeftChild(nodes.get(2*i+1));
            nodes.get(i).addRightChild(nodes.get(2*(i+1)));
        }
        BinaryTree<Integer> bt = new BinaryTree<>(nodes.get(0));
        assertFalse(bt.contains(14));
    }

    @Test
    public void inOrderNull(){
        BinaryTree<Integer> bt = new BinaryTree<>();
        assertNull(bt.inOrder());
    }

    @Test
    public void inOrderNotNull() {
        List<BinaryTreeNode<Integer>> nodes = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 11; i++){
            nodes.add(new BinaryTreeNode<>(i+1));
        }
        for(int i = 0; i < 5;i++){
            nodes.get(i).addLeftChild(nodes.get(2*i+1));
            nodes.get(i).addRightChild(nodes.get(2*(i+1)));
        }

        numbers.add(8);
        numbers.add(4);
        numbers.add(9);
        numbers.add(2);
        numbers.add(10);
        numbers.add(5);
        numbers.add(11);
        numbers.add(1);
        numbers.add(6);
        numbers.add(3);
        numbers.add(7);

        BinaryTree<Integer> bt = new BinaryTree<>(nodes.get(0));
        assertEquals(numbers, bt.preOrder());
    }

    @Test
    public void preOrderNull(){
        BinaryTree<Integer> bt = new BinaryTree<>();
        assertNull(bt.preOrder());
    }

    @Test
    public void preOrderNotNull(){
        List<BinaryTreeNode<Integer>> nodes = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 11; i++){
            nodes.add(new BinaryTreeNode<>(i+1));
        }
        for(int i = 0; i < 5;i++){
            nodes.get(i).addLeftChild(nodes.get(2*i+1));
            nodes.get(i).addRightChild(nodes.get(2*(i+1)));
        }

        numbers.add(1);
        numbers.add(2);
        numbers.add(4);
        numbers.add(8);
        numbers.add(9);
        numbers.add(5);
        numbers.add(10);
        numbers.add(11);
        numbers.add(3);
        numbers.add(6);
        numbers.add(7);

        BinaryTree<Integer> bt = new BinaryTree<>(nodes.get(0));
        assertEquals(numbers, bt.preOrder());
    }

    @Test
    public void postOrderNull(){
        BinaryTree<Integer> bt = new BinaryTree<>();
        assertNull(bt.postOrder());
    }

    @Test
    public void postOrderNotNull(){
        List<BinaryTreeNode<Integer>> nodes = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 11; i++){
            nodes.add(new BinaryTreeNode<>(i+1));
        }
        for(int i = 0; i < 5;i++){
            nodes.get(i).addLeftChild(nodes.get(2*i+1));
            nodes.get(i).addRightChild(nodes.get(2*(i+1)));
        }

        numbers.add(8);
        numbers.add(9);
        numbers.add(10);
        numbers.add(11);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(2);
        numbers.add(3);
        numbers.add(1);

        BinaryTree<Integer> bt = new BinaryTree<>(nodes.get(0));
        assertEquals(numbers, bt.preOrder());
    }

    @Test
    public void levelOrderNull(){
        BinaryTree<Integer> bt = new BinaryTree<>();
        assertNull(bt.levelOrderMaggie());
    }

    @Test
    public void levelOrderNotNullMaggie() {
        List<BinaryTreeNode<Integer>> nodes = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 11; i++){
            nodes.add(new BinaryTreeNode<>(i+1));
            numbers.add(i+1);
        }
        for(int i = 0; i < 5;i++){
            nodes.get(i).addLeftChild(nodes.get(2*i+1));
            nodes.get(i).addRightChild(nodes.get(2*(i+1)));
        }

        BinaryTree<Integer> bt = new BinaryTree<>(nodes.get(0));
        assertEquals(numbers, bt.levelOrderMaggie());
    }

    @Test
    public void levelOrderNotNullKim() {
        List<BinaryTreeNode<Integer>> nodes = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 11; i++){
            nodes.add(new BinaryTreeNode<>(i+1));
            numbers.add(i+1);
        }
        for(int i = 0; i < 5;i++){
            nodes.get(i).addLeftChild(nodes.get(2*i+1));
            nodes.get(i).addRightChild(nodes.get(2*(i+1)));
        }

        BinaryTree<Integer> bt = new BinaryTree<>(nodes.get(0));
        assertEquals(numbers, bt.levelOrderKim());
    }

    @Test
    public void heightNull(){
        BinaryTree<Integer> bt = new BinaryTree<>();
        assertEquals(-1,bt.height());
    }

    @Test
    public void height(){
        List<BinaryTreeNode<Integer>> nodes = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 11; i++){
            nodes.add(new BinaryTreeNode<>(i+1));
            numbers.add(i+1);
        }
        for(int i = 0; i < 5;i++){
            nodes.get(i).addLeftChild(nodes.get(2*i+1));
            nodes.get(i).addRightChild(nodes.get(2*(i+1)));
        }

        BinaryTree<Integer> bt = new BinaryTree<>(nodes.get(0));
        assertEquals(3, bt.height());
    }
}
