import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int num, count;
    static int[] students;
    static boolean[] visit, check;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line;
        int testCase = Integer.parseInt(input.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            num = Integer.parseInt(input.readLine());
            count = num;
            line = new StringTokenizer(input.readLine());
            students = new int[num];
            visit = new boolean[num];
            check = new boolean[num];
            for (int j = 0; j < num; j++) {
                students[j] = Integer.parseInt(line.nextToken());
            }

            for (int j = 0; j < num; j++) {
                if (!check[j]) {
                    dfs(j);
                }
            }

            result.append(count).append("\n");
        }

        System.out.println(result);
    }

    public static void dfs(int start) {
        if (visit[start]) {
            check[start] = true;
            count--;
        } else {
            visit[start] = true;
        }

        int choice = students[start] - 1;
        if (!check[choice]) {
            dfs(choice);
        }

        visit[start] = false;
        check[start] = true;
    }
}