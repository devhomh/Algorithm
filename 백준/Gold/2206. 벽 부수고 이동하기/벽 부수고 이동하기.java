import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class PointInfo {
        int row;
        int column;
        boolean destroyed;

        public PointInfo(int row, int column, boolean destroyed) {
            this.row = row;
            this.column = column;
            this.destroyed = destroyed;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int row, column;
    static int[][] map;
    static int[][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer condition = new StringTokenizer(input.readLine());
        row = Integer.parseInt(condition.nextToken());
        column = Integer.parseInt(condition.nextToken());
        map = new int[row + 1][column + 1];
        visit = new int[row + 1][column + 1][2];

        for (int i = 1; i <= row; i++) {
            String line = input.readLine();
            for (int j = 1; j <= column; j++) {
                map[i][j] = line.charAt(j - 1) - '0';
            }
        }

        if (row == 1 && column == 1) {
            System.out.println(1);
            return;
        }

        bfs(1, 1);

        System.out.println(visit[row][column][0] == 0 ? -1 : visit[row][column][0]);
    }

    public static void bfs(int x, int y) {
        Queue<PointInfo> queue = new LinkedList<>();
        queue.add(new PointInfo(x, y, false));
        visit[x][y][0] = 1;

        while (!queue.isEmpty()) {
            PointInfo current = queue.poll();

            if (current.row == row && current.column == column) {
                visit[row][column][0] = current.destroyed
                        ? visit[current.row][current.column][0]
                        : visit[current.row][current.column][1];

                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.row + dx[i];
                int ny = current.column + dy[i];

                if (!isInRange(nx, ny)) {
                    continue;
                }

                if (nx == row && ny == column) {
                    visit[nx][ny][0] = current.destroyed
                            ? visit[current.row][current.column][1] + 1
                            : visit[current.row][current.column][0] + 1;
                    return;
                }

                if (map[nx][ny] == 1) {
                    if (!current.destroyed && visit[nx][ny][1] == 0) {
                        visit[nx][ny][1] = visit[current.row][current.column][0] + 1;
                        queue.add(new PointInfo(nx, ny, true));
                    }
                } else {
                    if (current.destroyed && visit[nx][ny][1] == 0) {
                        visit[nx][ny][1] = visit[current.row][current.column][1] + 1;
                        queue.add(new PointInfo(nx, ny, true));
                    } else if (!current.destroyed && visit[nx][ny][0] == 0){
                        visit[nx][ny][0] = visit[current.row][current.column][0] + 1;
                        queue.add(new PointInfo(nx, ny, false));
                    }
                }
            }
        }

    }

    public static boolean isInRange(int x, int y) {
        return x >= 1 && y >= 1 && x <= row && y <= column;
    }
}