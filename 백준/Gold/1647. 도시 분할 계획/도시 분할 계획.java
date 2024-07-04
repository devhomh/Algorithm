import java.io.*;
import java.util.*;

public class Main {
    public static class Road {
        int left;
        int right;
        int value;

        public Road(int left, int right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
    static StringTokenizer line;
    static int homeNum, roadNum, result;
    static int max = Integer.MIN_VALUE;
    static int[] parent;
    static List<Road> roads = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        line = new StringTokenizer(input.readLine());
        homeNum = Integer.parseInt(line.nextToken());
        roadNum = Integer.parseInt(line.nextToken());

        parent = new int[homeNum + 1];
        for (int i = 1; i <= homeNum; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < roadNum; i++) {
            line = new StringTokenizer(input.readLine());
            int left = Integer.parseInt(line.nextToken());
            int right = Integer.parseInt(line.nextToken());
            int value = Integer.parseInt(line.nextToken());

            result += value;
            roads.add(new Road(left, right, value));
        }

        kruskal();

        System.out.println(result - max);
    }

    public static void kruskal() {
        roads.sort(Comparator.comparingInt(road -> road.value));
        for (Road road : roads) {
            if (find(road.left) != find(road.right)) {
                union(road);
                max = Math.max(road.value, max);
            } else {
                result -= road.value;
            }
        }
    }

    public static void union(Road road) {
        parent[find(road.right)] = find(road.left);
    }

    public static int find(int index) {
        if (parent[index] == index) {
            return index;
        }

        return parent[index] = find(parent[index]);
    }
}