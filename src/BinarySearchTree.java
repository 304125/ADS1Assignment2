import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {
    private BinarySearchTreeNode<E> root;

    public BinarySearchTree(BinarySearchTreeNode<E> root) {
        super(root);
        this.root = root;
    }

    public BinarySearchTreeNode<E> getRoot(){
        return root;
    }

    public boolean insert(E element){
        if (root  == null){
            root = new BinarySearchTreeNode<>(element);
            return true;
        }
        return insert(element, root);
    }

    private boolean insert(E element, BinarySearchTreeNode<E> node){
        int comparison = node.getElement().compareTo(element);
        if(comparison == 0){
            return false;
        }
        else if(comparison < 0){
            if(node.getRightChild() != null){
                return insert(element, node.getRightChild());
            }
            else{
                node.addRightChild(new BinarySearchTreeNode<>(element));
                return true;
            }
        }
        else{
            if(node.getLeftChild() != null){
                return insert(element, node.getLeftChild());
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
        if (root.getElement().equals(element)){
            // If root has left child do following
            if (root.getLeftChild() != null){
                // If roots left child has no right child use that as a replacement root
                if (root.getLeftChild().getRightChild() == null){
                    root.getLeftChild().addRightChild(root.getRightChild());
                    root = root.getLeftChild();
                    return true;
                }
                else{
                    // Find the parent of the node containing the highest element in roots left subtree
                    BinarySearchTreeNode<E> maxParent = removeFindMaxParent(root.getLeftChild());
                    BinarySearchTreeNode<E> tmpRoot = root;
                    // Node with highest value gets set to root
                    root = maxParent.getRightChild();
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
                    root = root.getRightChild();
                    return true;
                }
                else{
                    // Find the parent of the node containing the lowest element in roots right subtree
                    BinarySearchTreeNode<E> minParent = removeFindMinParent(root.getRightChild());
                    BinarySearchTreeNode<E> tmpRoot = root;
                    // Node with lowest value gets set to root
                    root = minParent.getLeftChild();
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
                BinarySearchTreeNode<E> toRemove = node.getLeftChild();
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
                    BinarySearchTreeNode<E> maxParent = removeFindMaxParent(toRemove.getLeftChild());
                    // Node with max value
                    BinarySearchTreeNode<E> max = maxParent.getRightChild();
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
                return removeElement(element, node.getLeftChild());
            }
        }
        // Check if node has right child
        if (node.getRightChild() != null) {
            // Check if right child contains the element
            if (node.getRightChild().getElement().equals(element)) {
                // Node that needs to be removed
                BinarySearchTreeNode<E> toRemove = node.getRightChild();
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
                    BinarySearchTreeNode<E> minParent = removeFindMinParent(toRemove.getRightChild());
                    // Node with min value
                    BinarySearchTreeNode<E> min = minParent.getLeftChild();
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
                return removeElement(element, node.getRightChild());
            }
        }
        return false;
    }


    private BinarySearchTreeNode<E> removeFindMaxParent(BinarySearchTreeNode<E> node){
        if (node.getRightChild().getRightChild() == null){
            return node;
        }
        else{
            return removeFindMaxParent(node.getRightChild());
        }
    }

    private BinarySearchTreeNode<E> removeFindMinParent(BinarySearchTreeNode<E> node){
        if (node.getLeftChild().getLeftChild() == null){
            return node;
        }
        else{
            return removeFindMinParent(node.getLeftChild());
        }
    }

    public E findMin(){
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
            return findMin(node.getLeftChild());
        }
    }


    public E findMax(){
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
            return findMax(node.getRightChild());
        }
    }

    public boolean contains(E element){
        return contains(element, root);
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
                    return contains(element, node.getLeftChild());
                }
            }
            else{
                if(node.getRightChild() == null){
                    return false;
                }
                else{
                    return contains(element, node.getRightChild());
                }
            }
        }
    }

    public void rebalance(){
        if (root == null){
            return;
        }
        List<E> sortedArray = this.inOrder();
        root=null;
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
