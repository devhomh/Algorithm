import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int num;
    static int[] arr, operators;
    
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(input.readLine());
        arr = Stream.of(input.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        operators = Stream.of(input.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < 4; i++) {
            if (operators[i] != 0) {
                operators[i]--;
                dfs(1, arr[0], i);
                operators[i]++;
            }
        }

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth, int value, int operator) {
        int result = calculate(depth, value, operator);

        if (depth == num - 1) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] != 0) {
                operators[i]--;
                dfs(depth + 1, result, i);
                operators[i]++;
            }
        }
    }

    public static int calculate(int index, int value, int operator) {
        switch (operator) {
            case 0 :
                return value + arr[index];
            case 1 :
                return value - arr[index];
            case 2:
                return value * arr[index];
            default:
                return value / arr[index];
        }
    }
}