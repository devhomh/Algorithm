import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer condition = new StringTokenizer(input.readLine());
        int length = Integer.parseInt(condition.nextToken());
        int range = Integer.parseInt(condition.nextToken());
        char[] line = input.readLine().toCharArray();
        boolean[] visit = new boolean[length];

        int count = 0;
        for (int i = 0; i < length; i++) {
            if (line[i] == 'P') {
                for (int j = i - range; j <= i + range; j++) {
                    if (j >= 0 && j < length) {
                        if (!visit[j] && line[j] == 'H') {
                            visit[j] = true;
                            count++;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}