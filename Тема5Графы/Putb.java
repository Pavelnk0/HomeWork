package Тема5Графы;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Putb {
    static int N;
    static int[][] graph;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine().trim());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = reader.readLine().trim().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }

        String[] input = reader.readLine().trim().split(" ");
        int start = Integer.parseInt(input[0]) - 1;
        int end = Integer.parseInt(input[1]) - 1;

        visited = new boolean[N];
        parent = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = -1;
        }

        if (bfs(start, end)) {
            List<Integer> path = new ArrayList<>();
            int current = end;

            while (current != -1) {
                path.add(current + 1);
                current = parent[current];
            }

            StringBuilder result = new StringBuilder();
            result.append(path.size() - 1).append("\n");
            for (int i = path.size() - 1; i >= 0; i--) {
                result.append(path.get(i)).append(" ");
            }
            System.out.println(result.toString().trim());
        } else {
            System.out.println(-1);
        }
    }

    static boolean bfs(int start, int end) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) {
                return true;
            }

            for (int i = 0; i < N; i++) {
                if (graph[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    parent[i] = current;
                    queue.offer(i);
                }
            }
        }
        return false;
    }
}
