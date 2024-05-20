import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        int[] arr = new int[num];
        int[] dp = new int[num];
        StringTokenizer line = new StringTokenizer(input.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(line.nextToken());
        }

        for (int i = 0; i < num; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < num; i++) {
            max = Math.max(max, dp[i]);
        }
        
        System.out.println(max);
    }
}