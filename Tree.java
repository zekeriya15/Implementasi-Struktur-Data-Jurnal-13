public class Tree<E extends Comparable<E>> {
    private TreeNode<E> root;


    // constructor initializes an empty tree of integers
    public Tree() {
        root = null;
    }


    // insert a new node into the binary search tree
    public void insertNode(E insertValue) {
        System.out.print(insertValue + " ");      // additional method
        if (root == null) {
            root = new TreeNode<E>(insertValue);    // create root node
            // System.out.print(insertValue + " ");      // ilave method | if it is put in this if statement it will print only the first element inserted why? cuz the second element goes to else
        } else {
            root.insert(insertValue);
            // System.out.print(insertValue + " ");
        }
    }

    // =================================================================================================

    // recursive method to perform preorder traversal
    private void preorderHelper(TreeNode<E> node) {
        if (node == null) {
            return;     // exit the method
        }

        System.out.printf("%s ", node.getData());   // output node data
        preorderHelper(node.getLeftNode());     // traverse left subtree
        preorderHelper(node.getRightNode());    // traverse right subtree
    }

    // begin preorder traversal
    public void preorderTraversal() {
        preorderHelper(root);
    }

    // =================================================================================================

    // recursive method to perform inorder traversal
    private void inorderHelper(TreeNode<E> node) {
        if (node == null) {
            return;
        }

        inorderHelper(node.getLeftNode());      // traverse left subtree
        System.out.printf("%s ", node.getData());       // output node data
        inorderHelper(node.getRightNode());     // traverse right subtree
    }

    // begin inorder traversal
    public void inorderTraversal() {
        inorderHelper(root);
    }

    // =================================================================================================
   
    // recursive method to perform postorder traversal
    private void postorderHelper(TreeNode<E> node) {
        if (node == null) {
            return;
        }

        postorderHelper(node.getLeftNode());    // traverse left subtree
        postorderHelper(node.getRightNode());   // traverse right subtree
        System.out.printf("%s ", node.getData());       // output node data
    }

    // begin postorder traversal
    public void postorderTraversal() {
        postorderHelper(root);
    }

    // =================================================================================================


    // carrano
    private boolean searchBSTHelper(TreeNode<E> node, E key) {
        boolean result = false;

        if (node != null) {
            if (key.equals(node.getData())) {
                result = true;
            } else if (key.compareTo(node.getData()) < 0) {
                result = searchBSTHelper(node.getLeftNode(), key);
            } else {
                result = searchBSTHelper(node.getRightNode(), key);
            }
        }
        return result;
    }

    public void searchBST(E key) {
        boolean hasil = searchBSTHelper(root, key);

        if (hasil) {
            System.out.println("Data " + key + " ditemukan pada tree");
        } else {
            System.out.println("Data "+ key + " tidak ditemukan pada tree");
        }
    }


}
