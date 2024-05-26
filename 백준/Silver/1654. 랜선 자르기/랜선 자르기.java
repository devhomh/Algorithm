import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int num, target;
    static long[] cables;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(input.readLine());
        num = Integer.parseInt(line.nextToken());
        target = Integer.parseInt(line.nextToken());

        cables = new long[num];
        for (int i = 0; i < num; i++) {
            cables[i] = Integer.parseInt(input.readLine());
        }

        Arrays.sort(cables);

        long min = 1;
        long max = cables[num - 1];
        if (check(max)) {
            System.out.println(max);
            return;
        }

        while (min + 1 < max) {
            long mid = (min + max) / 2;
            if (check(mid)) {
                min = mid;
            } else {
                max = mid;
            }
        }

        System.out.println(min);
    }

    public static boolean check(long standard) {
        long result = 0;

        for (long cable : cables) {
            if (cable >= standard) {
                result += cable / standard;
            }
        }

        return result >= target;
    }
}