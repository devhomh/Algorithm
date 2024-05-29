import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        StringTokenizer line;
        // 슬라이딩 윈도우
        int[] min = new int[3];
        int[] max = new int[3];
        for (int i = 0; i < num; i++) {
            line = new StringTokenizer(input.readLine());
            int left = Integer.parseInt(line.nextToken());
            int mid = Integer.parseInt(line.nextToken());
            int right = Integer.parseInt(line.nextToken());

            if (i == 0) {
                min[0] = max[0] = left;
                min[1] = max[1] = mid;
                min[2] = max[2] = right;
            } else {
                int leftMin = Math.min(min[0], min[1]);
                int rightMin = Math.min(min[1], min[2]);

                min[0] = leftMin + left;
                min[1] = Math.min(leftMin, rightMin) + mid;
                min[2] = rightMin + right;

                int leftMax = Math.max(max[0], max[1]);
                int rightMax = Math.max(max[1], max[2]);

                max[0] = leftMax + left;
                max[1] = Math.max(leftMax, rightMax) + mid;
                max[2] = rightMax + right;
            }
        }

        int minVal = Math.min(min[0], Math.min(min[1], min[2]));
        int maxVal = Math.max(max[0], Math.max(max[1], max[2]));

        System.out.println(maxVal + " " + minVal);
    }
}