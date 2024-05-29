import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        StringTokenizer line;
        int[][] board = new int[num][3];
        for (int i = 0; i < num; i++) {
            line = new StringTokenizer(input.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(line.nextToken());
            }
        }

        StringBuilder result = new StringBuilder();
        int[][] dp = new int[num + 1][3];
        Arrays.fill(dp[0], 0);
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = Math.max(dp[i - 1][0], dp[i - 1][1]) + board[i - 1][j];
                } else if (j == 1) {
                    dp[i][j] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2])) + board[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][1], dp[i - 1][2]) + board[i - 1][j];
                }
            }
        }

        Arrays.sort(dp[num]);
        result.append(dp[num][2]).append(" ");

        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][1]) + board[i - 1][j];
                } else if (j == 1) {
                    dp[i][j] = Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2])) + board[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][1], dp[i - 1][2]) + board[i - 1][j];
                }
            }
        }

        Arrays.sort(dp[num]);
        result.append(dp[num][0]);

        System.out.println(result);
    }
}