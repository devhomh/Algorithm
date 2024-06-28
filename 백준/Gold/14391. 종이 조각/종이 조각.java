import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int row, column, result;
    static int[][] board;
    static boolean[][] isHorizontal;
    static StringTokenizer condition;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        condition = new StringTokenizer(input.readLine());
        row = Integer.parseInt(condition.nextToken());
        column = Integer.parseInt(condition.nextToken());

        isHorizontal = new boolean[row][column];
        board = new int[row][column];
        for (int i = 0; i < row; i++) {
            String line = input.readLine();
            for (int j = 0; j < column; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        dfs(1);

        System.out.println(result);
    }

    public static void dfs(int depth) {
        if (depth > row * column) {
            result = Math.max(result, calculate());
            return;
        }

        int x = depth % column == 0 ? depth / column - 1:  depth / column;
        int y = depth % column == 0 ? column - 1 : depth % column - 1;
        isHorizontal[x][y] = true;
        dfs(depth + 1);
        isHorizontal[x][y] = false;
        dfs(depth + 1);
    }

    public static int calculate() {
        int sum = 0;
        for (int i = 0; i < row; i++) {
            int tmp = 0;
            for (int j = 0; j < column; j++) {
                if (isHorizontal[i][j]) {
                    tmp *= 10;
                    tmp += board[i][j];
                } else {
                    sum += tmp;
                    tmp = 0;
                }
            }

            sum += tmp;
        }

        for (int i = 0; i < column; i++) {
            int tmp = 0;
            for (int j = 0; j < row; j++) {
                if (!isHorizontal[j][i]) {
                    tmp *= 10;
                    tmp += board[j][i];
                } else {
                    sum += tmp;
                    tmp = 0;
                }
            }

            sum += tmp;
        }

        return sum;
    }
}