import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        StringTokenizer line;
        int[] roads = new int[num - 1];
        int[] cities = new int[num];

        line = new StringTokenizer(input.readLine());
        for (int i = 0; i < num - 1; i++) {
            roads[i] = Integer.parseInt(line.nextToken());
        }

        line = new StringTokenizer(input.readLine());
        for (int i = 0; i < num; i++) {
            cities[i] = Integer.parseInt(line.nextToken());
        }

        int total = 0;
        total += roads[0] * cities[0];
        int cityIndex = 0;
        int roadIndex = 1;
        while (roadIndex != num - 1) {
            if (cities[cityIndex] > cities[cityIndex + 1]) {
                cityIndex++;
            }

            total += cities[cityIndex] * roads[roadIndex++];
        }

        System.out.println(total);
    }
}