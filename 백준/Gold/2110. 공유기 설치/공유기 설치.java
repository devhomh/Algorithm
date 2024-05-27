import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int homeNum, routerNum;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer condition = new StringTokenizer(input.readLine());
        homeNum = Integer.parseInt(condition.nextToken());
        routerNum = Integer.parseInt(condition.nextToken());

        map = new int[homeNum];
        for (int i = 0; i < homeNum; i++) {
            map[i] = Integer.parseInt(input.readLine());
        }

        Arrays.sort(map);
        if (routerNum == 2) {
            System.out.println(map[homeNum - 1] - map[0]);
            return;
        }

        int low = 1;
        int high = map[homeNum - 1] - map[0];
        while (low + 1 < high) {
            int mid = (high + low) / 2;
            if (canInstalled(mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }

        System.out.println(low);
    }

    public static boolean canInstalled(int distance) {
        int count = 1;
        int prev = map[0];
        for (int i = 1; i < homeNum; i++) {
            int current = map[i];
            if (current - prev >= distance) {
                count++;
                prev = current;
            }
        }

        return count >= routerNum;
    }
}