import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        StringTokenizer line;
        long[] roads = new long[num - 1];
        long[] cities = new long[num];

        line = new StringTokenizer(input.readLine());
        for (int i = 0; i < num - 1; i++) {
            roads[i] = Integer.parseInt(line.nextToken());
        }

        line = new StringTokenizer(input.readLine());
        for (int i = 0; i < num; i++) {
            cities[i] = Integer.parseInt(line.nextToken());
        }

        long total = 0;
        int cityIndex = 0;
        for (int i = 0; i < num - 1; i++) {
            if (cities[i] < cities[cityIndex]) {
                cityIndex = i;
            }

            total += roads[i] * cities[cityIndex];
        }

        System.out.println(total);
    }
}