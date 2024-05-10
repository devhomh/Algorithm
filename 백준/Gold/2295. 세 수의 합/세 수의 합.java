import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] sum = new int[num * num];
        int count = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                sum[count] = arr[i] + arr[j];
                count++;
            }
        }

        Arrays.sort(sum);
        int max = Integer.MIN_VALUE;

        for (int i = num - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                if (Arrays.binarySearch(sum, arr[i] - arr[j]) >= 0) {
                    max = Math.max(max, arr[i]);
                }
            }
        }

        System.out.println(max);
    }
}