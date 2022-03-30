import java.lang.reflect.Array;
import java.util.ArrayList;

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
        BinaryTreeNode[] nodeArray = new BinaryTreeNode[(int)Math.pow(2, height()+1)];
        if(root != null){
            nodeArray[0] = root;
        }
        int position = 1;
        while(getArrayListLength(nodeArray) < size){
            double parentPosition = ((double)position-1)/2;
            if(nodeArray[(int)parentPosition] != null){
                //if ends by .0 = left child
                if(parentPosition*10%10 == 0){
                    nodeArray[position] = nodeArray[(int)parentPosition].getLeftChild();
                }
                //if ends by .5 = right child
                else{
                    nodeArray[position] = nodeArray[(int)parentPosition].getRightChild();
                }

            }
            position++;
        }
    }

    private int getArrayListLength(BinaryTreeNode[] array){
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != null){
                count++;
            }
        }
        return count;
    }

    /*public ArrayList<E> levelOrderKim(){

    }*/

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
