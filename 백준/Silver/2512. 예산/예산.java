import javax.print.attribute.IntegerSyntax;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static int num, limit;
    static int[] regions;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(input.readLine());
        regions = new int[num];
        StringTokenizer line = new StringTokenizer(input.readLine());
        for (int i = 0; i < num; i++) {
            regions[i] = Integer.parseInt(line.nextToken());
        }

        limit = Integer.parseInt(input.readLine());
        Arrays.sort(regions);

        int low = 1;
        int high = regions[num - 1];

        if (IntStream.of(regions).sum() <= limit) {
            System.out.println(high);
            return;
        }

        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (possible(mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }

        System.out.println(low);
    }

    public static boolean possible(int target) {
        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum += Math.min(target, regions[i]);
        }

        return sum <= limit;
    }
}