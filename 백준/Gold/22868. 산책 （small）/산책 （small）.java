import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    static class Way {
        int current;
        int count;
        public Way(int current, int count) {
            this.current = current;
            this.count = count;
        }
    }
    static StringTokenizer line;
    static int nodeNum, roadNum, result;
    static boolean[] visit;
    static int[] route;
    static List<List<Integer>> roads = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        line = new StringTokenizer(input.readLine());
        nodeNum = Integer.parseInt(line.nextToken());
        roadNum = Integer.parseInt(line.nextToken());

        visit = new boolean[nodeNum];
        route = new int[nodeNum];

        for (int i = 0; i < nodeNum; i++) {
            roads.add(new ArrayList<>());
        }

        for (int i = 0; i < roadNum; i++) {
            line = new StringTokenizer(input.readLine());
            int first = Integer.parseInt(line.nextToken()) - 1;
            int second = Integer.parseInt(line.nextToken()) - 1;

            roads.get(first).add(second);
            roads.get(second).add(first);
        }

        for (int i = 0; i < nodeNum; i++) {
            Collections.sort(roads.get(i));
        }

        line = new StringTokenizer(input.readLine());
        int start = Integer.parseInt(line.nextToken()) - 1;
        int end = Integer.parseInt(line.nextToken()) - 1;

        bfs(start, end);

        Arrays.fill(visit, false);
        int last = route[end];
        while (last > 0) {
            visit[last] = true;
            last = route[last];
        }

        bfs(end, start);

        System.out.println(result);
    }

    public static void bfs(int start, int end) {
        Queue<Way> queue = new LinkedList<>();
        queue.offer(new Way(start, 0));
        visit[start] = true;

        while (!queue.isEmpty()) {
            Way way = queue.poll();

            for (int next : roads.get(way.current)) {
                if (!visit[next]) {
                    visit[next] = true;
                    route[next] = way.current;
                    queue.offer(new Way(next, way.count + 1));
                }

                if (next == end) {
                    result += way.count + 1;
                    return;
                }
            }
        }
    }
}