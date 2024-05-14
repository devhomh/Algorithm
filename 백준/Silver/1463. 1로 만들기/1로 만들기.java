import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp = new int[1_000_000 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());

        System.out.println(function(num));
    }

    public static int function(int num) {
        if (num == 1) {
            return 0;
        }

        if (dp[num] == 0) {
            if (num % 6 == 0) {
                dp[num] = Math.min(function(num / 3), Math.min(function(num / 2), function(num - 1))) + 1;
            } else if (num % 3 == 0) {
                dp[num] = Math.min(function(num / 3), function(num - 1)) + 1;
            } else if (num % 2 == 0) {
                dp[num] = Math.min(function(num / 2), function(num - 1)) + 1;
            } else {
                dp[num] = function(num - 1) + 1;
            }
        }

        return dp[num];
    }
}