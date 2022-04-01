import java.util.ArrayList;
import java.util.List;

public class BinaryTree<E> {
    private BinaryTreeNode<E> root;
    private int size;

    public BinaryTree(BinaryTreeNode<E> root){
        this.root = root;
        if(root == null){
            size = 0;
        }
        else{
            this.size = inOrder().size();
        }
    }

    public BinaryTree(){
        root = null;
        size = 0;
    }

    public BinaryTreeNode<E> getRoot(){
        return root;
    }
    public void setRoot(BinaryTreeNode<E> root){
         this.root = root;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    public boolean contains(E element){
        return contains(root, element);
    }

    private boolean contains(BinaryTreeNode<E> node, E element){
        if(node == null){
            return false;
        }
        if(node.getElement().equals(element)){
            return true;
        }
        contains(node.getRightChild(), element);
        contains(node.getLeftChild(), element);
        return false;
    }

    public ArrayList<E> inOrder(){
        ArrayList<E> list = new ArrayList<>();
        if(root != null){
            inOrder(list, root);
        }
        return list;
    }
    private void inOrder(ArrayList<E> list, BinaryTreeNode<E> node){
        if(node.getLeftChild() != null){
            inOrder(list, node.getLeftChild());
        }
        list.add(node.getElement());
        if(node.getRightChild() != null){
            inOrder(list, node.getRightChild());
        }
    }
    public ArrayList<E> preOrder(){
        ArrayList<E> list = new ArrayList<>();
        if(root != null){
            preOrder(list, root);
        }
        return list;
    }
    private void preOrder(ArrayList<E> list, BinaryTreeNode<E> node){
        list.add(node.getElement());
        if(node.getLeftChild() != null){
            inOrder(list, node.getLeftChild());
        }
        if(node.getRightChild() != null){
            inOrder(list, node.getRightChild());
        }
    }
    public ArrayList<E> postOrder(){
        ArrayList<E> list = new ArrayList<>();
        if(root != null){
            postOrder(list, root);
        }
        return list;
    }
    private void postOrder(ArrayList<E> list, BinaryTreeNode<E> node){
        if(node.getLeftChild() != null){
            inOrder(list, node.getLeftChild());
        }
        if(node.getRightChild() != null){
            inOrder(list, node.getRightChild());
        }
        list.add(node.getElement());
    }
    public ArrayList<E> levelOrderMaggie(){
        return null;
    }

    public ArrayList<E> levelOrderKim(){
        //BinaryTreeNode<E>[] order = new BinaryTreeNode<E>[];

        // ArrayList<E> order = new ArrayList<>();
        // E element = null;
        //order.add(2, element);
        return null;
    }

    public int height(){
        int height = 0;
        return height(root);
    }

    private int height(BinaryTreeNode<E> node){
        if (node.getRightChild() == null && node.getLeftChild() == null){
            return 0;
        }
        return 1 + Math.max(node.getLeftChild() != null ? height(node.getLeftChild()):0,
                            node.getRightChild() != null ? height(node.getRightChild()):0);
    }
}
