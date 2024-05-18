import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static Integer[] dp;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        arr = new int[num];
        dp = new Integer[num];

        StringTokenizer line = new StringTokenizer(input.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(line.nextToken());
        }
        dp[0] = arr[0];
        max = arr[0];
        solution(num - 1);

        System.out.println(max);
    }

    public static int solution(int num) {
        if (dp[num] == null) {
            dp[num] = Math.max(solution(num - 1) + arr[num], arr[num]);
            max = Math.max(max, dp[num]);
        }

        return dp[num];
    }
}
