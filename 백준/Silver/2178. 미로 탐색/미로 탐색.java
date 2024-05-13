import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int row, column;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] board;
    static int[][] visit;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer condition = new StringTokenizer(input.readLine());

        row = Integer.parseInt(condition.nextToken());
        column = Integer.parseInt(condition.nextToken());

        visit = new int[row][column];
        board = new int[row][column];
        for (int i = 0; i < row; i++) {
            String line = input.readLine();
            for (int j = 0; j < column; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        System.out.println(visit[row - 1][column - 1]);
    }

    public static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visit[x][y] = 1;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < row && ny < column) {
                    if (visit[nx][ny] == 0 && board[nx][ny] == 1){
                        visit[nx][ny] = visit[current.x][current.y] + 1;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
    }
}