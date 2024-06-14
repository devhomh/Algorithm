import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testNum = Integer.parseInt(input.readLine());
        int[] tests = new int[testNum];
        StringTokenizer line = new StringTokenizer(input.readLine());
        for (int i = 0; i < testNum; i++) {
            tests[i] = Integer.parseInt(line.nextToken());
        }

        line = new StringTokenizer(input.readLine());
        int main = Integer.parseInt(line.nextToken());
        int sub = Integer.parseInt(line.nextToken());

        long result = testNum;
        for (int i = 0; i < testNum; i++) {
            if (tests[i] > main) {
                int remain = tests[i] - main;
                result += remain % sub == 0 ? remain / sub : remain / sub + 1;
            }
        }

        System.out.println(result);
    }
}