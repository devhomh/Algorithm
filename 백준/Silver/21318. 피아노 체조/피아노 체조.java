import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer line;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        int count = 0;
        int[] mistakes = new int[num - 1];
        line = new StringTokenizer(input.readLine());
        int current = Integer.parseInt(line.nextToken());
        for (int i = 1; i < num; i++) {
            int next = Integer.parseInt(line.nextToken());
            if (current > next) {
                count++;
            }

            mistakes[i - 1] = count;
            current = next;
        }

        StringBuilder result = new StringBuilder();
        int testNum = Integer.parseInt(input.readLine());
        for (int i = 0; i < testNum; i++) {
            line = new StringTokenizer(input.readLine());
            int min = Integer.parseInt(line.nextToken()) - 1;
            int max = Integer.parseInt(line.nextToken()) - 1;
            
            if (min == max) {
                result.append(0).append("\n");
            } else {
                result.append(min == 0 ? mistakes[max - 1] : mistakes[max - 1] - mistakes[min - 1]).append("\n");
            }
        }

        System.out.println(result);
    }
}