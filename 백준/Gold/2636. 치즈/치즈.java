import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int row, column, total;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(input.readLine());
        row = Integer.parseInt(line.nextToken());
        column = Integer.parseInt(line.nextToken());
        board = new int[row][column];
        for (int i = 0; i < row; i++) {
            line = new StringTokenizer(input.readLine());
            for (int j = 0; j < column; j++) {
                int cheese = Integer.parseInt(line.nextToken());
                if (cheese == 1) {
                    total++;
                }
                board[i][j] = cheese;
            }
        }

        int hour = 0;
        int remain = 0;
        while (total != 0) {
            remain = total;
            bfs(0, 0);
            hour++;
        }

        System.out.println(hour);
        System.out.println(remain);
    }

    public static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[row][column];
        queue.add(new Point(x, y));
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (isInRange(nx, ny) && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    if (board[nx][ny] == 0) {
                        queue.add(new Point(nx, ny));
                    } else {
                        total--;
                        board[nx][ny] = 0;
                    }
                }
            }
        }
    }

    public static boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < column;
    }
}