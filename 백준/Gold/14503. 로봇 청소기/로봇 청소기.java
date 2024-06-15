import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int row, column;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(input.readLine());
        row = Integer.parseInt(line.nextToken());
        column = Integer.parseInt(line.nextToken());

        line = new StringTokenizer(input.readLine());
        int vacuumRow = Integer.parseInt(line.nextToken());
        int vacuumColumn = Integer.parseInt(line.nextToken());
        int dir = Integer.parseInt(line.nextToken());
        boolean[][] visit = new boolean[row][column];
        int[][] map = new int[row][column];
        for (int i = 0; i < row; i++) {
            line = new StringTokenizer(input.readLine());
            for (int j = 0; j < column; j++) {
                map[i][j] = Integer.parseInt(line.nextToken());
            }
        }

        int count = 0;
        while (true) {
            if (!visit[vacuumRow][vacuumColumn]) {
                count++;
                visit[vacuumRow][vacuumColumn] = true;
            }

            boolean existAround = false;
            for (int i = 0; i < 4; i++) {
                dir = dir == 0 ? 3 : dir - 1;
                int nextRow = vacuumRow + dx[dir];
                int nextColumn = vacuumColumn + dy[dir];

                if (isInRange(nextRow, nextColumn) && map[nextRow][nextColumn] == 0 && !visit[nextRow][nextColumn]) {
                    existAround = true;
                    count++;
                    visit[nextRow][nextColumn] = true;
                    vacuumRow = nextRow;
                    vacuumColumn = nextColumn;
                    break;
                }
            }

            if (!existAround) {
                int prevRow = vacuumRow - dx[dir];
                int prevColumn = vacuumColumn - dy[dir];
                if (isInRange(prevRow, prevColumn) && map[prevRow][prevColumn] == 0) {
                    vacuumRow = prevRow;
                    vacuumColumn = prevColumn;
                } else {
                    System.out.println(count);
                    break;
                }
            }
        }
    }

    public static boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < column;
    }
}