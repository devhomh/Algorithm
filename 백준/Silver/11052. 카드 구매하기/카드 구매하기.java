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
        }

        dp[1] = cards[1];
        solution(num);

        System.out.println(dp[num]);
    }

    public static int solution(int target) {
        if (dp[target] == 0) {
            for (int i = 1; i <= target; i++) {
                dp[target] = Math.max(cards[target], Math.max(dp[target], solution(target - i) + solution(i)));
            }
        }

        return dp[target];
    }
}