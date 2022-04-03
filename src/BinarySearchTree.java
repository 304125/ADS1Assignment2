public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {
    private BinarySearchTreeNode<E> root;

    public BinarySearchTree(BinarySearchTreeNode<E> root) {
        super(root);
        this.root = root;
    }

    public BinarySearchTree() {
        super();
    }

    public boolean insert(E element){
        return true;
    }

    public boolean removeElement(E element){
        return true;
    }

    public E findMin(){
        return null;
    }

    public E findMax(){
        return null;
    }

    public boolean contains(E element){
        return super.contains(element);
    }

    public void rebalance(){

    }
}
