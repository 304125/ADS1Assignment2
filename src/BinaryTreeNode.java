public class BinaryTreeNode<E> {
    private E element;
    private BinaryTreeNode<E> leftChild;
    private BinaryTreeNode<E> rightChild;

    public BinaryTreeNode(E element){
        this.element = element;
        leftChild = null;
        rightChild = null;
    }

    public BinaryTreeNode(){
        element = null;
        leftChild = null;
        rightChild = null;
    }

    public void setElement(E element){
        this.element = element;
    }
    public E getElement(){
        return element;
    }
    public void addLeftChild(BinaryTreeNode<E> leftChild){
        if(element != null){
            this.leftChild = leftChild;
        }
    }
    public void addRightChild(BinaryTreeNode<E> rightChild){
        if(element != null){
            this.rightChild = rightChild;
        }
    }
    public BinaryTreeNode<E> getLeftChild(){
        return leftChild;
    }
    public BinaryTreeNode<E> getRightChild(){
        return rightChild;
    }
}
