package Тема4Деревья;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    private TreeNode root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    public List<Integer> inOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        inOrderRec(root, result);
        return result;
    }

    private void inOrderRec(TreeNode root, List<Integer> result) {
        if (root != null) {
            inOrderRec(root.left, result);
            result.add(root.value);
            inOrderRec(root.right, result);
        }
    }
}

public class BSTOutput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        int number;
        while ((number = scanner.nextInt()) != 0) {
            bst.insert(number);
        }

        List<Integer> sortedElements = bst.inOrderTraversal();
        for (int val : sortedElements) {
            System.out.println(val);
        }
    }
}