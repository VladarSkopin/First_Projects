package BinaryTrees;

public class BST <E extends Comparable<E>> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }


    public BST(E[] objects) {
        //enhanced for loop
        for (E object : objects) insert(object);
    }


    public static class TreeNode<E extends Comparable<E>> {
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }



    public boolean search(E e) {
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }



    public boolean insert(E e) {
        if (root == null) {
            root = createNewNode(e);
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false;
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true;
    }



public boolean delete(E e) {
        //locate the node and its parent
    TreeNode<E> parent = null;
    TreeNode<E> current = root;
    while (current != null) {
        if (e.compareTo(current.element) < 0) {
            parent = current;
            current = current.left;
        } else if (e.compareTo(current.element) > 0) {
            parent = current;
            current = current.right;
        } else break; //element is in the tree pointed at by current

        if (current == null)
            return false; //element is not in the tree
        //case1: current has no left child
        if (current.left == null) {
            //connect the parent with the right child of the current node
            if (parent == null) {
                root = current.right;
            } else {
                if (e.compareTo(parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        } else {
            //case 2: teh current node has a left child.
            //Locate the rightmost node in the left subtree of the current node and also its parent
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }
            //replace the element in current by the element in rightMost
            current.element = rightMost.element;
            //eliminate rightmost node
            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                //special case: parentOfRightMost == current
            parentOfRightMost.left = rightMost.left;
        }
    }
    size --;
    return true;
}





    public int getSize() {
        return size;
    }

    public TreeNode<E> getRoot() {
        return root;
    }

    public void clear() {
        root = null;
        size = 0;
    }

}