import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
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

        BinaryTreePrint btp = new BinaryTreePrint();
        btp.printTree(nodes.get(0));
    }
}
