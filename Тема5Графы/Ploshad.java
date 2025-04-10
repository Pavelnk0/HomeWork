package Тема5Графы;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ploshad {
    static char[][] labyrinth;
    static boolean[][] visited;
    static int N;
    static int area;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine().trim());
        labyrinth = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            labyrinth[i] = reader.readLine().toCharArray();
        }

        String[] coordinates = reader.readLine().split(" ");
        int startRow = Integer.parseInt(coordinates[0]) - 1;
        int startCol = Integer.parseInt(coordinates[1]) - 1;

        area = 0;
        dfs(startRow, startCol);

        System.out.println(area);
    }

    static void dfs(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N || visited[row][col] || labyrinth[row][col] == '*') {
            return;
        }

        visited[row][col] = true;
        area++;

        dfs(row - 1, col);
        dfs(row + 1, col);
        dfs(row, col - 1);
        dfs(row, col + 1);
    }
}
