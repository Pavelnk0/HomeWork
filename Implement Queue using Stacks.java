import java.util.Stack;

class MyQueue {
    private Stack<Integer> input = new Stack<>();
    private Stack<Integer> output = new Stack<>();

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if (output.isEmpty()) {
            transferElements();
        }
        return output.pop();
    }

    public int peek() {
        if (output.isEmpty()) {
            transferElements();
        }
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    private void transferElements() {
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
    }
}
