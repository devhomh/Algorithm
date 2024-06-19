import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static class Camera {
        int row;
        int column;
        int type;

        public Camera(int row, int column, int type) {
            this.row = row;
            this.column = column;
            this.type = type;
        }
    }
    static int row, column;
    static int result = Integer.MAX_VALUE;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static List<Camera> cameras = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(input.readLine());
        row = Integer.parseInt(line.nextToken());
        column = Integer.parseInt(line.nextToken());
        map = new int[row][column];
        for (int i = 0; i < row; i++) {
            line = new StringTokenizer(input.readLine());
            for (int j = 0; j < column; j++) {
                int num = Integer.parseInt(line.nextToken());
                map[i][j] = num;
                if (num >= 1 && num <= 5) {
                    cameras.add(new Camera(i, j, num));
                }
            }
        }

        dfs(0, new int[cameras.size()]);

        System.out.println(result);
    }

    public static void dfs(int depth, int[] dirs) {
        if (depth == cameras.size()) {
            result = Math.min(result, count(dirs));
            return;
        }

        Camera camera = cameras.get(depth);
        int type = camera.type;
        if (type == 2) {
            for (int i = 0; i < 2; i++) {
                dirs[depth] = i;
                dfs(depth + 1, dirs);
            }
        } else if (type == 5) {
            dfs(depth + 1, dirs);
        } else {
            for (int i = 0; i < 4; i++) {
                dirs[depth] = i;
                dfs(depth + 1, dirs);
            }
        }
    }

    public static int count(int[] dirs) {
        boolean[][] watched = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (map[i][j] == 6) {
                    watched[i][j] = true;
                }
            }
        }

        for (int i = 0; i < dirs.length; i++) {
            int dir = dirs[i];
            Camera camera = cameras.get(i);
            switch (camera.type) {
                case 1 :
                    bfs(camera.row, camera.column, dir, watched);
                    break;
                case 2 :
                    if (dir % 2 == 0) {
                        bfs(camera.row, camera.column, 0, watched);
                        bfs(camera.row, camera.column, 2, watched);
                    } else {
                        bfs(camera.row, camera.column, 1, watched);
                        bfs(camera.row, camera.column, 3, watched);
                    }

                    break;
                case 3 :
                    bfs(camera.row, camera.column, dir, watched);
                    bfs(camera.row, camera.column, (dir + 1) % 4, watched);
                    break;
                case 4 :
                    for (int j = 0; j < 4; j++) {
                        if (j != dir) {
                            bfs(camera.row, camera.column, j, watched);
                        }
                    }

                    break;
                case 5 :
                    for (int j = 0; j < 4; j++) {
                        bfs(camera.row, camera.column, j, watched);
                    }
            }
        }

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (!watched[i][j]){
                    count++;
                }
            }
        }

        return count;
    }

    public static void bfs(int x, int y, int dir, boolean[][] watched) {
        watched[x][y] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int nextRow = current.x + dx[dir];
            int nextColumn = current.y + dy[dir];

            if (!isInRange(nextRow, nextColumn)) {
                continue;
            }

            watched[nextRow][nextColumn] = true;
            if (map[nextRow][nextColumn] != 6) {
                queue.add(new Point(nextRow, nextColumn));
            }
        }
    }

    public static boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < column;
    }
}