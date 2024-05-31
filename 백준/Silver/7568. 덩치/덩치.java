import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        int[][] arr = new int[num][2];

        StringTokenizer line;
        for (int i = 0; i < num; i++) {
            line = new StringTokenizer(input.readLine());
            arr[i][0] = Integer.parseInt(line.nextToken());
            arr[i][1] = Integer.parseInt(line.nextToken());
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num; i++) {
            int ranking = 1;
            for (int j = 0; j < num; j++) {
                if (i != j && arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    ranking++;
                }
            }

            result.append(ranking).append(" ");
        }

        System.out.println(result);
    }
}