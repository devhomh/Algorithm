import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int gcd = 0;
        for (int i = 0; i < num - 1; i++) {
            int distance = arr[i + 1] - arr[i];
            gcd = gcd(distance, gcd);
        }
        int total = (arr[num - 1] - arr[0]) / gcd + 1;

        System.out.println(total - num);
    }

    public static int gcd (int max, int min) {
        return min == 0 ? max : gcd(min, max % min);
    }
}