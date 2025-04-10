package Тема5Графы;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class KomponSvyaz {
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            input = reader.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[N + 1];
        List<List<Integer>> components = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, component);
                components.add(component);
            }
        }

        writer.write(components.size() + "\n");
        for (List<Integer> component : components) {
            writer.write(component.size() + "\n");
            for (int vertex : component) {
                writer.write(vertex + " ");
            }
            writer.write("\n");
        }

        reader.close();
        writer.close();
    }

    static void dfs(int vertex, List<Integer> component) {
        visited[vertex] = true;
        component.add(vertex);
        for (int neighbor : graph.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, component);
            }
        }
    }
}
