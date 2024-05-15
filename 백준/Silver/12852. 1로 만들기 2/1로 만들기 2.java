import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        int[] dp = new int[num + 1];
        int[] trace = new int[num + 1];
        dp[0] = dp[1] = 0;

        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i - 1] + 1;
            trace[i] = i - 1;

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                trace[i] = i / 3;
            }

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                trace[i] = i / 2;
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(dp[num]).append("\n");

        int tmp = num;
        while (tmp != 0) {
            result.append(tmp).append(" ");
            tmp = trace[tmp];
        }

        System.out.println(result);
    }
}