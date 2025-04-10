package Тема5Графы;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Poisk {
    static int n;
    static int[][] graph;
    static boolean[] visited;
    static int[] parent;
    static List<Integer> cycle;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine().trim());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().trim().split(" ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }

        visited = new boolean[n];
        parent = new int[n];
        cycle = null;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1)) {
                    break;
                }
            }
        }

        if (cycle == null) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            System.out.println(cycle.size());
            for (int vertex : cycle) {
                System.out.print((vertex + 1) + " ");
            }
        }
    }

    static boolean dfs(int current, int par) {
        visited[current] = true;
        parent[current] = par;

        for (int neighbor = 0; neighbor < n; neighbor++) {
            if (graph[current][neighbor] == 1) {
                if (!visited[neighbor]) {
                    if (dfs(neighbor, current)) {
                        return true;
                    }
                } else if (neighbor != par) {
                    cycle = new ArrayList<>();
                    cycle.add(neighbor);
                    int temp = current;
                    while (temp != neighbor) {
                        cycle.add(temp);
                        temp = parent[temp];
                    }
                    cycle.add(neighbor);
                    return true;
                }
            }
        }
        return false;
    }
}
