import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int row, column;
    static int result = -1;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(input.readLine());
        column = Integer.parseInt(line.nextToken());
        int num = Integer.parseInt(line.nextToken());
        row = Integer.parseInt(line.nextToken());

        if (num == 0) {
            System.out.println(0);
            return;
        }

        // 0 = 왼쪽으로
        // 1 = 밑으로
        // 2 = 오른쪽으로
        board = new int[row + 2][column + 1];
        for (int i = 0; i < row + 2; i++) {
            Arrays.fill(board[i], 1);
        }
        for (int i = 0; i < num; i++) {
            line = new StringTokenizer(input.readLine());
            int tmpRow = Integer.parseInt(line.nextToken());
            int tmpColumn = Integer.parseInt(line.nextToken());
            board[tmpRow][tmpColumn] = 2;
            board[tmpRow][tmpColumn + 1] = 0;
        }

        dfs(0, 1);
        System.out.println(result);
    }

    public static void dfs(int depth, int start) {
        if (depth > 3) {
            return;
        }

        if (possible()) {
            if (result == -1) {
                result = depth;
            } else {
                result = Math.min(result, depth);
            }

            return;
        }

        for (int i = start; i <= row; i++) {
            for (int j = 1; j < column; j++) {
                if (board[i][j] == 1 && board[i][j + 1] == 1) {
                    board[i][j] = 2;
                    board[i][j + 1] = 0;
                    dfs(depth + 1, i);
                    board[i][j] = board[i][j + 1] = 1;
                }
            }
        }
    }

    public static boolean possible() {
        for (int i = 1; i <= column; i++) {
            int currentRow = 1;
            int currentColumn = i;

            while (currentRow != row + 1) {
                int dir = board[currentRow][currentColumn];
                if (dir == 1) {
                    currentRow++;
                } else if (dir == 2) {
                    currentColumn++;
                    currentRow++;
                } else {
                    currentRow++;
                    currentColumn--;
                }
            }

            if (currentColumn != i) {
                return false;
            }
        }

        return true;
    }
}