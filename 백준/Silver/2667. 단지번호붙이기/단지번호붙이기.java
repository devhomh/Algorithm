import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int size, complex, count;
    static int[][] map;
    static boolean[][] visit;
    static List<Integer> units = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(input.readLine());

        map = new int[size][size];
        visit = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            String line = input.readLine();
            for (int j = 0; j < size; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    count = 0;
                    complex++;
                    dfs(i, j);
                    units.add(count);
                }
            }
        }

        Collections.sort(units);

        StringBuilder result = new StringBuilder();
        result.append(complex).append("\n");
        units.forEach(unit -> result.append(unit).append("\n"));

        System.out.println(result);
    }

    public static void dfs(int x, int y) {
        visit[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < size && ny < size) {
                if (map[nx][ny] == 1 && !visit[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}