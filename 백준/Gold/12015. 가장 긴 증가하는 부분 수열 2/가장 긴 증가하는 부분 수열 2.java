import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        int[] arr = Stream.of(input.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] LIS = new int[num];

        LIS[0] = arr[0];
        int length = 1;
        for (int i = 1; i < num; i++) {
            int key = arr[i];
            if (LIS[length - 1] < key) {
                length++;
                LIS[length - 1] = key;
            } else {
                int low = 0;
                int high = length;
                while (low < high) {
                    int mid = (high + low) / 2;
                    if (LIS[mid] < key) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }

                LIS[low] = key;
            }
        }

        System.out.println(length);
    }
}