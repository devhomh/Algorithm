import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int num;
    static int[] cards, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(input.readLine());
        cards = new int[num + 1];
        dp = new int[num + 1];
        StringTokenizer line = new StringTokenizer(input.readLine());
        for (int i = 1; i <= num; i++) {
            cards[i] = Integer.parseInt(line.nextToken());
            for (int j = 0; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + cards[j]);
            }
        }

        System.out.println(dp[num]);
    }
}