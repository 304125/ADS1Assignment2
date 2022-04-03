public class BinarySearchTreeNode<E extends Comparable<? super E>> extends BinaryTreeNode<E>{
    private E element;
    private BinarySearchTreeNode<E> rightChild;
    private BinarySearchTreeNode<E> leftChild;

    public BinarySearchTreeNode(E element){
        super();
        this.element = element;
    }

    @Override
    public E getElement(){
        return element;
    }

    public void addLeftChild(BinarySearchTreeNode<E> leftChild){
        if(element != null){
            this.leftChild = leftChild;
        }
    }
    public void addRightChild(BinarySearchTreeNode<E> rightChild){
        if(element != null){
            this.rightChild = rightChild;
        }
    }
    public BinarySearchTreeNode<E> getLeftChild(){
        return leftChild;
    }
    public BinarySearchTreeNode<E> getRightChild(){
        return rightChild;
    }


}
