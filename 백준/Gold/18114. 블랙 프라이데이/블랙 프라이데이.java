import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer line;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        line = new StringTokenizer(input.readLine());
        int num = Integer.parseInt(line.nextToken());
        int condition = Integer.parseInt(line.nextToken());

        line = new StringTokenizer(input.readLine());
        int[] goods = new int[num];
        for (int i = 0; i < num; i++) {
            int good = Integer.parseInt(line.nextToken());
            if (good == condition) {
                System.out.println(1);
                return;
            }

            goods[i] = good;
        }

        Arrays.sort(goods);

        int start = 0, end = num - 1;
        while (start < end) {
            int sum = goods[start] + goods[end];
            if (sum > condition) {
                end--;
            } else if (sum == condition) {
                System.out.println(1);
                return;
            } else {
                for (int i = start + 1; i < end; i++) {
                    if (goods[i] == condition - sum) {
                        System.out.println(1);
                        return;
                    }
                }

                start++;
            }
        }

        System.out.println(0);
    }
}