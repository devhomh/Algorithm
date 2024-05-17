import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int row, column, num;
    static boolean[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(input.readLine());
        row = Integer.parseInt(line.nextToken());
        column = Integer.parseInt(line.nextToken());
        num = Integer.parseInt(line.nextToken());

        board = new boolean[row][column];
        for (int i = 0; i < num; i++) {
            fillSquare(new StringTokenizer(input.readLine()));
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (!board[i][j]) {
                    list.add(bfs(i, j));
                }
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(list.size()).append("\n");
        list.stream()
                .sorted()
                .forEach(element -> result.append(element).append(" "));
        System.out.println(result);
    }

    public static int bfs(int x, int y) {
        int count = 1;
        boolean[][] visit = new boolean[row][column];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visit[x][y] = true;
        board[x][y] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                // 범위 밖으로 벗어나면 스킵
                if (!isInRange(nx, ny)) {
                    continue;
                }

                // 방문하지 않았을 때
                if (!visit[nx][ny]) {
                    // 방문 체크
                    visit[nx][ny] = true;
                    // 채워지지 않았을 때 전체 카운트에서 -1, 그룹 카운트 + 1 하고 채움
                    if (!board[nx][ny]) {
                        board[nx][ny] = true;
                        count++;
                        queue.add(new Point(nx, ny));
                    }
                }

            }
        }

        return count;
    }

    public static boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < column;
    }

    public static void fillSquare(StringTokenizer line) {
        int x = Integer.parseInt(line.nextToken());
        int y = Integer.parseInt(line.nextToken());
        int dx = Integer.parseInt(line.nextToken());
        int dy = Integer.parseInt(line.nextToken());

        for (int i = x; i < dx; i++) {
            for (int j = y; j < dy; j++) {
                board[j][i] = true;
            }
        }
    }
}