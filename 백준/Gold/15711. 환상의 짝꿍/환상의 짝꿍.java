import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Long> list = new ArrayList<>();
    static boolean[] arr = new boolean[2000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr[0] = arr[1] = true;
        for (int i = 2; i < arr.length; i++) {
            if (!arr[i]) {
                list.add((long) i);
                for (int j = i * 2; j < arr.length; j += i) {
                    arr[j] = true;
                }
            }
        }

        int testCase = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            long one = Long.parseLong(st.nextToken());
            long another = Long.parseLong(st.nextToken());
            result.append(judge(one + another) ? "YES" : "NO").append("\n");
        }

        System.out.println(result);
    }

    public static boolean judge(long num) {
        if (num < 4) {
            return false;
        }

        if (num % 2 == 1) {
            return isPrime(num - 2);
        }

        return true;
    }

    public static boolean isPrime(long num) {
        if (num < arr.length) {
            return !arr[(int) num];
        }
        for (Long val : list) {
            if (num % val == 0) {
                return false;
            }
        }

        return true;
    }
}