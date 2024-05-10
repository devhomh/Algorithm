import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int num;

    private static int result = 0;

    private static int integer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        num = Integer.parseInt(firstLine[0]);
        integer = Integer.parseInt(firstLine[1]);

        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, arr);

        System.out.println(integer == 0 ? result - 1 : result);
    }
    public static void dfs(int sum, int index, int[] arr) {
        if (index == num) {
            if (sum == integer) {
                result++;
            }

            return;
        }

        dfs(sum + arr[index], index + 1, arr);
        dfs(sum, index + 1, arr);
    }
}