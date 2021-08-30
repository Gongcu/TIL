import java.util.*;

public class BinaryTree {
    Node root;
    int size = 0;

    void add(int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }
        Node prev = null, curr = root;
        while (curr != null) {
            prev = curr;

            if (curr.key == key) {
                return;
            }

            if (curr.key < key)
                curr = curr.right;
            else
                curr = curr.left;
        }

        if (prev.key < key)
            prev.right = new Node(key);
        else
            prev.left = new Node(key);
    }

    void remove(int key) {
        Node prev = null, curr = root;

        while (curr != null) {
            if (curr.key == key) // 찾으면 prev가 curr과 달라야 하기 때문에 prev=curr이 아래에 존재
                break;

            prev = curr;

            if (curr.key < key)
                curr = curr.right;
            else
                curr = curr.left;
        }

        if (curr == null)
            return;

        if (curr.left != null && curr.right != null) {
            Node min = curr.right, minParent = curr;
            while (min.left != null) {
                minParent = min;
                min = min.left;
            }

            curr.key = min.key;

            if (curr == minParent) {
                curr.right = min.right;
            } else {
                minParent.left = min.right;
            }

        } else if (curr.left == null && curr.right == null) {
            if (curr == root) {
                root = null;
                return;
            }

            if (prev.left == curr) {
                prev.left = null;
            } else {
                prev.right = null;
            }
        } else {
            if (curr == root) {
                if (curr.left == null) {
                    root = curr.right;
                } else {
                    root = curr.left;
                }
            } else {
                if (prev.left == curr) {
                    if (curr.left != null) {
                        prev.left = curr.left;
                    } else {
                        prev.left = curr.right;
                    }
                } else {
                    if (curr.left != null) {
                        prev.right = curr.left;
                    } else {
                        prev.right = curr.right;
                    }
                }
            }
        }
    }

    void printPreOrder(Node root) {
        if (root != null) {
            System.out.println(root.key);
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
    }


    public class Node{
        int key;
        Node left, right;
        Node(int key){
            this.key = key;
        }
    }
}
