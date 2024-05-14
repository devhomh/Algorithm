import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] dp = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(input.readLine());

        dp[0][0] = dp[1][1] = 1;
        dp[0][1] = dp[1][0] = 0;

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(input.readLine());
            int[] arr = fibonacci(num);
            result.append(arr[0]).append(" ").append(arr[1]).append("\n");
        }

        System.out.println(result);
    }

    public static int[] fibonacci(int num) {
        if (dp[num][0] == 0 && dp[num][1] == 0) {
            dp[num][0] = fibonacci(num -1)[0] + fibonacci(num - 2)[0];
            dp[num][1] = fibonacci(num - 1)[1] + fibonacci(num - 2)[1];
        }

        return dp[num];
    }
}