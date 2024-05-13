import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] visit = new int[100_000 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(input.readLine());

        int subin = Integer.parseInt(line.nextToken());
        int sister = Integer.parseInt(line.nextToken());

        if (subin == sister) {
            System.out.println(0);
            return;
        }

        bfs(subin, sister);
    }

    public static void bfs(int subin, int sister) {
        Queue<Integer> queue = new LinkedList<>();
        visit[subin] = 1;
        queue.add(subin);

        while (!queue.isEmpty()) {
            int next = queue.poll();
            for (int i = 0; i < 3; i++) {
                int tmp = next;
                if (i == 0) {
                    tmp = tmp -1;
                } else if (i == 1) {
                    tmp = tmp + 1;
                } else {
                    tmp = tmp * 2;
                }

                if (tmp == sister){
                    System.out.println(visit[next]);
                    return;
                }

                if (tmp >= 0 && tmp <= 100_000 && visit[tmp] == 0) {
                    queue.add(tmp);
                    visit[tmp] = visit[next] + 1;
                }
            }
        }
    }
}