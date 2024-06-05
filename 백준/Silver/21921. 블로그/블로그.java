import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(input.readLine());
        int num = Integer.parseInt(line.nextToken());
        int target = Integer.parseInt(line.nextToken());
        int[] days = new int[num];
        line = new StringTokenizer(input.readLine());
        for (int i = 0; i < num; i++) {
            days[i] = Integer.parseInt(line.nextToken());
        }


        int sum = 0;
        for (int i = 0; i < target; i++) {
            sum += days[i];
        }

        int max = sum;
        int count = 1;
        for (int i = target; i < num; i++) {
            sum += days[i] - days[i - target];
            if (sum == max) {
                count++;
            }

            if (sum > max) {
                max = sum;
                count = 1;
            }
        }

        System.out.println(max == 0 ? "SAD" : max + "\n" + count);
    }
}