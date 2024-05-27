import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static int totalBudget;
    static int[] regions;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        StringTokenizer line = new StringTokenizer(input.readLine());

        regions = new int[num];
        for (int i = 0; i < num; i++) {
            regions[i] = Integer.parseInt(line.nextToken());
        }

        totalBudget = Integer.parseInt(input.readLine());

        Arrays.sort(regions);
        int low = 1;
        int high = regions[num - 1];
        if (IntStream.of(regions).sum() <= totalBudget) {
            System.out.println(high);
            return;
        }

        while (low + 1 < high) {
            int mid = (high + low) / 2;

            if (isWithinBudget(mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }

        System.out.println(low);
    }

    public static boolean isWithinBudget(int boundary) {
        int result = 0;
        for (int region : regions) {
            result += Math.min(boundary, region);
        }

        return result <= totalBudget;
    }
}