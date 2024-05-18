import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer condition = new StringTokenizer(input.readLine());
        int num = Integer.parseInt(condition.nextToken());
        int target = Integer.parseInt(condition.nextToken());

        int[] coins = new int[num];
        int[] dp = new int[target + 1];
        for (int i = 0; i < num; i++) {
            coins[i] = Integer.parseInt(input.readLine());
        }

        dp[0] = 1;
        for (int i = 0; i < num; i++) {
            for (int j = coins[i]; j <= target; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        System.out.println(dp[target]);
    }
}