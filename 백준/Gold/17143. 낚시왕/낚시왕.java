import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static class Shark {
        int speed;
        int dir;
        int size;
        public Shark(int speed, int dir, int size) {
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }

        public Point move(int x, int y) {
            int nextRow = x;
            int nextColumn = y;
            int cycle;
            if (dir == 0 || dir == 1) {
                cycle = (row - 1) * 2;
            } else {
                cycle = (column - 1) * 2;
            }

            int distance = speed % cycle;
            while (distance != 0) {
                if (!isInRange(nextRow + dx[dir], nextColumn + dy[dir])) {
                    dir = change(dir);
                }

                nextRow += dx[dir];
                nextColumn += dy[dir];
                distance--;
            }

            return new Point(nextRow, nextColumn);
        }

    }
    static StringTokenizer line;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int row, column;
    static Shark[][] field;
    static Map<Point, Shark> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        line = new StringTokenizer(input.readLine());
        row = Integer.parseInt(line.nextToken());
        column = Integer.parseInt(line.nextToken());
        int num = Integer.parseInt(line.nextToken());

        field = new Shark[row + 1][column + 1];
        for (int i = 0; i < num; i++) {
            line = new StringTokenizer(input.readLine());
            int tmpRow = Integer.parseInt(line.nextToken());
            int tmpColumn = Integer.parseInt(line.nextToken());
            int speed = Integer.parseInt(line.nextToken());
            int dir = Integer.parseInt(line.nextToken()) - 1;
            int size = Integer.parseInt(line.nextToken());
            field[tmpRow][tmpColumn] = new Shark(speed, dir, size);
        }

        int result = 0;
        for (int i = 1; i <= column; i++) {
            for (int j = 1; j <= row; j++) {
                if (field[j][i] != null) {
                    result += field[j][i].size;
                    field[j][i] = null;
                    break;
                }
            }

            map.clear();
            for (int j = 1; j <= row; j++) {
                for (int k = 1; k <= column; k++) {
                    if (field[j][k] != null) {
                        Shark shark = field[j][k];
                        field[j][k] = null;
                        Point next = shark.move(j, k);
                        map.compute(next, (point, exist) ->
                                exist == null || exist.size < shark.size ? shark : exist);
                    }
                }
            }

            for (Point point : map.keySet()) {
                field[point.x][point.y] = map.get(point);
            }
        }

        System.out.println(result);
    }

    public static boolean isInRange(int x, int y) {
        return x >= 1 && y >= 1 && x <= row && y <= column;
    }

    public static int change(int dir) {
        switch (dir) {
            case 0 : return 1;
            case 1 : return 0;
            case 2 : return 3;
            default: return 2;
        }
    }
}