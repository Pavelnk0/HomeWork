import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class TrainSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Deque<Integer> stack = new ArrayDeque<>();
        int[] train = new int[N];

        for (int i = 0; i < N; i++) {
            train[i] = scanner.nextInt();
        }

        int expected = 1;

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek() == expected) {
                stack.pop();
                expected++;
            }
            stack.push(train[i]);

            while (!stack.isEmpty() && stack.peek() == expected) {
                stack.pop();
                expected++;
            }
        }

        while (!stack.isEmpty() && stack.peek() == expected) {
            stack.pop();
            expected++;
        }

        if (expected == N + 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }
}
