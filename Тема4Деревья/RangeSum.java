package Тема4Деревья;

import java.util.Stack;

class RangeSum {
    int val;
    TreeNode left, right;

    RangeSum(int item) {
        val = item;
        left = right = null;
    }
}

public class RangeSum1 {
    public int rangeSumBST(RangeSum root, int L, int R) {
        if (root == null) return 0;

        Stack<RangeSum> stk = new Stack<>();
        stk.push(root);
        int sum = 0;

        while (!stk.isEmpty()) {
            RangeSum n = stk.pop();

            if (n == null) {
                continue;
            }

            if (L <= n.val && n.val <= R) {
                sum += n.val;
            }

            if (n.val > L) {
                stk.push(n.left);
            }
            if (n.val < R) {
                stk.push(n.right);
            }
        }
        return sum;
    }
}
