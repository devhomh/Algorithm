import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        int target = Integer.parseInt(input.readLine());

        int min = 1;
        int max = target;
        while (min < max) {
            int mid = (max + min) / 2;
            int count = 0;
            for (int i = 1; i <= num; i++) {
                count += Math.min(mid / i, num);
            }

            if (count >= target) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min);
    }
}