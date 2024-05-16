import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Location {
        int x;
        int y;
        int z;

        public Location(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<Location> queue = new LinkedList<>();
    static int row, column, depth;
    static int[][][] box;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(input.readLine());

        column = Integer.parseInt(line.nextToken());
        row = Integer.parseInt(line.nextToken());
        depth = Integer.parseInt(line.nextToken());
        box = new int[row][column][depth];

        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < row; j++) {
                line = new StringTokenizer(input.readLine());
                for (int k = 0; k < column; k++) {
                    int tomato = Integer.parseInt(line.nextToken());
                    box[j][k][i] = tomato;

                    if (tomato == 1) {
                        queue.add(new Location(j, k, i));
                    }
                }
            }
        }

        bfs();
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Location current = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int nz = current.z + dz[i];

                if (!isInRange(nx, ny, nz)) {
                    continue;
                }

                if (box[nx][ny][nz] == 0) {
                    box[nx][ny][nz] = box[current.x][current.y][current.z] + 1;
                    queue.add(new Location(nx, ny, nz));
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
                    for (int k = 0; k < depth; k++) {
                        result = Math.max(result, box[i][j][k]);
                    }
                }
            }
        }

        System.out.println(result - 1);
    }

    public static boolean possible() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                for (int k = 0; k < depth; k++) {
                    if (box[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static boolean isInRange(int x, int y, int z) {
        return x >= 0 && y >= 0 && z >= 0 && x < row && y < column && z < depth;
    }
}