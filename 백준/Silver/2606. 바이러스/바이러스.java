import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int computerNum, linkNum, result;
    static boolean[] visit;
    static boolean[][] link;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line;

        computerNum = Integer.parseInt(input.readLine());
        linkNum = Integer.parseInt(input.readLine());

        visit = new boolean[computerNum + 1];
        link = new boolean[computerNum + 1][computerNum + 1];

        for (int i = 0; i < linkNum; i++) {
            line = new StringTokenizer(input.readLine());
            int x = Integer.parseInt(line.nextToken());
            int y = Integer.parseInt(line.nextToken());

            link[x][y] = link[y][x] = true;
        }

        bfs(1);

        System.out.println(result);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visit[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 1; i <= computerNum; i++) {
                if (link[current][i] && !visit[i]) {
                    visit[i] = true;
                    result++;
                    queue.add(i);
                }
            }
        }
    }
}