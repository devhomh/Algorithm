import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int gcd = gcd(num1, num2);

        System.out.println(gcd);
        System.out.println(num1 * num2 / gcd);
    }

    public static int gcd(int x, int y) {
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        int remain;

        while (true) {
            remain = max % min;
            if (remain == 0) {
                return min;
            }

            max = min;
            min = remain;
        }
    }
}