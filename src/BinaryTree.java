import java.lang.reflect.Array;
import java.util.*;

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
        if(root == null){
            return false;
        }
        return contains(root, element);
    }

    /*private boolean containsKim(BinaryTreeNode<E> node, E element){
        if(node.getElement().equals(element)){
            return true;
        }
        if(node.getRightChild() != null)
            return contains(node.getRightChild(), element);
        if(node.getLeftChild() != null)
            return contains(node.getLeftChild(), element);
        return false;
    }*/

    private boolean contains(BinaryTreeNode<E> node, E element){
        ArrayList<E> allNodes = levelOrderKim();
        return allNodes.contains(element);
    }

    public ArrayList<E> inOrder(){
        if(root == null){
            return null;
        }
        ArrayList<E> list = new ArrayList<>();
        inOrder(list, root);
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
        if(root == null){
            return null;
        }
        ArrayList<E> list = new ArrayList<>();
        preOrder(list, root);
        return list;
    }
    private void preOrder(ArrayList<E> list, BinaryTreeNode<E> node){
        list.add(node.getElement());
        if(node.getLeftChild() != null){
            preOrder(list, node.getLeftChild());
        }
        if(node.getRightChild() != null){
            preOrder(list, node.getRightChild());
        }
    }
    public ArrayList<E> postOrder(){
        if(root == null){
            return null;
        }
        ArrayList<E> list = new ArrayList<>();
        postOrder(list, root);
        return list;
    }
    private void postOrder(ArrayList<E> list, BinaryTreeNode<E> node){
        if(node.getLeftChild() != null){
            postOrder(list, node.getLeftChild());
        }
        if(node.getRightChild() != null){
            postOrder(list, node.getRightChild());
        }
        list.add(node.getElement());
    }

    public ArrayList<E> levelOrderMaggie(){
        long start = Calendar.getInstance().getTimeInMillis();
        if(root == null){
            return null;
        }
        BinaryTreeNode<E>[] nodeArray = new BinaryTreeNode[(int)Math.pow(2, height()+1)];
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
        ArrayList<E> listToReturn = new ArrayList<>();
        for (BinaryTreeNode<E> binaryTreeNode : nodeArray) {
            if (binaryTreeNode != null) {
                listToReturn.add(binaryTreeNode.getElement());
            }
        }
        long end = Calendar.getInstance().getTimeInMillis();
        System.out.println("Maggie time in ms: " +(end-start));
        return listToReturn;
    }

    private int getArrayListLength(BinaryTreeNode<E>[] array){
        int count = 0;
        for (BinaryTreeNode<E> eBinaryTreeNode : array) {
            if (eBinaryTreeNode != null) {
                count++;
            }
        }
        return count;
    }

    public ArrayList<E> levelOrderKim(){
        long start = Calendar.getInstance().getTimeInMillis();
        if (root == null){
            return null;
        }
        ArrayDeque<BinaryTreeNode<E>> orderQueue = new ArrayDeque<>();
        ArrayList<E> orderedArray = new ArrayList<>();
        orderQueue.add(root);
        while(!orderQueue.isEmpty()){
            BinaryTreeNode<E> node = orderQueue.pop();
            orderedArray.add(node.getElement());
            if (node.getLeftChild() != null){
                orderQueue.add(node.getLeftChild());
            }
            if (node.getRightChild() != null){
                orderQueue.add(node.getRightChild());
            }
        }
        long end = Calendar.getInstance().getTimeInMillis();
        System.out.println("Kim time in ms: " +(end-start));
        return orderedArray;
    }

    public int height(){
        if(root == null){
            return -1;
        }
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
