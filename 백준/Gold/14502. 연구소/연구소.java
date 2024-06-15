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
    static int row, column;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(input.readLine());
        row = Integer.parseInt(line.nextToken());
        column = Integer.parseInt(line.nextToken());
        int[][] map = new int[row][column];
        for (int i = 0; i < row; i++) {
            line = new StringTokenizer(input.readLine());
            for (int j = 0; j < column; j++) {
                map[i][j] = Integer.parseInt(line.nextToken());
            }
        }

        buildWall(0, map);

        System.out.println(result);
    }

    public static void buildWall(int count, int[][] map) {
        if (count == 3) {
            result = Math.max(result, calculate(map));
            return;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(count + 1, map);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static int calculate(int[][] map) {
        int[][] clone = new int[row][column];
        for (int i = 0; i < row; i++) {
            clone[i] = map[i].clone();
        }

        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (clone[i][j] == 2) {
                    queue.add(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = current.x + dx[i];
                int nextColumn= current.y + dy[i];

                if (isInRange(nextRow, nextColumn) && clone[nextRow][nextColumn] == 0) {
                    clone[nextRow][nextColumn] = 2;
                    queue.add(new Point(nextRow, nextColumn));
                }
            }
        }

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (clone[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }



    public static boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < column;
    }
}