import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line;
        int num = Integer.parseInt(input.readLine());
        boolean[] switches = new boolean[num];
        line = new StringTokenizer(input.readLine());
        for (int i = 0; i < num; i++) {
            switches[i] = Integer.parseInt(line.nextToken()) == 1;
        }

        int studentNum = Integer.parseInt(input.readLine());
        for (int i = 0; i < studentNum; i++) {
            line = new StringTokenizer(input.readLine());
            int gender = Integer.parseInt(line.nextToken());
            int index = Integer.parseInt(line.nextToken()) - 1;

            if (gender == 1) {
                for (int j = index; j < num; j += index + 1) {
                    switches[j] = !switches[j];
                }
            } else {
                switches[index] = !switches[index];
                for (int j = 1; index + j < num && index - j >= 0; j++) {
                    if (switches[index + j] == switches[index - j]) {
                        switches[index + j] = switches[index - j] = !switches[index + j];
                    } else {
                        break;
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num; i++) {
            result.append(switches[i] ? 1 : 0).append(" ");
            if ((i + 1) % 20 == 0) {
                result.append("\n");
            }
        }

        System.out.println(result);
    }
}