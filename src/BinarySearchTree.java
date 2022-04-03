import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {
    //private BinarySearchTreeNode<E> root;

    public BinarySearchTree(BinarySearchTreeNode<E> root) {
        super(root);
        //this.root = root;
    }

    public BinarySearchTree(E element) {
        super(new BinarySearchTreeNode<>(element));
        //this.root = new BinarySearchTreeNode<>(element);
    }

//    public BinarySearchTreeNode<E> getRoot(){
//        return root;
//    }

    public boolean insert(E element){
        if (getRoot() == null){
            super.setRoot(new BinarySearchTreeNode<>(element));
            return true;
        }
        return insert(element, (BinarySearchTreeNode<E>) getRoot());
    }

    private boolean insert(E element, BinarySearchTreeNode<E> node){
        int comparison = node.getElement().compareTo(element);
        if(comparison == 0){
            return false;
        }
        else if(comparison < 0){
            if(node.getRightChild() != null){
                return insert(element, (BinarySearchTreeNode<E>) node.getRightChild());
            }
            else{
                node.addRightChild(new BinarySearchTreeNode<>(element));
                return true;
            }
        }
        else{
            if(node.getLeftChild() != null){
                return insert(element, (BinarySearchTreeNode<E>) node.getLeftChild());
            }
            else{
                node.addLeftChild(new BinarySearchTreeNode<>(element));
                return true;
            }
        }
    }

    public boolean removeElement(E element){
        // Check if tree even contains the element
        // Can maybe be removed to optimize the code
        /*if (!this.contains(element))
            return false;*/
        // Check if root contains element to remove
        BinarySearchTreeNode<E> root = (BinarySearchTreeNode<E>) super.getRoot();
        if (root.getElement().equals(element)){
            // If root has left child do following
            if (root.getLeftChild() != null){
                // If roots left child has no right child use that as a replacement root
                if (root.getLeftChild().getRightChild() == null){
                    root.getLeftChild().addRightChild(root.getRightChild());
                    root = (BinarySearchTreeNode<E>) root.getLeftChild();
                    return true;
                }
                else{
                    // Find the parent of the node containing the highest element in roots left subtree
                    BinarySearchTreeNode<E> maxParent = removeFindMaxParent((BinarySearchTreeNode<E>) root.getLeftChild());
                    BinarySearchTreeNode<E> tmpRoot = root;
                    // Node with highest value gets set to root
                    root = (BinarySearchTreeNode<E>) maxParent.getRightChild();
                    // Previous parent of the highest value node gets all the left children
                    // from the highest value node
                    maxParent.addRightChild(root.getLeftChild());
                    // New root gets the previous roots children
                    root.addLeftChild(tmpRoot.getLeftChild());
                    root.addRightChild(tmpRoot.getRightChild());
                    return true;
                }
            }
            // If root has right child do following
            else if (root.getRightChild() != null){
                // If roots right child has no left child use that as a replacement root
                if (root.getRightChild().getLeftChild() == null){
                    root.getRightChild().addLeftChild(root.getLeftChild());
                    root = (BinarySearchTreeNode<E>) root.getRightChild();
                    return true;
                }
                else{
                    // Find the parent of the node containing the lowest element in roots right subtree
                    BinarySearchTreeNode<E> minParent = removeFindMinParent((BinarySearchTreeNode<E>) root.getRightChild());
                    BinarySearchTreeNode<E> tmpRoot = root;
                    // Node with lowest value gets set to root
                    root = (BinarySearchTreeNode<E>) minParent.getLeftChild();
                    // Previous parent of the lowest value node gets all the right children
                    // from the lowest value node
                    minParent.addLeftChild(root.getRightChild());
                    // New root gets the previous roots children
                    root.addLeftChild(tmpRoot.getLeftChild());
                    root.addRightChild(tmpRoot.getRightChild());
                    return true;
                }
            }
            // If the tree has only one node set root to null
            else{
                root = null;
                return true;
            }
        }
        // Recursively try to find location of element and remove it
        return removeElement(element, root);
    }

    private boolean removeElement(E element, BinarySearchTreeNode<E> node){
        // Check if node has left child
        if (node.getLeftChild() != null) {
            // Check if left child contains the element
            if (node.getLeftChild().getElement().equals(element)) {
                // Node that needs to be removed
                BinarySearchTreeNode<E> toRemove = (BinarySearchTreeNode<E>) node.getLeftChild();
                // Check if node has any children, if not parents left child just points to null
                if (toRemove.getRightChild() == null && toRemove.getLeftChild() == null) {
                    node.addLeftChild(null);
                    return true;
                }
                // Check if node toRemoves left child has a right child
                // if not the replacement node is toRemoves left child
                if (toRemove.getLeftChild().getRightChild() == null){
                    node.addLeftChild(toRemove.getLeftChild());
                    toRemove.getLeftChild().addRightChild(toRemove.getRightChild());
                    return true;
                }
                else{
                    // Find parent of node with max value in toRemoves left subtree
                    BinarySearchTreeNode<E> maxParent = removeFindMaxParent((BinarySearchTreeNode<E>) toRemove.getLeftChild());
                    // Node with max value
                    BinarySearchTreeNode<E> max = (BinarySearchTreeNode<E>) maxParent.getRightChild();
                    // Shuffle
                    node.addLeftChild(max);
                    maxParent.addRightChild(max.getLeftChild());
                    max.addRightChild(toRemove.getRightChild());
                    max.addLeftChild(toRemove.getLeftChild());
                    return true;
                }

            }
            // if element is smaller than nodes element
            // recursively remove on nodes left subtree
            if (node.getElement().compareTo(element) > 0) {
                return removeElement(element, (BinarySearchTreeNode<E>) node.getLeftChild());
            }
        }
        // Check if node has right child
        if (node.getRightChild() != null) {
            // Check if right child contains the element
            if (node.getRightChild().getElement().equals(element)) {
                // Node that needs to be removed
                BinarySearchTreeNode<E> toRemove = (BinarySearchTreeNode<E>) node.getRightChild();
                // Check if node has any children, if not parents right child just points to null
                if (toRemove.getRightChild() == null && toRemove.getLeftChild() == null) {
                    node.addRightChild(null);
                    return true;
                }
                // Check if node toRemoves right child has a left child
                // if not the replacement node is toRemoves right child
                if (toRemove.getRightChild().getLeftChild() == null){
                    node.addRightChild(toRemove.getRightChild());
                    toRemove.getRightChild().addLeftChild(toRemove.getLeftChild());
                    return true;
                }
                else{
                    // Find parent of node with min value in toRemoves right subtree
                    BinarySearchTreeNode<E> minParent = removeFindMinParent((BinarySearchTreeNode<E>) toRemove.getRightChild());
                    // Node with min value
                    BinarySearchTreeNode<E> min = (BinarySearchTreeNode<E>) minParent.getLeftChild();
                    // Shuffle
                    node.addRightChild(min);
                    minParent.addLeftChild(min.getRightChild());
                    min.addRightChild(toRemove.getRightChild());
                    min.addLeftChild(toRemove.getLeftChild());
                    return true;
                }
            }
            // if element is larger than nodes element
            // recursively remove on nodes right subtree
            if (node.getElement().compareTo(element) < 0) {
                return removeElement(element, (BinarySearchTreeNode<E>) node.getRightChild());
            }
        }
        return false;
    }


    private BinarySearchTreeNode<E> removeFindMaxParent(BinarySearchTreeNode<E> node){
        if (node.getRightChild().getRightChild() == null){
            return node;
        }
        else{
            return removeFindMaxParent((BinarySearchTreeNode<E>) node.getRightChild());
        }
    }

    private BinarySearchTreeNode<E> removeFindMinParent(BinarySearchTreeNode<E> node){
        if (node.getLeftChild().getLeftChild() == null){
            return node;
        }
        else{
            return removeFindMinParent((BinarySearchTreeNode<E>) node.getLeftChild());
        }
    }

    public E findMin(){
        BinarySearchTreeNode<E> root = (BinarySearchTreeNode<E>) super.getRoot();
        if(root == null){
            return null;
        }
        return findMin(root);
    }

    private E findMin(BinarySearchTreeNode<E> node){
        if(node.getLeftChild() == null){
            return node.getElement();
        }
        else{
            return findMin((BinarySearchTreeNode<E>) node.getLeftChild());
        }
    }


    public E findMax(){
        BinarySearchTreeNode<E> root = (BinarySearchTreeNode<E>) super.getRoot();
        if(root == null){
            return null;
        }
        return findMax(root);
    }

    private E findMax(BinarySearchTreeNode<E> node){
        if(node.getRightChild() == null){
            return node.getElement();
        }
        else{
            return findMax((BinarySearchTreeNode<E>) node.getRightChild());
        }
    }

    public boolean contains(E element){

        return contains(element, (BinarySearchTreeNode<E>) super.getRoot());
    }

    private boolean contains(E element, BinarySearchTreeNode<E> node){
        if(node.getElement().equals(element)){
            return true;
        }
        else{
            if(node.getElement().compareTo(element) > 0){
                if(node.getLeftChild() == null){
                    return false;
                }
                else{
                    return contains(element, (BinarySearchTreeNode<E>) node.getLeftChild());
                }
            }
            else{
                if(node.getRightChild() == null){
                    return false;
                }
                else{
                    return contains(element, (BinarySearchTreeNode<E>) node.getRightChild());
                }
            }
        }
    }

    public void rebalance(){
        if (super.getRoot() == null){
            return;
        }
        List<E> sortedArray = this.inOrder();
        super.setRoot(null);
        rebalance(sortedArray);
    }

    private void rebalance(List<E> sortedArray){
        int size = sortedArray.size();
        if (size == 0){
            return;
        }
        if (size == 1){
            insert(sortedArray.get(0));
            return;
        }
        // find median and insert into new tree
        int medianIndex;
        if (size % 2 == 0){
            medianIndex = size / 2 - 1;
        }
        else {
            medianIndex = (int) Math.floor(size / 2.0);
        }
        insert(sortedArray.get(medianIndex));
        // recursively do it on first half of array
        rebalance(sortedArray.subList(0,medianIndex));
        // recursively do it on second half of array
        rebalance(sortedArray.subList(medianIndex+1,size));
    }
}
