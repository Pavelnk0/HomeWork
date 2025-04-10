package Тема4Деревья;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class VivodList {
    int value;
    TreeNode left, right;

    VivodList(int item) {
        value = item;
        left = right = null;
    }
}

public class VivodList1 {
    VivodList root;

    void insert(int value) {
        root = insertRec(root, value);
    }

    private VivodList insertRec(VivodList node, int value) {
        if (node == null) {
            return new VivodList(value);
        }
        if (value < node.value) {
            node.left = insertRec(node.left, value);
        } else if (value > node.value) {
            node.right = insertRec(node.right, value);
        }
        return node;
    }

    void getLeaves(VivodList node, List<Integer> leaves) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                leaves.add(node.value);
            }
            getLeaves(node.left, leaves);
            getLeaves(node.right, leaves);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        BinarySearchTree bst = new BinarySearchTree();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] numbers = line.split(" ");
            for (String num : numbers) {
                int value = Integer.parseInt(num);
                if (value == 0) {
                    break;
                }
                bst.insert(value);
            }
            break;
        }

        List<Integer> leaves = new ArrayList<>();
        bst.getLeaves(bst.root, leaves);

        Collections.sort(leaves);

        for (int leaf : leaves) {
            writer.write(leaf + "\n");
        }

        reader.close();
        writer.close();
    }
}