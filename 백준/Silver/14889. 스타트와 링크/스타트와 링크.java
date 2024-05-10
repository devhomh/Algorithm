import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int num;
    public static int min = Integer.MAX_VALUE;
    public static int[][] matrix;
    public static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line;
        num = Integer.parseInt(br.readLine());
        arr = new boolean[num];
        matrix = new int[num][num];

        for (int i = 0; i < num; i++) {
            line = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                matrix[i][j] = Integer.parseInt(line.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(min);
    }

    public static void dfs(int depth, int start) {
        if (depth == num / 2) {
            diff();
            return;
        }

        for (int i = start; i < num; i++) {
            arr[i] = true;
            dfs(depth + 1, i + 1);
            arr[i] = false;
        }
    }

    public static void diff() {
        int teamStart = 0;
        int teamLink = 0;

        for (int i = 0; i < num - 1; i++) {
            for (int j = i + 1; j < num; j++) {
                if (arr[i] && arr[j]) {
                    teamStart += matrix[i][j];
                    teamStart += matrix[j][i];
                }

                else if (!arr[i] && !arr[j]) {
                    teamLink += matrix[i][j];
                    teamLink += matrix[j][i];
                }
            }
        }

        min = Math.min(min, Math.abs(teamStart - teamLink));
    }
}