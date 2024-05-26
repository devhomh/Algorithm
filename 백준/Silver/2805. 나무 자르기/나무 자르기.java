import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(input.readLine());
        int num = Integer.parseInt(line.nextToken());
        long target = Integer.parseInt(line.nextToken());

        int[] trees = new int[num];
        line = new StringTokenizer(input.readLine());
        for (int i = 0; i < num; i++) {
            trees[i] = Integer.parseInt(line.nextToken());
        }

        Arrays.sort(trees);

        int min = 0;
        int max = trees[num - 1];

        while (min < max) {
            int mid = (max + min) / 2;
            long sum = 0;
            for (int tree : trees) {
                if (sum >= target) {
                    break;
                }

                if (tree > mid) {
                    sum += tree - mid;
                }
            }

            if (sum >= target) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        System.out.println(min - 1);
    }
}