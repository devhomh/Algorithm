import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line;
        int num = Integer.parseInt(input.readLine());

        int[][] dp = new int[num + 1][num + 1];
        int[][] arr = new int[num + 1][num + 1];

        for (int i = 1; i <= num; i++) {
            line = new StringTokenizer(input.readLine());
            for (int j = 1; j <= i; j++) {
                arr[i][j] = Integer.parseInt(line.nextToken());
            }
        }

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
            }
        }

        int max = 0;
        for (int i = 1; i <= num; i++) {
            max = Math.max(max, dp[num][i]);
        }

        System.out.println(max);
    }
}