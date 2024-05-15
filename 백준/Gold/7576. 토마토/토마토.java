import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Point> queue = new LinkedList<>();
    static int row, column;
    static int[][] box;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(input.readLine());

        column = Integer.parseInt(line.nextToken());
        row = Integer.parseInt(line.nextToken());
        box = new int[row][column];

        for (int i = 0; i < row; i++) {
            line = new StringTokenizer(input.readLine());
            for (int j = 0; j < column; j++) {
                int tomato = Integer.parseInt(line.nextToken());
                box[i][j] = tomato;

                if (tomato == 1) {
                    queue.add(new Point(i, j));
                }
            }
        }

        bfs();
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (!isInRange(nx, ny)) {
                    continue;
                }

                if (box[nx][ny] == 0) {
                    box[nx][ny] = box[current.x][current.y] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        int result = Integer.MIN_VALUE;
        if (!possible()) {
            System.out.println(-1);
            return;
        } else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    result = Math.max(result, box[i][j]);
                }
            }
        }

        System.out.println(result - 1);
    }

    public static boolean possible() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (box[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < column;
    }
}