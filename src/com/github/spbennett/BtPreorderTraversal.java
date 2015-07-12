package com.github.spbennett;

/**
 * Created by sbennett on 7/5/15.
 */
public class BtPreorderTraversal {

    /**
     * Suppose that you are given a binary tree like the one shown in the figure below.
     * Write some code in Java that will do a preorder traversal for any binary tree
     * and print out the nodes as they are encountered. So, for the binary tree in the
     * figure below, the algorithm will print the nodes in this order:
     * 2, 7, 2, 6, 5, 11, 5, 9, 4
     */

    public static void main (String args[]){
        BtPreorderTraversal bt = new BtPreorderTraversal();
        Node root = bt.setup();

        System.out.println("Preorder Traversal:");
        bt.preorderTraversal(root);
        System.out.println("");

        System.out.println("Inorder Traversal:");
        bt.inorderTraversal(root);
        System.out.println("");
    }

    private void preorderTraversal(Node n){
        if (n == null)
            return;
        /*
        Print value of self, the traverse left and print until null,
        then traverse right and print until null.
         */
        System.out.print(n.value + " ");
        if (n.left != null)
            preorderTraversal(n.left);
        if (n.right != null)
            preorderTraversal(n.right);
    }

    private void inorderTraversal(Node n){
        if (n == null)
            return;
        /*
        Traverse left until null then print up the stack,
        then traverse right until null and print up the stack.
        */

        if (n.left != null)
            preorderTraversal(n.left);
            System.out.print(n.value + " ");
        if (n.right != null)
            preorderTraversal(n.right);
            System.out.print(n.value + " ");
    }

    private Node setup(){
        Node root = new Node(2);
        root.left = new Node(7);
        root.right = new Node(5);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(11);
        root.right.right = new Node(9);
        root.right.right.left = new Node(4);
        return root;
    }

    /**
     * Helper class to represent tree nodes.
     */
    private class Node {
        Node left;
        Node right;
        int value;

        Node (int val){
            this.value = val;
            this.left = null;
            this.right = null;
        }
    }
}
