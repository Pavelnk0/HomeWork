package Тема4Деревья;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class VivodRazvil {
    int value;
    TreeNode left, right;

    VivodRazvil(int item) {
        value = item;
        left = right = null;
    }
}

public class VivodRazvil1 {
    VivodRazvil root;

    void insert(int value) {
        root = insertRec(root, value);
    }

    private VivodRazvil insertRec(VivodRazvil node, int value) {
        if (node == null) {
            return new VivodRazvil(value);
        }
        if (value < node.value) {
            node.left = insertRec(node.left, value);
        } else if (value > node.value) {
            node.right = insertRec(node.right, value);
        }
        return node;
    }

    void getNodesWithTwoChildren(VivodRazvil node, List<Integer> nodes) {
        if (node != null) {
            if (node.left != null && node.right != null) {
                nodes.add(node.value);
            }
            getNodesWithTwoChildren(node.left, nodes);
            getNodesWithTwoChildren(node.right, nodes);
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

        List<Integer> nodesWithTwoChildren = new ArrayList<>();
        bst.getNodesWithTwoChildren(bst.root, nodesWithTwoChildren);

        Collections.sort(nodesWithTwoChildren);

        for (int node : nodesWithTwoChildren) {
            writer.write(node + "\n");
        }
        reader.close();
        writer.close();
    }
}