import java.io.*;
import java.util.Arrays;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine());

        long[][] dp = new long[64][10];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = i + 1;
        }

        for (int i = 2; i < 64; i++) {
            for (int j = 0; j <= 9; j++) {
                long sum = 0L;
                for (int k = 0; k <= j; k++) {
                    sum += dp[i - 1][k];
                }

                dp[i][j] = sum;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(input.readLine());
            result.append(LongStream.of(dp[num - 1]).sum()).append("\n");
        }

        System.out.println(result);
    }
}