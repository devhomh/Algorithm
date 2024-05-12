import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int vertexNum;
    static int[][] board;
    static boolean[] visit;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line;
        line = new StringTokenizer(input.readLine());
        vertexNum = Integer.parseInt(line.nextToken());
        int edgeNum = Integer.parseInt(line.nextToken());
        int vertexIdx = Integer.parseInt(line.nextToken());
        board = new int[vertexNum + 1][vertexNum + 1];
        visit = new boolean[vertexNum + 1];

        for (int i = 0; i < edgeNum; i++) {
            line = new StringTokenizer(input.readLine());
            int x = Integer.parseInt(line.nextToken());
            int y = Integer.parseInt(line.nextToken());

            board[x][y] = board[y][x] = 1;
        }

        dfs(0, vertexIdx);
        Arrays.fill(visit, false);
        result.append("\n");
        bfs(vertexIdx);

        System.out.println(result);
    }

    public static void dfs(int depth, int start) {
        if (depth == vertexNum) {
            return;
        }

        result.append(start).append(" ");
        visit[start] = true;
        for (int i = 1; i <= vertexNum; i++) {
            if (board[start][i] == 1 && !visit[i]) {
                dfs(depth + 1, i);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            start = queue.poll();
            result.append(start).append(" ");

            for (int i = 1; i <= vertexNum; i++) {
                if (board[start][i] == 1 && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}