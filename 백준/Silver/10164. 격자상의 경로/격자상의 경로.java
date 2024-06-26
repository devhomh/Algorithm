import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int row, column, circle;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer condition = new StringTokenizer(input.readLine());
        row = Integer.parseInt(condition.nextToken());
        column = Integer.parseInt(condition.nextToken());
        circle = Integer.parseInt(condition.nextToken());

        int result = circle == 0 || isStartOrEnd()
                ? bfs(new Point(0, 0), new Point(row - 1 , column - 1))
                : bfs(new Point(0, 0), getMark()) * bfs(getMark(), new Point(row - 1, column - 1));

        System.out.println(result);
    }

    public static int bfs(Point start, Point end) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);

        int count = 0;
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 2; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx == end.x && ny == end.y) {
                    count++;
                    continue;
                }

                if (nx <= end.x && ny <= end.y) {
                    queue.offer(new Point(nx, ny));
                }
            }
        }

        return count;
    }

    public static Point getMark() {
        int x = circle % column == 0 ? circle / column - 1 : circle / column;
        int y = circle % column == 0 ? column - 1 : circle % column - 1;

        return new Point(x, y);
    }

    public static boolean isStartOrEnd() {
        return getMark().distance(0, 0) == 0 || getMark().distance(row - 1, column - 1) == 0;
    }

}