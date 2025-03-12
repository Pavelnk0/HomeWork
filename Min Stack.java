class MinStack {
    private Node head;

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }

    public int top() {
        return head != null ? head.val : -1;
    }

    public int getMin() {
        return head != null ? head.min : -1;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this.val = val;
            this.min = min;
            this.next = null;
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
