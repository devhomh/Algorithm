import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        int[] wines = new int[10001];
        int[] dp = new int[10001];
        for (int i = 1; i <= num; i++) {
            wines[i] = Integer.parseInt(input.readLine());
        }

        dp[0] = 0;
        dp[1] = wines[1];
        dp[2] = wines[1] + wines[2];
        for (int i = 3; i <= num; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wines[i], dp[i - 3] + wines[i - 1] + wines[i]));
        }

        System.out.println(dp[num]);
    }
}