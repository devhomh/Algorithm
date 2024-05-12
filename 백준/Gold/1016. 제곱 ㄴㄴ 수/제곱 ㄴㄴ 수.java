import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(br.readLine());

        long min = Long.parseLong(line.nextToken());
        long max = Long.parseLong(line.nextToken());
        boolean[] arr = new boolean[(int) (max - min + 1)];
        int count = 0;

        for (long i = 2; i * i <= max; i++) {
            long powerNum = i * i;
            long square = min % powerNum == 0 ? min / powerNum : (min / powerNum) + 1;
            for (long j = square; powerNum * j <= max; j++) {
                arr[(int) (j * powerNum - min)] = true;
            }
        }

        for (boolean element : arr) {
            if (!element) {
                count++;
            }
        }

        System.out.println(count);
    }
}