import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());

        int[] stair = new int[300 + 1];
        int[] dp = new int[300 + 1];
        for (int i = 1; i <= num; i++) {
            stair[i] = Integer.parseInt(input.readLine());
        }

        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];

        for (int i = 3; i <= num; i++) {
            dp[i] = Math.max(dp[i - 3] + stair[i - 1], dp[i - 2]) + stair[i];
        }

        System.out.println(dp[num]);
    }
}