public class TreeNode<E extends Comparable<E>> {
    private TreeNode<E> leftNode;
    private E data;                 // node value
    private TreeNode<E> rightNode;


    // constructor initializes data and makes this a leaf node
    public TreeNode(E nodeData) {
        data = nodeData;
        leftNode = rightNode = null;    // node has no children
    }

    public E getData() {
        return data;
    }

    public TreeNode<E> getLeftNode() {
        return leftNode;
    }

    public TreeNode<E> getRightNode() {
        return rightNode;
    }


    // locate insertion point and insert new node; ignore duplicate values
    public void insert(E insertValue) {
        // insert in left subtree
        if (insertValue.compareTo(data) < 0) {
            // insert new TreeNode
            if (leftNode == null) {
                leftNode = new TreeNode<E>(insertValue);
            } else {
                leftNode.insert(insertValue);   // continue traversing left subtree recursively
            }
        }
        // insert in right subtree
        else if (insertValue.compareTo(data) > 0) {
            // insert new TreeNode
            if (rightNode == null) {
                rightNode = new TreeNode<E>(insertValue);
            } else {
                rightNode.insert(insertValue);  // continue traversing right subtree recursively
            }
        }
        // else if (insertValue.compareTo(data) == 0) {
        //     // insert new TreeNode
        //     if (leftNode == null) {
        //         leftNode = new TreeNode<E>(insertValue);
        //     } else {
        //         leftNode.insert(insertValue);   // continue traversing left subtree recursively
        //     }
        // }
        else {      // eklenecek nodeun değeri root'unkiyle aynıysa sola gönder
            // insert new TreeNode
            if (leftNode == null) {
                leftNode = new TreeNode<E>(insertValue);
            } else {
                leftNode.insert(insertValue);   // continue traversing left subtree recursively
            }
        }
    }

    @Override
    public String toString() {
        return "TreeNode [leftNode=" + leftNode + ", data=" + data + ", rightNode=" + rightNode + "]";
    }

    
    
}
