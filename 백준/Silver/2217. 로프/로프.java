import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        Integer[] arr = new Integer[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(input.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());
        int max = arr[0];
        for (int i = 2; i <= num; i++) {
            max = Math.max(max, arr[i - 1] * i);
        }

        System.out.println(max);
    }
}