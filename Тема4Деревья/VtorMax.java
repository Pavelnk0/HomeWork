package Тема4Деревья;

import java.util.*;

class VtorMax {
    int value;
    TreeNode left, right;

    VtorMax(int item) {
        value = item;
        left = right = null;
    }
}

public class SecondMaxInBST {
    VtorMax root;

    void insert(int value) {
        root = insertRec(root, value);
    }

    TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    int findSecondMax() {
        return findSecondMaxUtil(root);
    }

    int findSecondMaxUtil(VtorMax node) {
        if (node == null) {
            throw new NoSuchElementException("Дерево пустое");
        }

        VtorMax parent = null;
        VtorMax current = node;

        while (current.right != null) {
            parent = current;
            current = current.right;
        }

        if (current.left != null) {
            current = current.left;
            while (current.right != null) {
                current = current.right;
            }
            return current.value;
        }

        if (parent != null) {
            return parent.value;
        }

        throw new NoSuchElementException("Не удалось найти второй по величине элемент");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecondMaxInBST tree = new SecondMaxInBST();

        while (true) {
            int value = scanner.nextInt();
            if (value == 0) {
                break;
            }
            tree.insert(value);
        }

        int secondMax = tree.findSecondMax();
        System.out.println(secondMax);
    }
}
