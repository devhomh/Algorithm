import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int row, column;
    static int result = Integer.MIN_VALUE;
    static int[][] board;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(input.readLine());
        row = Integer.parseInt(line.nextToken());
        column = Integer.parseInt(line.nextToken());
        board = new int[row][column];
        visit = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            line = new StringTokenizer(input.readLine());
            for (int j = 0; j < column; j++) {
                board[i][j] = Integer.parseInt(line.nextToken());
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                visit[i][j] = true;
                dfs(1, board[i][j], i, j);
                visit[i][j] = false;
                special(i, j);
            }
        }
        System.out.println(result);
    }
    
    public static void dfs(int depth, int sum, int currentRow, int currentColumn) {
        if (depth == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextRow = currentRow + dx[i];
            int nextColumn= currentColumn + dy[i];
            if (isInRange(nextRow, nextColumn)) {
                if (!visit[nextRow][nextColumn]) {
                    visit[nextRow][nextColumn] = true;
                    dfs(depth + 1, sum + board[nextRow][nextColumn], nextRow, nextColumn);
                    visit[nextRow][nextColumn] = false;
                }
            }
        }
    }

    public static void special(int currentRow, int currentColumn) {
        for (int i = 0; i < 4; i++) {
            int sum = board[currentRow][currentColumn];
            int count = 0;
            for (int j = 0; j < 4; j++) {
                int nextRow = currentRow + dx[j];
                int nextColumn = currentColumn + dy[j];
                if (j != i && isInRange(nextRow, nextColumn)) {
                    sum += board[nextRow][nextColumn];
                    count++;
                }
            }

            if (count == 3) {
                result = Math.max(result, sum);
            }
        }
    }


    public static boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < column;
    }
}