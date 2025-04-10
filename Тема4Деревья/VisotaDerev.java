package Тема4Деревья;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class VisotaDerev {
    int value;
    TreeNode left, right;

    VisotaDerev(int item) {
        value = item;
        left = right = null;
    }
}

public class BinarySearchTree {
    VisotaDerev root;

    void insert(int value) {
        root = insertRec(root, value);
    }

    VisotaDerev insertRec(VisotaDerev root, int value) {
        if (root == null) {
            return new VisotaDerev(value);
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    int height(VisotaDerev node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        BinarySearchTree bst = new BinarySearchTree();

        while (true) {
            int value = Integer.parseInt(reader.readLine());
            if (value == 0) {
                break;
            }
            bst.insert(value);
        }

        int treeHeight = bst.height(bst.root);
        writer.write(String.valueOf(treeHeight));
        writer.newLine();

        reader.close();
        writer.close();
    }
}
