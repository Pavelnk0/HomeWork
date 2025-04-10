package Тема4Деревья;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class GlubinaDobav {
    int value;
    TreeNode left, right;

    GlubinaDobav(int item) {
        value = item;
        left = right = null;
    }
}

public class GlubinaDobav1 {
    GlubinaDobav root;

    int insert(int value) {
        return insertRec(root, value, 1);
    }

    private int insertRec(GlubinaDobav node, int value, int depth) {
        if (node == null) {
            root = new GlubinaDobav(value);
            return depth;
        }
        if (value < node.value) {
            if (node.left == null) {
                node.left = new GlubinaDobav(value);
                return depth + 1;
            } else {
                return insertRec(node.left, value, depth + 1);
            }
        } else if (value > node.value) {
            if (node.right == null) {
                node.right = new GlubinaDobav(value);
                return depth + 1;
            } else {
                return insertRec(node.right, value, depth + 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        BinarySearchTree bst = new BinarySearchTree();

        String line;
        StringBuilder output = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            String[] numbers = line.split(" ");
            for (String num : numbers) {
                int value = Integer.parseInt(num);
                if (value == 0) {
                    break;
                }
                int depth = bst.insert(value);
                if (depth != -1) {
                    output.append(depth).append(" ");
                }
            }
            break;
        }

        writer.write(output.toString().trim());
        writer.newLine();

        reader.close();
        writer.close();
    }
}