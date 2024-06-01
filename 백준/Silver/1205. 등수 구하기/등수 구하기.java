import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(input.readLine());
        int num = Integer.parseInt(line.nextToken());
        int score = Integer.parseInt(line.nextToken());
        int limit = Integer.parseInt(line.nextToken());

        if (num == 0) {
            System.out.println(1);
            return;
        }

        int ranking = 1;
        int count = 1;
        line = new StringTokenizer(input.readLine());
        for (int i = 0; i < num; i++) {
            int target = Integer.parseInt(line.nextToken());
            if (target > score) {
                ranking++;
                count++;
            } else if (target == score) {
                count++;
            } else {
                break;
            }
        }

        System.out.println(count > limit ? -1 : ranking);
    }
}