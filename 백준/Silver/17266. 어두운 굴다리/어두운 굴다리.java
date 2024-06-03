import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int length, num;
    static int[] location;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        length = Integer.parseInt(input.readLine());
        num = Integer.parseInt(input.readLine());

        location = new int[num];
        StringTokenizer line = new StringTokenizer(input.readLine());
        for (int i = 0; i < num; i++) {
            location[i] = Integer.parseInt(line.nextToken());
        }

        int min = 1;
        int max = length;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (possible(mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min);
    }

    public static boolean possible(int height) {
        int prev = 0;
        for (int i = 0; i < num; i++) {
            if (location[i] - height <= prev) {
                prev = location[i] + height;
            } else {
                return false;
            }
        }

        return length - prev <= 0;
    }
}