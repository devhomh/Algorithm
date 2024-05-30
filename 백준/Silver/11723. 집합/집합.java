import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        boolean[] arr = new boolean[21];

        StringTokenizer line;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num; i++) {
            line = new StringTokenizer(input.readLine());
            String command = line.nextToken();
            if (command.equals("all")) {
                Arrays.fill(arr, true);
            } else if (command.equals("empty")) {
                Arrays.fill(arr, false);
            } else {
                int element = Integer.parseInt(line.nextToken());
                switch (command) {
                    case "add":
                        arr[element] = true;
                        break;
                    case "remove":
                        arr[element] = false;
                        break;
                    case "check":
                        result.append(arr[element] ? 1 : 0).append("\n");
                        break;
                    default:
                        arr[element] = !arr[element];
                        break;
                }
            }
        }

        System.out.println(result);
    }
}