import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(input.readLine());
        int row = Integer.parseInt(line.nextToken());
        int column = Integer.parseInt(line.nextToken());
        int[][][] dp = new int[row][column][3];
        int[][] map = new int[row][column];
        for (int i = 0; i < row; i++) {
            line = new StringTokenizer(input.readLine());
            for (int j = 0; j < column; j++) {
                map[i][j] = Integer.parseInt(line.nextToken());
                Arrays.fill(dp[i][j], i == 0 ? map[i][j] : Integer.MAX_VALUE);
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (j == 0) {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + map[i][j];
                    dp[i][j][1] = dp[i - 1][j][0] + map[i][j];
                } else if (j == column - 1) {
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + map[i][j];
                    dp[i][j][1] = dp[i - 1][j][2] + map[i][j];
                } else {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + map[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + map[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + map[i][j];
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < 3; j++) {
                result = Math.min(dp[row - 1][i][j], result);
            }
        }

        System.out.println(result);
    }
}