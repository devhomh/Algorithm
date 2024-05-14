import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line;
        int num = Integer.parseInt(input.readLine());

        int[][] dp = new int[num + 1][3];
        for (int i = 1; i <= num; i++) {
            line = new StringTokenizer(input.readLine());
            int red = Integer.parseInt(line.nextToken());
            int green = Integer.parseInt(line.nextToken());
            int blue = Integer.parseInt(line.nextToken());

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + red;
            dp[i][1] = Math.min(dp[i - 1][2], dp[i - 1][0]) + green;
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + blue;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[num][i]);
        }

        System.out.println(min);
    }
}